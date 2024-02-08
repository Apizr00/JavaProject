package Lesson3.Assignment;

public class SelectionSort {

    public static void main(String[] args) {

        double[] array = { 64.3, 25.6, 12.5, 22.7, 11.3 };
        System.out.println("Original Array:");
        printArray(array);

        selectionSort(array, "increasing");

        System.out.println("\nArray After Increasing Order Sorting:");
        printArray(array);

        selectionSort(array, "decreasing");

        System.out.println("\nArray After Decreasing Order Sorting:");
        printArray(array);

    }

    public static void printArray(double[] array) {

        for (double value : array) {

            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void selectionSort(double[] array, String order) {

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {

            int idxToSwap;

            if (order.equals("increasing")) {

                idxToSwap = findMinIdx(array, i);

            } else if (order.equals("decreasing")) {

                idxToSwap = findMaxIdx(array, i);
            } else {

                throw new IllegalArgumentException("Invalid Order Specified");
            }

            double temp = array[idxToSwap];
            array[idxToSwap] = array[i];
            array[i] = temp;
        }
    }

    public static int findMinIdx(double[] d, int k) {

        int minIdx = k;

        for (int i = k + 1; i < d.length; i++) {

            if (d[i] < d[minIdx]) {

                minIdx = i;
            }
        }
        return minIdx;
    }

    public static int findMaxIdx(double[] d, int k) {

        int maxIdx = k;

        for (int i = k + 1; i < d.length; i++) {

            if (d[i] > d[maxIdx]) {

                maxIdx = i;
            }

        }
        return maxIdx;
    }

}
