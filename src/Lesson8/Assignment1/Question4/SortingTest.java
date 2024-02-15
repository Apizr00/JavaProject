package Lesson8.Assignment1.Question4;

public class SortingTest {
    public static void main(String[] args) {

        testSortingAlgorithm(new BubbleSort(), "Bubble Sort");

        testSortingAlgorithm(new SelectionSort(), "Selection Sort");

        testSortingAlgorithm(new InsertionSort(), "Insertion Sort");
    }

    private static void testSortingAlgorithm(Sortable sortable, String algorithmName) {

        int[] array = { 64, 25, 12, 22, 11 };
        System.out.println("Original array for " + algorithmName + ": " + arrayToString(array));

        long startTime = System.nanoTime();
        sortable.sort(array);
        long endTime = System.nanoTime();

        System.out.println("Sorted array for " + algorithmName + ": " + arrayToString(array));
        System.out.println("Time taken for " + algorithmName + ": " + (endTime - startTime) + " nanoseconds\n");
    }

    private static String arrayToString(int[] array) {

        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < array.length; i++) {

            result.append(array[i]);
            if (i < array.length - 1) {

                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }
}