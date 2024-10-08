import java.util.*;

public class InterfaceDemo {
    public static void main(String[] args) {
        // List Interface
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Apple");

        System.out.println("List elements:");
        for (String element : list) {
            System.out.println(element);
        }

        list.remove("Banana");
        System.out.println("\nList after removing 'Banana': " + list);

        // Set Interface
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple");

        System.out.println("\nSet elements:");
        for (String element : set) {
            System.out.println(element);
        }

        set.remove("Banana");
        System.out.println("\nSet after removing 'Banana': " + set);

        // Map Interface
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Orange");
        map.put(4, "Apple");

        System.out.println("\nMap elements:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        map.remove(2);
        System.out.println("\nMap after removing key 2: " + map);
    }
}
