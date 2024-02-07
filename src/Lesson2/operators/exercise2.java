package Lesson2.operators;

public class exercise2 {

    static double d;
    static double xoff;
    static double yoff;
    static double zoff;
    static int x1 = 2;
    static int y1 = 1;
    static int z1 = 3;
    static int x2 = 0;
    static int y2 = 0;
    static int z2 = 6;

    public static void main(String[] args) {

        xoff = Math.pow(x1 - x2, 2);
        yoff = Math.pow(y1 - y2, 2);
        zoff = Math.pow(z1 - z2, 2);
        d = Math.sqrt((xoff + yoff + zoff));

        System.out.println(d);

    }

}