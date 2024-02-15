package Lesson8.Assignment2.Question2;

public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public static void main(String[] args) {
        // Example usage
        Pair<Integer, String> pair = new Pair<>(1, "Hello");

        System.out.println("First element: " + pair.getFirst());
        System.out.println("Second element: " + pair.getSecond());

        pair.setFirst(42);
        pair.setSecond("World");

        System.out.println("Updated first element: " + pair.getFirst());
        System.out.println("Updated second element: " + pair.getSecond());
    }
}