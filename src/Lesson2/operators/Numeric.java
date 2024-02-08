package Lesson2.operators;

public class Numeric {

    public static void main(String[] args) {

        int intValue = 10;
        double doubleValue = 32.19;

        double castedDoublevalue = (double) intValue;
        System.out.printf("Casted Value From Int To Double %f \n", castedDoublevalue);

        int castedIntegerValue = (int) doubleValue;
        System.out.printf("Casted value From Double To Int %d", castedIntegerValue);
    }

}
