package Lesson10.Quiz4.Question29;

class Message {

    String msg = "LET IT GO!";

    public void print() {

        System.out.println(msg);
    }
}

public class TestMessage {

    public static void change(Message m) {

        m.msg = "NEVER LOOK BACK!";
    }

    public static void main(String[] args) {

        Message obj = new Message();
        obj.print();
        change(obj);
        obj.print();
    }

}
