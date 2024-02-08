package Lesson3.Assignment;

public class SequentialSearch {

    public static void main(String[] args) {

        int[] array = { 99, 105, 86, 34, 108, 25, 11, 96 };
        int searchValue = 108;

        int result = sequentSearch(array, searchValue);

        if (result != -1) {

            System.out.println("Value " + searchValue + " Found At Index " + result);

        } else {

            System.out.println("Value " + searchValue + " Not Found In The Array.");
        }
    }

    public static int sequentSearch(int[] a, int k) {

        int i = 0;
        int length = a.length;

        while (i < length && a[i] != k) {

            i++;
        }

        if (i >= length) {

            i = -1;
        }

        return i;
    }
}
