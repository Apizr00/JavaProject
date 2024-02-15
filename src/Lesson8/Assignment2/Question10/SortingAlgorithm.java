package Lesson8.Assignment2.Question10;

import java.util.Arrays;

class SortingAlgorithm<T extends Comparable<T>> extends Algorithm<T> {

    @Override
    public void execute(T[] input) {
        Arrays.sort(input);
        System.out.println("Sorting Result: " + Arrays.toString(input));
    }
}