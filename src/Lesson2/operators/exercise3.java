package Lesson2.operators;

public class exercise3 {

    public static void main(String[] args) {

        String str = "Apizr";
        String search = "Apizr";
        System.out.println(str);
        System.out.println(str.concat(str));
        str = str.concat(str);
        System.out.println(str.charAt(4));
        System.out.println(str.length());

        if (str.contains(search)) {

            System.out.printf("Contains %s", search);

        } else {

            System.out.printf("Not Contains Apizr %s", search);
        }
    }

}
