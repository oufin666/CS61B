public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    // Your existing LinkedListDeque methods and constructor go here...

    // Nested Node class
    private static class Node<T> {
        private T item;
        private Node next;
        private Node prev;

        private Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);  // Assuming Node has a constructor that takes three parameters
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel.next, sentinel);
        sentinel.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel, sentinel.prev);
        sentinel.prev = newNode;
        newNode.prev.next = newNode;
        size++;
    }

    public void printDeque() {
        Node currentNode = sentinel.next;
        while (currentNode != sentinel) {
            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
        }
        System.out.println(); // Print a newline at the end for better formatting
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null; // If the deque is empty, return null
        }

        Node<T> firstNode = sentinel.next;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        size--;

        return firstNode.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;  // Index out of bounds, return null
        }

        Node<T> current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.item;
    }

    // Method to get the element at the specified index using recursion

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;  // Index out of bounds, return null
        }
        return (T)getRecursiveHelper(index, sentinel.next);
    }

    // Recursive helper method for getRecursive
    private T getRecursiveHelper(int index, Node<T> current) {
        if (index == 0) {
            return current.item;  // Base case: reached the desired index
        }
        if (current.next == sentinel) {
            return null;  // Reached the end of the deque without finding the index
        }
        return (T)getRecursiveHelper(index - 1, current.next);
    }


    // Recursive helper method for getRecursive


}
