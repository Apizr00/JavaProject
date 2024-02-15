package Lesson8.Assignment2.Question7;

import java.util.HashMap;
import java.util.Map;

public class Genericmap<K, V> {

    private Map<K, V> map;

    public Genericmap() {

        this.map = new HashMap<>();
    }

    // Method to add a key-value pair to the map
    public void add(K key, V value) {

        map.put(key, value);
    }

    // Method to retrieve a value based on a key
    public V get(K key) {

        return map.get(key);
    }

    // Method to check if a key exists in the map
    public boolean containsKey(K key) {

        return map.containsKey(key);
    }

    // Method to remove a key-value pair from the map
    public void remove(K key) {

        map.remove(key);
    }

    public static void main(String[] args) {

        Genericmap<String, Integer> sampleMap = new Genericmap<>();

        // Adding key-value pairs
        sampleMap.add("One", 1);
        sampleMap.add("Two", 2);
        sampleMap.add("Three", 3);

        // Retrieving values
        System.out.println("Value for key 'Two': " + sampleMap.get("Two"));

        // Checking if a key exists
        System.out.println("Contains key 'Four': " + sampleMap.containsKey("Four"));

        // Removing a key-value pair
        sampleMap.remove("Three");

        // Checking the updated map
        System.out.println("Contains key 'Three' after removal: " + sampleMap.containsKey("Three"));

    }

}