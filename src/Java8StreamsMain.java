import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamsMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,2,5,3,6);
        Set<Integer> set = new HashSet<>();

        list.stream()
                .filter(n -> ! set.add(n)) // filter duplicates by adding to a set
                .forEach(System.out::println);

        //11. Find Second Highest Number
        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);
System.out.println("------------- Non repeted numbers: ");
        //14. Find Non-Repeated Characters
        list.stream().collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}
