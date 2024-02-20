package Lesson10.Quiz4.Question11;

interface Perishable1 {

    default int maxDays() {

        return 1;
    }
}

interface Perishable2 extends Perishable1 {

    default int maxDays() {

        return 2;
    }
}

public class Test {

    public static void main(String[] args) {

        // Perishable1 obj = new Milk();
        // System.out.println(obj.maxDays());
    }

}
