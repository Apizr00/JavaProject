package Lesson3.Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Input Minimum Number: ");
        int minimum = scanner.nextInt();

        System.out.print("Please Input Maximum Number: ");
        int maximum = scanner.nextInt();

        System.out.print("Please Input Length Of Array: ");
        int length = scanner.nextInt();

        scanner.close();

        int[] randoms = getGeneratingArray(minimum, maximum, length);
        System.out.println(Arrays.toString(randoms));

        selectionSort(randoms);
        System.out.println("\nArray Sorting:");
        printArray(randoms);

        int mode = calculateMode(randoms);
        System.out.println("Mode: " + mode);

        double mean = calculateMean(randoms);
        System.out.println("Mean: " + mean);

        double median = calculateMedian(randoms);
        System.out.println("Median: " + median);

    }

    public static int[] getGeneratingArray(int minimum, int maximum, int length) {

        int[] num = new int[length];

        for (int i = 0; i < length; i++) {

            num[i] = (int) Math.round(Math.random() * (maximum - minimum) + minimum);
        }

        return num;
    }

    public static void selectionSort(int[] randoms) {

        int n = randoms.length;

        for (int i = 0; i < n - 1; i++) {

            int idxToSwap;
            idxToSwap = findMinIdx(randoms, i);

            int temp = randoms[idxToSwap];
            randoms[idxToSwap] = randoms[i];
            randoms[i] = temp;

        }

    }

    public static void printArray(int[] array) {

        for (int value : array) {

            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static int findMinIdx(int[] d, int k) {

        int minIdx = k;

        for (int i = k + 1; i < d.length; i++) {

            if (d[i] < d[minIdx]) {

                minIdx = i;
            }
        }
        return minIdx;
    }

    private static int calculateMode(int[] randoms) {

        int mode = 0;
        int maxFrequency = 0;

        for (int i = 0; i < randoms.length; i++) {

            int currentNumber = randoms[i];
            int currentFrequency = 1;

            for (int j = i + 1; j < randoms.length; j++) {

                if (randoms[j] == currentNumber) {

                    currentFrequency++;
                }
            }

            if (currentFrequency > maxFrequency) {

                maxFrequency = currentFrequency;
                mode = currentNumber;
            }
        }

        return mode;
    }

    private static double calculateMean(int[] randoms) {

        int sum = 0;
        for (int num : randoms) {
            sum += num;
        }
        return (double) sum / randoms.length;
    }

    private static double calculateMedian(int[] randoms) {

        int length = randoms.length;

        if (length % 2 == 0) {

            return (double) (randoms[length / 2 - 1] + randoms[length / 2]) / 2;

        } else {

            return randoms[length / 2];
        }
    }

}
