package Lesson8.Assignment2.Question3;

public class QueueTest {
    public static void main(String[] args) {
        // Testing GenericQueue with Integer
        GenericQueue<Integer> intQueue = new GenericQueue<>();
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);

        System.out.println("Dequeue: " + intQueue.dequeue()); // Output: 10
        System.out.println("Is Empty? " + intQueue.isEmpty()); // Output: false

        // Testing GenericQueue with String
        GenericQueue<String> stringQueue = new GenericQueue<>();
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");

        System.out.println("Dequeue: " + stringQueue.dequeue()); // Output: Hello
        System.out.println("Is Empty? " + stringQueue.isEmpty()); // Output: false

        // Testing GenericQueue with Boolean
        GenericQueue<Boolean> booleanQueue = new GenericQueue<>();
        booleanQueue.enqueue(true);
        booleanQueue.enqueue(false);

        System.out.println("Dequeue: " + booleanQueue.dequeue()); // Output: true
        System.out.println("Is Empty? " + booleanQueue.isEmpty()); // Output: false
    }
}