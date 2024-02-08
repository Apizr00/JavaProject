package Lesson3.Assignment;

import java.util.Arrays;

public class GeneratingArray {

    public static void main(String[] args) {

        int mininum = 0;
        int maximum = 99;
        int length = 10;
        int[] randoms = getGeneratingArray(mininum, maximum, length);
        System.out.println(Arrays.toString(randoms));

    }

    public static int[] getGeneratingArray(int mininum, int maximum, int length) {

        int[] num = new int[length];

        for (int i = 0; i < length; i++) {

            num[i] = (int) Math.round(Math.random() * (maximum - mininum) + mininum);
        }

        return num;
    }

}
