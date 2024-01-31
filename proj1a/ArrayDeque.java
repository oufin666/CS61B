
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private static final int INITIAL_CAPACITY = 8;
    private static final double USAGE_FACTOR_THRESHOLD = 0.25;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }



    public void addFirst(T item) {
        if (isFull()) {
            resizeBigger();
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;

        size++;
    }


    public void addLast(T item) {
        // Check if the array is full, and resize if necessary
        if (isFull()) {
            resizeBigger();
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }


    public T removeFirst() {
        // Check if the array is too sparse, and resize smaller if necessary
        if (isSparse()) {
            resizeSmaller();
        }

        // Check if there are elements to remove
        if (size == 0) {
            return null;
        }

        nextFirst = (nextFirst + 1 + items.length) % items.length;
        T removedItem = items[nextFirst];
        items[nextFirst] = null;
        size--;

        return removedItem;
    }



    public T removeLast() {

        if (isSparse()) {
            resizeSmaller();
        }

        if (size == 0) {
            return null;
        }

        int lastIndex = (nextLast - 1 + items.length) % items.length;

        T removedItem = items[lastIndex];

        items[lastIndex] = null;
        nextLast = lastIndex;
        size--;

        return removedItem;
    }


    public T get(int index) {

        if (index < 0 || index >= size) {
            System.out.println("Index is out of bounds");
            return null;
        }

        int startIndex = (nextFirst + 1) % items.length;
        int actualIndex = (startIndex + index) % items.length;
        return items[actualIndex];
    }


    public int size() {
        return size;
    }



    private void resizeSmaller() {
        int newCapacity = Math.max(INITIAL_CAPACITY, items.length / 2);
        T[] newArray = (T[]) new Object[newCapacity];
        int newIndex = 0;
        for (int i = (nextFirst + 1) % items.length; i != nextLast; i = (i + 1) % items.length) {
            newArray[newIndex] = items[i];
            newIndex++;
        }

        nextFirst = newArray.length - 1;
        nextLast = newIndex;
        items = newArray;
    }


    private void resizeBigger() {

        int newCapacity = items.length * 2;

        T[] newArray = (T[]) new Object[newCapacity];

        int newIndex = 0;
        for (int i = (nextFirst + 1) % items.length; i != nextLast; i = (i + 1) % items.length) {
            newArray[newIndex] = items[i];
            newIndex++;
        }

        nextFirst = newArray.length - 1;
        nextLast = newIndex;
        items = newArray;
    }


    private boolean isFull() {
        return size == items.length - 1;
    }



    private boolean isSparse() {
        double usageFactor = (double) size / items.length;
        return items.length > INITIAL_CAPACITY && usageFactor < USAGE_FACTOR_THRESHOLD;
    }

}

