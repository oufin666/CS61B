public class Planet {
    public double xxPos;
    public  double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public  String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        double x ;
        x = Math.pow(Math.pow(p.xxPos - xxPos,2) + Math.pow(p.yyPos - yyPos,2), 0.5);
        return x;
    }
    public double calcForceExertedBy(Planet p){
        double x;
        x = 6.67e-11 * p.mass * mass/Math.pow(calcDistance(p),2);
        return x;
    }
    public double calcForceExertedByX (Planet p) {
        double x;
        x = (p.xxPos - xxPos) * calcForceExertedBy(p) / calcDistance(p);
        if (x < 0) {
            x = -x;
        }
        return x;
    }
    public double calcForceExertedByY(Planet p) {
        double x;
        x = (p.yyPos - yyPos) * calcForceExertedBy(p) / calcDistance(p);
        if (x < 0) {
            x = -x;
        }
        return x;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        int i;
        double x = 0;
        for(i = 0; i < allPlanets.length; i++){
            if (!this.equals(allPlanets[i])) {
                continue;
            }
            x += calcForceExertedByX(allPlanets[i]);

        }
    return x;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        int i;
        double x = 0;
        for(i = 0; i < allPlanets.length; i++){
            if (!this.equals(allPlanets[i])) {
                continue;
            }
            x += calcForceExertedByY(allPlanets[i]);
        }
        return x;
    }

    public void update(double t, double x, double y){
        double ax,ay;
        ax = x / mass;
        ay = y / mass;
        xxVel += ax * t;
        yyVel += ay * t;
        xxPos += xxVel * t;
        yyPos += yyVel * t;
    }
    public  void draw(){
        String name = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, name);
    }
}







