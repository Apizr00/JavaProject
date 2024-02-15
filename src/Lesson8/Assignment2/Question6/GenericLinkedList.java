package Lesson8.Assignment2.Question6;

// GenericLinkedList.java
public class GenericLinkedList<T> {
    Node<T> head;

    // Node class for holding data and reference to the next node
    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add item to the end of the linked list
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Remove the first occurrence of the specified item from the linked list
    public void remove(T item) {
        if (head == null) {
            return;
        }

        if (head.data.equals(item)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(item)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }
}
