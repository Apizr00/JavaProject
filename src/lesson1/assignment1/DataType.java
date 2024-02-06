package lesson1.assignment1;

public class DataType {

    public static void main(String[] args) {

        System.out.println("Number Of Arguments: " + args.length);

        for (int i = 0; i < args.length; i++) {

            System.out.println((i + 1)+"." + args[i]);
        }

        int integerNumber = 10;
        double doubleNumber = 3.14;
        boolean boolValue = true;
        char charValue = 'A';
        String stringValue = "Hello, World Apizr";

        System.out.println("Data Types:");
        System.out.println("Integer Value: " + integerNumber);
        System.out.println("Double Value: " + doubleNumber);
        System.out.println("Boolean Value: " + boolValue);
        System.out.println("Character Value: " + charValue);
        System.out.println("String Value: " + stringValue);

    }

}
