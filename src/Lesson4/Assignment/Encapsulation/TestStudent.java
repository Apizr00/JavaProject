package Lesson4.Assignment.Encapsulation;

public class TestStudent {

    public static void main(String[] args) {

        Student student = new Student();

        student.setName("Apizr");
        student.setAge(24);
        student.setRollNumber("123456");

        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student Roll Number: " + student.getRollNumber());

    }

}
