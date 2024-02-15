package Lesson8.Assignment2.Question1;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class GenericStack<T> {

    private List<T> stack;

    public GenericStack() {

        this.stack = new ArrayList<>();
    }

    public void push(T item) {

        stack.add(item);
    }

    public T pop() {

        if (isEmpty()) {

            throw new EmptyStackException();
        }

        int lastIndex = stack.size() - 1;
        T poppedItem = stack.get(lastIndex);
        stack.remove(lastIndex);
        return poppedItem;
    }

    public boolean isEmpty() {

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        // Test with Integer
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        while (!intStack.isEmpty()) {

            System.out.println("Popped from intStack: " + intStack.pop());
        }

        // Test with String
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");

        while (!stringStack.isEmpty()) {

            System.out.println("Popped from stringStack: " + stringStack.pop());
        }

        // Test with Double
        GenericStack<Double> doubleStack = new GenericStack<>();
        doubleStack.push(3.14);
        doubleStack.push(2.71);

        while (!doubleStack.isEmpty()) {

            System.out.println("Popped from doubleStack: " + doubleStack.pop());
        }
    }
}
