package Lesson8.Assignment2.Question10;

public class AlgorithmDemo {
    public static void main(String[] args) {

        // Example usage of sorting algorithm
        SortingAlgorithm<Integer> sortingAlgorithm = new SortingAlgorithm<>();
        Integer[] numbers = { 5, 2, 8, 1, 6 };
        sortingAlgorithm.execute(numbers);

        // Example usage of searching algorithm
        SearchingAlgorithm<String> searchingAlgorithm = new SearchingAlgorithm<>();
        String[] names = { "Hafiz", "Haikal", "Amirul", "Firdaus", "Ajim" };
        searchingAlgorithm.execute(names);
    }
}