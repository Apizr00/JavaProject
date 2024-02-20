package Lesson10.Quiz4.Question14;

interface Blogger {

    default void blog() throws Exception {

        System.out.println("GENERIC");
    }
}

class TravelBlogger implements Blogger {

    public void blog() {

        System.out.println("TRAVEL");
    }
}

public class Test {

    public static void main(String[] args) {

        Blogger blogger = new TravelBlogger();
        ((TravelBlogger) blogger).blog();
    }

}
