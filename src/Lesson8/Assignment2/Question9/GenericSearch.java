package Lesson8.Assignment2.Question9;

public class GenericSearch<T extends Comparable<T>> {

    private T[] array;

    public GenericSearch(T[] array) {

        this.array = array;
    }

    public int linearSearch(T target) {

        for (int i = 0; i < array.length; i++) {

            if (array[i].equals(target)) {

                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if not found
    }

    public int binarySearch(T target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int comparison = array[mid].compareTo(target);

            if (comparison == 0) {

                return mid; // Return the index if found

            } else if (comparison < 0) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {

        // Test with Integer array
        Integer[] intArray = { 1, 3, 5, 7, 9, 11, 13 };
        GenericSearch<Integer> intSearch = new GenericSearch<>(intArray);

        System.out.println("Linear Search for 7: " + intSearch.linearSearch(7));
        System.out.println("Binary Search for 11: " + intSearch.binarySearch(11));

        // Test with String array
        String[] stringArray = { "apple", "banana", "orange", "grape" };
        GenericSearch<String> stringSearch = new GenericSearch<>(stringArray);

        System.out.println("Linear Search for 'banana': " + stringSearch.linearSearch("banana"));
        System.out.println("Binary Search for 'orange': " + stringSearch.binarySearch("orange"));
    }
}
