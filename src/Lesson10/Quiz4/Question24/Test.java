package Lesson10.Quiz4.Question24;

public class Test {

    public static void convert(String s) throws IllegalArgumentException, RuntimeException, Exception {

        if (s.length() == 0) {

            throw new RuntimeException("LENGTH SHOULD BE GREATER THAN 0");
        }
    }

    public static void main(String[] args) {

        try {

            convert("");
        }

        // catch (IllegalArgumentException | RuntimeException | Exception e) {

        // System.out.println(e.getMessage());
        // }

        catch (RuntimeException e) {

            System.out.println(e.getMessage());

        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }

}
