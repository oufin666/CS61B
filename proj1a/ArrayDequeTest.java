public class ArrayDequeTest {
    public static void main(String[] args) {
        // Test the addFirst and addLast methods
        testAddFirst();
        testAddLast();

        // Test the removeFirst and removeLast methods
        testRemoveFirst();
        testRemoveLast();

        // Test the get method
        testGet();

        // Test the size method
        testSize();
    }


    private static void testAddFirst() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        // After adding 3 elements to the front, the deque should be [3, 2, 1]
        // and the nextFirst and nextLast pointers should be adjusted accordingly.
        System.out.println("Test addFirst: " + deque.size() + " elements, expected [3, 2, 1]: " + deque.get(0) + ", " + deque.get(1) + ", " + deque.get(2));
    }

    private static void testAddLast() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        // After adding 3 elements to the back, the deque should be [1, 2, 3]
        // and the nextFirst and nextLast pointers should be adjusted accordingly.
        System.out.println("Test addLast: " + deque.size() + " elements, expected [1, 2, 3]: " + deque.get(0) + ", " + deque.get(1) + ", " + deque.get(2));
    }

    private static void testRemoveFirst() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Integer removedItem = deque.removeFirst();

        if (removedItem != null) {
            // After removing the first element, the deque should be [2, 3]
            // and the nextFirst and nextLast pointers should be adjusted accordingly.
            System.out.println("Test removeFirst: Removed " + removedItem.intValue() + ", " + deque.size() + " elements, expected [2, 3]: " + deque.get(0) + ", " + deque.get(1));
        } else {
            System.out.println("Test removeFirst: The deque is empty.");
        }
    }


    private static void testRemoveLast() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        int removedItem = deque.removeLast();

        // After removing the last element, the deque should be [1, 2]
        // and the nextFirst and nextLast pointers should be adjusted accordingly.
        System.out.println("Test removeLast: Removed " + removedItem + ", " + deque.size() + " elements, expected [1, 2]: " + deque.get(0) + ", " + deque.get(1));
    }

    private static void testGet() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        // Test getting elements by index
        System.out.println("Test get: " + deque.size() + " elements, expected 1: " + deque.get(0));
        System.out.println("Test get: " + deque.size() + " elements, expected 2: " + deque.get(1));
        System.out.println("Test get: " + deque.size() + " elements, expected 3: " + deque.get(2));
    }

    private static void testSize() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        // Test the size method
        System.out.println("Test size: " + deque.size() + " elements, expected 3");
    }
}

