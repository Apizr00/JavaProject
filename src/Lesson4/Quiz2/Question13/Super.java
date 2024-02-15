package Lesson4.Quiz2.Question13;

import java.io.FileNotFoundException;
import java.io.IOException;

abstract class Super {

    public abstract void m1() throws IOException;

}

class Sub extends Super {

    @Override
    public void m1() throws IOException {

        throw new FileNotFoundException();

    }
}
