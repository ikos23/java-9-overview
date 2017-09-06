package main.java.com.ivk23.java9.overview.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

/**
 * @author Ivan Kos
 */
public class Main {

    private enum Colors { RED, GREEN, BLUE };

    public static void main(String[] args) {
        // new out-of-the-box features :)

        // [1] List
        final List<Object> emptyList = List.of();
        final List<Integer> integerList = List.of(1, 2, 3, 4);


        System.out.println("\nList of integers class : "  + integerList.getClass());
        System.out.println("List of integerList : " + integerList);

        // [2] Map
        final Map<Object, Object> emptyMap = Map.of();
        final Map<Integer, Colors> colorsMap = Map.of(1, Colors.RED, 2, Colors.GREEN, 3, Colors.BLUE);

        // ofEntries ^_^
        final Map<Integer, String> mapOfEntries = Map.ofEntries(entry(1, "red"), entry(2, "blue"));

        System.out.println("\nMap of colors class : "  + colorsMap.getClass());
        System.out.println("Map of colors : " + colorsMap);
        System.out.println("Map created using ofEntries: " + mapOfEntries);


        // [3] Set
        final Set<Integer> integerSet = Set.of(1, 2, 3, 4);

        System.out.println("\nSet of integers class : "  + integerSet.getClass());
        System.out.println("Set of integers : " + integerSet);

        // try this in debug mode :)
        final Set<Integer> oops = Set.of(1, 2, 3, 4, 3);
    }
}

