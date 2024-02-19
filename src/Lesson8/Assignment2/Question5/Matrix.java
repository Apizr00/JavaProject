package Lesson8.Assignment2.Question5;

import java.util.Arrays;

public class Matrix<T> {

    private int rows;
    private int columns;
    private T[][] matrix;

    // Constructor: Setting up the dimension of 2D matrix
    @SuppressWarnings("unchecked")
    Matrix(int rows, int columns) {

        this.rows = rows;
        this.columns = columns;
        this.matrix = (T[][]) new Object[rows][columns];
    }

    // Setting an element of matrix
    public void setElement(int row, int column, T value) {

        // Checking wether indices were valid or not
        try {

            matrix[row][column] = value;

        } catch (IndexOutOfBoundsException e) {

            // e.getStackTrace();
            System.out.println("Invalid matrix indices!!!");
        }
    }

    // Getting an element of matrix
    public T getElement(int row, int column) {

        // Checking wether indices were valid or not
        try {

            return matrix[row][column];

        } catch (IndexOutOfBoundsException e) {

            // e.getStackTrace();
            System.out.println("Invalid matrix indices!!!");
            return null;
        }
    }

    // Tranpose the matrix
    public Matrix<T> transpose() { // This method return the object of Matrix<T>

        // Initialize the transposed matrix object for storing the matrix
        Matrix<T> transposedMatrix = new Matrix<>(columns, rows);

        // Tranposing the matrix
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                // Calling setElement method to setting each element value into matrix
                transposedMatrix.setElement(j, i, matrix[i][j]);
            }
        }
        return transposedMatrix;
    }

    // Adding value between 2 matrix
    public Matrix<T> add(Matrix<T> matrix2) {

        // Checking wether first matrix rows and second columns row are equals or not
        if (this.rows != matrix2.rows || this.columns != matrix2.columns) {

            System.out.println("Matrix must have same dimension!");
            return null;

        } else {

            // Initialize Matrix<T> object of result
            Matrix<T> result = new Matrix<>(rows, columns);

            // Using addElements method to add both matrix
            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < columns; j++) {

                    result.setElement(i, j, addElements(this.getElement(i, j), matrix2.getElement(i, j)));
                }
            }

            return result;
        }
    }

    // Multiplying both matrix
    public Matrix<T> multiply(Matrix<T> matrix2) {

        // Checking whether first matrix columns size are equal with second matrix rows
        // size
        if (this.columns != matrix2.rows) {

            System.out.println("Number of columns on first matrix must be equal with number of rows on second matrix!");
            return null;

        } else {
            // Initialized Matrix<T> object of result
            Matrix<T> result = new Matrix<>(rows, matrix2.columns);

            // Multiplication of matrix
            // Using equation : Cij= Ai1B1j + Ai2B2j + ... + AinBnj where n is a column of
            // first matrix and row of second matrix
            for (int i = 0; i < this.rows; i++) {

                for (int j = 0; j < matrix2.columns; j++) {

                    // Initialize sum of T object
                    T sum = null;

                    // Using multiplyElements method for multiplication
                    for (int k = 0; k < this.columns; k++) {

                        sum = addElements(sum, multiplyElements(this.getElement(i, k), matrix2.getElement(k, j)));
                    }
                    result.setElement(i, j, sum);
                }
            }
            return result;
        }
    }

    // Adding 2 elements
    @SuppressWarnings("unchecked")
    public T addElements(T element1, T element2) {

        // Checking if the element1 is null and whether element2 is
        // instanceof Double or Integer
        if (element1 == null && (element2 instanceof Integer || element2 instanceof Double)) {

            // If null, call getZeroValues method
            element1 = getZeroValues(element2);
        }

        // Checking the instanceof element1
        if (element1 instanceof Integer) {

            return (T) Integer.valueOf(((Integer) element1) + ((Integer) element2));
            // Explanation:
            // 1. ((Integer) element1) + ((Integer) element2): This part adds two Integer
            // objects together. It involves unboxing element1 and element2 from their
            // wrapper Integer types to primitive int, performing the addition, and then
            // boxing the result back into an Integer.
            // 2. Integer.valueOf(...): This part takes the result of the addition (now an
            // int) and boxes it back into an Integer using the valueOf method.
            // 3. (T) ...: Finally, the result is cast to the generic type T. This assumes
            // that T is compatible with Integer or a type that can be automatically cast
            // from Integer. This step is possible because the result of Integer.valueOf is
            // an Integer object, and the code is cast back to type T.

        } else if (element1 instanceof Double) {

            return (T) Double.valueOf(((Double) element1) + ((Double) element2));

        } else {

            System.out.println("The matrix are not containing number!");
            return null;
        }
    }

    // Multiply 2 elements
    @SuppressWarnings("unchecked")
    public T multiplyElements(T element1, T element2) {

        // Checking wether the element1 were Integer or Double
        if (element1 instanceof Integer) {

            return (T) Integer.valueOf(((Integer) element1) * ((Integer) element2));

        } else if (element1 instanceof Double) {

            return (T) Double.valueOf(((Double) element1) * ((Double) element2));

        } else {

            System.out.println("The matrix are not containing number!");
            return null;
        }
    }

    // Setting value into element1 that were null
    @SuppressWarnings("unchecked")
    public T getZeroValues(T element2) {
        // Checking element2 whether it is Integer, Double or other reference type
        // Returning the value 0 to element1 if element2 is Integer or Double.
        if (element2 instanceof Integer) {

            return (T) Integer.valueOf(0);

        } else if (element2 instanceof Double) {

            return (T) Double.valueOf(0.0);

        } else {

            return null;
        }

    }

    // Checking wether the rows and columns were valid indices
    public boolean isValidIndex(int rows, int columns) {

        return rows >= 0 && rows <= this.rows && columns >= 0 && columns <= this.columns;
    }

    // To print the value of object instead of giving the reference value
    @Override
    public String toString() {
        // Intialize the result as object of StringBuilder
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < rows; i++) {

            // Basically it will print array of each rows
            result.append(Arrays.toString(matrix[i])).append("\n");
        }
        return result.toString();
    }
}