package functional_programming.stream_konz_2_sheet; //exercise 1

import java.util.Arrays;
import java.util.List;

public class SimpleLambdaStreams {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alfons", "Rocko", "Willhelm", "Henrietta", "Heidrun", "Leonie");
        // Hier folgt Ihr eigener Code

        System.out.println("a)"); //first letter is "H", sorted by alphabetical order
        list.stream()
                .filter(s -> s.startsWith("H"))
                .sorted()
                .forEach(System.out::println);

        System.out.println("b)"); //sort by length, longer than 5 chars
        list.stream()
                .sorted((a, b) -> a.length() - b.length())
                .filter(a -> a.length() > 5)
                .forEach(System.out::println);

        System.out.println("c)"); //reverse names
        list.stream()
                .map(s -> new StringBuffer(s))
                .map(s -> s.reverse())
                .limit(4)
                .forEach(System.out::println);

        System.out.println("d)");
        int sum = list.stream()
                .map(s -> s.length())
                .distinct()
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum);
    }

}
