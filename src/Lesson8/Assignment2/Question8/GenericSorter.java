package Lesson8.Assignment2.Question8;

import java.util.Arrays;

public class GenericSorter<T extends Comparable<T>> {

    public void sort(T[] array) {

        if (array == null || array.length == 0) {

            return;
        }
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(T[] array, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quicksort(array, low, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, high);
        }
    }

    private int partition(T[] array, int low, int high) {

        T pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) {

        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        // Example usage
        GenericSorter<Integer> sorter = new GenericSorter<>();
        Integer[] intArray = { 5, 2, 9, 1, 5, 6 };
        System.out.println("Original array: " + Arrays.toString(intArray));

        sorter.sort(intArray);
        System.out.println("Sorted array: " + Arrays.toString(intArray));
    }
}
