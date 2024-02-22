package Lesson10.Quiz4.Question8;

public class Test {

    public static void main(String[] args) {

        int score = 30;
        char grade = 'F';

        if (50 <= score   && score < 60) {

            grade = 'D';

        } else if (60 <= score && score < 70) {

            grade = 'C';

        } else if (70 <= score && score< 80) {

            grade = 'B';

        } else if (score >= 80) {

            grade = 'A';
        }

        System.out.println(grade);

    }

}
