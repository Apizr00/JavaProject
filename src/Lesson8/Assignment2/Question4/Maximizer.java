package Lesson8.Assignment2.Question4;

import java.util.Comparator;

public class Maximizer<T> {

    private T[] array;
    private Comparator<T> comparator;

    public Maximizer(T[] array, Comparator<T> comparator) {

        this.array = array;
        this.comparator = comparator;
    }

    public T max() {
        
        if (array == null || array.length == 0) {

            return null; // or throw an exception as per your requirement
        }

        T maxElement = array[0];

        for (int i = 1; i < array.length; i++) {

            if (comparator.compare(array[i], maxElement) > 0) {

                maxElement = array[i];
            }
        }

        return maxElement;
    }

    public static void main(String[] args) {
        // Example usage with natural order comparator
        Integer[] intArray = { 3, 7, 1, 9, 4, 5 };
        Maximizer<Integer> intMaximizer = new Maximizer<>(intArray, Comparator.naturalOrder());
        System.out.println("Maximum Integer: " + intMaximizer.max());

        // Example usage with a custom comparator
        String[] stringArray = { "apple", "orange", "banana", "grape" };
        Maximizer<String> stringMaximizer = new Maximizer<>(stringArray, Comparator.reverseOrder());
        System.out.println("Maximum String (reversed order): " + stringMaximizer.max());
    }
}