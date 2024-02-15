package Lesson8.Assignment2.Question3;

import java.util.LinkedList;

class GenericQueue<T> {
    private LinkedList<T> queue = new LinkedList<>();

    // Adds an item to the queue
    public void enqueue(T item) {
        queue.addLast(item);
    }

    // Removes and returns the item at the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.removeFirst();
    }

    // Returns true if the queue is empty, false otherwise
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
