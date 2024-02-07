package lesson1.quiz1.Q2;

public class Test {

    int i1 = 10;
    int i2 = 20;

    int add() {

        return this.i1 + this.i2;
    }

    public static void main(String[] args) {

        System.out.println(new Test().add());
    }
}
