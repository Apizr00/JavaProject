package Lesson8.Assignment2.Question5;

public class Main {
    public static void main(String[] args) {
        // Initialize matrix 1 size 2x3
        Matrix<Integer> matrix1 = new Matrix<>(2, 3);
        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 2);
        matrix1.setElement(0, 2, 3);
        matrix1.setElement(1, 0, 4);
        matrix1.setElement(1, 1, 5);
        matrix1.setElement(1, 2, 6);

        // Initialize matrix 2 size 3x2
        Matrix<Integer> matrix2 = new Matrix<>(3, 2);
        matrix2.setElement(0, 0, 7);
        matrix2.setElement(0, 1, 8);
        matrix2.setElement(1, 0, 9);
        matrix2.setElement(1, 1, 10);
        matrix2.setElement(2, 0, 11);
        matrix2.setElement(2, 1, 12);

        // Initialize matrix 3 size 2x3
        Matrix<Integer> matrix3 = new Matrix<>(2, 3);
        matrix3.setElement(0, 0, 13);
        matrix3.setElement(0, 1, 14);
        matrix3.setElement(0, 2, 15);
        matrix3.setElement(1, 0, 16);
        matrix3.setElement(1, 1, 17);
        matrix3.setElement(1, 2, 18);

        // Initialize matrix 3 size 2x3
        Matrix<String> matrix4 = new Matrix<>(2, 3);
        matrix4.setElement(0, 0, "Apple");
        matrix4.setElement(0, 1, "Orange");
        matrix4.setElement(0, 2, "Mango");
        matrix4.setElement(1, 0, "Dragon Fruit");
        matrix4.setElement(1, 1, "Grape");
        matrix4.setElement(1, 2, "Strawberry");

        // Display matrix
        System.out.println("Matrix 1:\n" + matrix1);
        System.out.println("Matrix 2:\n" + matrix2);
        System.out.println("Matrix 3:\n" + matrix3);
        System.out.println("Matrix 4:\n" + matrix4);

        // Transpose matrix1
        Matrix<Integer> transposedMatrix1 = matrix1.transpose();
        System.out.println("Transposed Matrix 1:\n" + transposedMatrix1);

        // Adding 2 matrix
        Matrix<Integer> sumMatrix = matrix1.add(matrix3);
        System.out.println("Sum of Matrix 1 and Matrix 2:\n" + (sumMatrix != null ? sumMatrix : "null\n"));

        // Multiply 2 matrix
        Matrix<Integer> productMatrix = matrix1.multiply(matrix3);
        System.out.println("Product of Matrix 1 and Matrix 2:\n" + (productMatrix != null ? productMatrix : "null\n"));
    }
}
