package Lesson10.Quiz4.Question25;

public class Test {

    public static void main(String[] args) {

        int[] arr = { 10, 20, 30 };
        int i = 0;

        arr[i++] = arr[++i] = 40;

        for (int x : arr) {

            System.out.println(x);
        }
    }

}
