public class NBody {

    public static double readRadius(String file_name) {
        In in = new In(file_name);
        int N = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String file_name) {
        In in = new In(file_name);
        int N = in.readInt();
        in.readDouble();
        Planet[] allPlanet = new Planet[N];

        int i = 0;
        while (i < N) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double vX = in.readDouble();
            double vY = in.readDouble();
            double m = in.readDouble();
            String name = in.readString();
            allPlanet[i] = new Planet(xP, yP, vX, vY, m, name);
            i++;
        }
        return allPlanet;
    }

    public static void main(String[] args) {
        String filename = args[2];

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);


        //注意作用域和返回值类型
        double r = readRadius(filename);
        StdDraw.setScale(-r, r);
        Planet[] planets = readPlanets(filename);
        StdDraw.enableDoubleBuffering();
        double time = 0.0;

        for (; time < T; time += dt) {
            Double[] xForces = new Double[planets.length];
            Double[] yForces = new Double[planets.length];
            for(int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            String imageToDraw = "images/starfield.jpg";
            //Sacle的设置要根据题目上下文推断

            StdDraw.picture(0, 0, imageToDraw);


            for (Planet p : planets) {
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

        }
    }
}
