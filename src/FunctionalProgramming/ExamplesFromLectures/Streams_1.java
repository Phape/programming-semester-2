package FunctionalProgramming.ExamplesFromLectures;

import java.util.Arrays;
import java.util.List;

public class Streams_1 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Stark", "Lannister", "Baratheon", "Targaryen", "Greyjoy");
        list.stream() //stream works with a copy of the list
                .map(String::toUpperCase)
                .filter(s -> s.contains("E")) //multiple streams can be linked together
                .sorted((a,b) -> {
                        int x = b.length() - a.length(); //not sort bc. the original list is not manipulated
                    if (x == 0)
                        return a.compareTo(b); //if words have same amount of letters, they are sorted alphabetically
                    else
                        return x;
                })
                .forEach(System.out::println);
    }
}
