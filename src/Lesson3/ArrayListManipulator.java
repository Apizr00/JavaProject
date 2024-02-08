package Lesson3;

import java.util.ArrayList;

public class ArrayListManipulator {

    ArrayList<Integer> arrayList;

    public ArrayListManipulator() {

        arrayList = new ArrayList<>();
    }

    public void addElement(int element) {

        arrayList.add(element);
    }

    public void removeElementByValue(int element) {

        arrayList.remove(Integer.valueOf(element));
    }

    public void removeElementByIndex(int element) {

        arrayList.remove(element);
    }

    public ArrayList<Integer> getArrayList() {

        return arrayList;
    }

    public int searchElement(int element) {

        return arrayList.indexOf(element);

    }

    public void sortArray() {

        arrayList.sort(null);
    }

    public void display() {

        for (int element : this.arrayList) {

            System.out.printf("%d ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayListManipulator manipulator = new ArrayListManipulator();

        manipulator.addElement(200);
        manipulator.addElement(100);
        manipulator.addElement(150);
        System.out.println(manipulator.getArrayList().toString());

        // manipulator.removeElementByValue(90);
        // manipulator.removeElementByIndex(1);
        // System.out.println(manipulator.getArrayList().toString());

        // int sch = manipulator.searchElement(100);
        // System.out.println("The Search Element: " + sch);

        manipulator.sortArray();
        System.out.print("After: ");
        manipulator.display();

    }

}
