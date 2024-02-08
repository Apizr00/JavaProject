package Lesson3.Assignment;

import java.util.Scanner;

public class NPowerMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter The Dimension Of The Square Matrix A: ");
        int dim = scanner.nextInt();

        int[][] a = new int[dim][dim];

        System.out.println("Enter The Elements Of Matrix A:");

        for (int i = 0; i < dim; i++) {

            for (int j = 0; j < dim; j++) {

                System.out.print("A[" + (i + 1) + "][" + (j + 1) + "]: ");
                a[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter The Power (n): ");
        int n = scanner.nextInt();

        int[][] b = new int[dim][dim];
        int[][] c = new int[dim][dim];

        for (int i = 0; i < dim; i++) {

            for (int j = 0; j < dim; j++) {

                if (i == j) {

                    c[i][j] = 1;
                }
            }
        }

        for (int k = 1; k <= n; k++) {

            multiplyMatrices(a, c, b);

            for (int i = 0; i < dim; i++) {

                System.arraycopy(b[i], 0, c[i], 0, dim);
            }
        }

        System.out.println("\nThe Result Of A^n:");

        for (int i = 0; i < dim; i++) {

            for (int j = 0; j < dim; j++) {

                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void multiplyMatrices(int[][] a, int[][] b, int[][] result) {

        int dim = a.length;

        for (int i = 0; i < dim; i++) {

            for (int j = 0; j < dim; j++) {

                result[i][j] = 0;

                for (int k = 0; k < dim; k++) {

                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }
}
