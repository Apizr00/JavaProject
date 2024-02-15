package Lesson8.Assignment2.Question6;

// TestGenericLinkedList.java
public class TestGenericLinkedList {
    public static void main(String[] args) {

        // Test with Integer
        GenericLinkedList<Integer> integerList = new GenericLinkedList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        System.out.println("Integer List:");
        printList(integerList);

        integerList.remove(2);
        System.out.println("After removing 2:");
        printList(integerList);

        System.out.println("Is Integer List empty? " + integerList.isEmpty());

        // Test with String
        GenericLinkedList<String> stringList = new GenericLinkedList<>();
        stringList.add("Hello");
        stringList.add("World");

        System.out.println("\nString List:");
        printList(stringList);

        stringList.remove("Hello");
        System.out.println("After removing 'Hello':");
        printList(stringList);

        System.out.println("Is String List empty? " + stringList.isEmpty());

        // Test with Character
        GenericLinkedList<Character> charList = new GenericLinkedList<>();
        charList.add('A');
        charList.add('B');
        charList.add('C');

        System.out.println("\nCharacter List:");
        printList(charList);

        charList.remove('B');
        System.out.println("After removing 'B':");
        printList(charList);

        System.out.println("Is Character List empty? " + charList.isEmpty());
    }

    // Helper method to print the contents of the list
    private static <T> void printList(GenericLinkedList<T> list) {

        GenericLinkedList.Node<T> current = list.head;
        
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
