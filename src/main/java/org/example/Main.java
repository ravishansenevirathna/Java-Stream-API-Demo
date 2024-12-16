package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //////////////////////////////////////////////// example 01
        // Filtering names starting with "A"
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie");

        names.stream() // Create a stream from the list
                .filter(name -> name.startsWith("A")) // Intermediate operation: filter
                .forEach(System.out::println); // Terminal operation: print each name


        //////////////////////////////////////////////// example 02
        // Parallel processing for summation
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum); // Parallel sum calculation
        System.out.println(sum); // Output: 15


        //////////////////////////////////////////////// example 03
        // Filtering even numbers from a list
        List<Integer> numbersArr = Arrays.asList(10, 15, 20, 25);
        List<Integer> evenNumbers = numbersArr.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers); // Output: [10, 20]


        //////////////////////////////////////////////// example 04: Sorting a list
        List<String> namesForSorting = Arrays.asList("John", "Alice", "Zara", "Michael", "Bob");

        List<String> sortedNames = namesForSorting.stream()
                .sorted() // Sort alphabetically
                .collect(Collectors.toList());
        System.out.println(sortedNames); // Output: [Alice, Bob, John, Michael, Zara]


        //////////////////////////////////////////////// example 05: Transforming a list using map
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase) // Convert each name to uppercase
                .collect(Collectors.toList());
        System.out.println(upperCaseNames); // Output: [ALICE, BOB, ANNA, CHARLIE]


        //////////////////////////////////////////////// example 06: Finding duplicates in a list
        List<String> items = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana");

        Set<String> duplicates = items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Filter duplicates
                .map(Map.Entry::getKey) // Get only the keys
                .collect(Collectors.toSet());
        System.out.println(duplicates); // Output: [Apple, Banana]


        //////////////////////////////////////////////// example 07: Joining strings
        List<String> countries = Arrays.asList("USA", "Canada", "India", "UK");

        String joinedCountries = countries.stream()
                .collect(Collectors.joining(", ")); // Join with commas
        System.out.println(joinedCountries); // Output: USA, Canada, India, UK


        //////////////////////////////////////////////// example 08: Counting elements
        long count = names.stream()
                .filter(name -> name.length() > 3) // Names longer than 3 characters
                .count();
        System.out.println(count); // Output: 3


        //////////////////////////////////////////////// example 09: Finding maximum or minimum
        List<Integer> scores = Arrays.asList(55, 89, 76, 45, 92);

        int maxScore = scores.stream()
                .max(Integer::compareTo) // Find the maximum value
                .orElse(-1); // Default value if the list is empty
        System.out.println(maxScore); // Output: 92

        int minScore = scores.stream()
                .min(Integer::compareTo) // Find the minimum value
                .orElse(-1);
        System.out.println(minScore); // Output: 45


        //////////////////////////////////////////////// example 10: Grouping data
        List<String> animals = Arrays.asList("Dog", "Cat", "Elephant", "Cow", "Deer");

        Map<Integer, List<String>> groupedByLength = animals.stream()
                .collect(Collectors.groupingBy(String::length)); // Group by the length of each string
        System.out.println(groupedByLength);
        // Output: {3=[Dog, Cat, Cow], 8=[Elephant], 4=[Deer]}


        //////////////////////////////////////////////// example 11: FlatMap for nested structures
        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Integer> flatList = nestedLists.stream()
                .flatMap(Collection::stream) // Flatten nested lists
                .collect(Collectors.toList());
        System.out.println(flatList); // Output: [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
