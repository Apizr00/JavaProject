package Lesson4.Exercise.Exercise1;

public class Main {
    public static void main(String[] args) {

        System.out.println("Number 10 + 5: " + MathUtils.add(10, 5));
        System.out.println("Number 8 - 15: " + MathUtils.subtract(15, 8));

        int number = 17;

        if (MathUtils.isEven(number)) {

            System.out.println(number + " is Even.");
        }

        else {

            System.out.println(number + " is Odd.");
        }

    }
}
