package Lesson3;

import java.util.ArrayList;

public class ArrayListStringManipulator {

    private ArrayList<String> arrayList;

    public ArrayListStringManipulator() {

        arrayList = new ArrayList<>();

    }

    public void addElement(String element) {

        arrayList.add(element);
    }

    public void removeElementByValueString(String element) {

        arrayList.remove(String.valueOf(element));
    }

    public void removeElementByIndexString(int i) {

        arrayList.remove(i);
    }

    public void sortArray() {

        arrayList.sort(null);
    }

    public void display() {

        for (String element : this.arrayList) {

            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public ArrayList<String> getArrayList() {

        return arrayList;
    }

    public static void main(String[] args) {

        ArrayListStringManipulator manipulator = new ArrayListStringManipulator();
        manipulator.addElement("Hafiz");
        manipulator.addElement("Firdaus");
        manipulator.addElement("Haikal");
        manipulator.addElement("Amirul");
        System.out.println(manipulator.getArrayList().toString());

        // manipulator.removeElementByValueString("Hafiz");
        // manipulator.removeElementByIndexString(1);
        // System.out.println(manipulator.getArrayList().toString());

        manipulator.display();

    }

}
