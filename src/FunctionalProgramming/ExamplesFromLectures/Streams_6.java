package FunctionalProgramming.ExamplesFromLectures;

import java.util.stream.Stream;

public class Streams_6 {

    public static void main(String[] args) {
        Integer sum = Stream
                .iterate(1, x -> x+1)
                .limit(100)
                .reduce(0, (a, b) -> a + b); //use reduce here because .sum will not work on default streams
        System.out.println(sum);
    }
}
