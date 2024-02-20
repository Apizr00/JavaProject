package Lesson11.Assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelMatrixMultiplication {

    public static void main(String[] args) {

        // Define two matrices to be multiplied
        int[][] matrixA = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] matrixB = { { 7, 8 }, { 9, 10 }, { 11, 12 } };

        // Get dimensions of matrices
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        // Perform parallel matrix multiplication
        int[][] result = multiplyMatricesParallel(matrixA, matrixB, rowsA, colsA, colsB);

        // Print the result
        for (int i = 0; i < rowsA; i++) {

            for (int j = 0; j < colsB; j++) {

                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Function to perform parallel matrix multiplication
    public static int[][] multiplyMatricesParallel(int[][] matrixA, int[][] matrixB, int rowsA, int colsA, int colsB) {

        // Initialize the result matrix
        int[][] result = new int[rowsA][colsB];

        // Get the number of available processor cores
        int numThreads = Runtime.getRuntime().availableProcessors();

        // Create a fixed-size thread pool
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // List to store futures for the tasks
        List<Future<Void>> futures = new ArrayList<>();

        // Submit multiplication tasks for each element in the result matrix
        for (int i = 0; i < rowsA; i++) {

            for (int j = 0; j < colsB; j++) {

                futures.add(executor.submit(new MatrixMultiplicationTask(matrixA, matrixB, result, i, j, colsA)));
            }
        }

        // Wait for all threads to finish
        for (Future<Void> future : futures) {

            try {

                future.get();

            } catch (InterruptedException | ExecutionException e) {

                e.printStackTrace();
            }
        }

        // Shut down the executor service
        executor.shutdown();

        // Return the result matrix
        return result;
    }

    // Task for multiplying a specific element in the result matrix
    static class MatrixMultiplicationTask implements Callable<Void> {

        private final int[][] matrixA;
        private final int[][] matrixB;
        private final int[][] result;
        private final int row;
        private final int col;
        private final int colsA;

        // Constructor for the task
        public MatrixMultiplicationTask(int[][] matrixA, int[][] matrixB, int[][] result, int row, int col, int colsA) {

            this.matrixA = matrixA;
            this.matrixB = matrixB;
            this.result = result;
            this.row = row;
            this.col = col;
            this.colsA = colsA;
        }

        // Callable's call method to perform matrix multiplication for the assigned
        // element
        @Override
        public Void call() {

            for (int k = 0; k < colsA; k++) {

                result[row][col] += matrixA[row][k] * matrixB[k][col];
            }

            return null;
        }
    }
}
