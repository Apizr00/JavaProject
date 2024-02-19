package Lesson4.Quiz2.Question16;

public class LogHelper extends Helper {

    // private int num = 200;
    protected String operation = "LOGGING";

    void help() {

        System.out.println("LogHelper-help");

    }

    void log() {

        System.out.println("LogHelper-log");

    }

    public static void main(String[] args) {

        new LogHelper().help();

    }

}
