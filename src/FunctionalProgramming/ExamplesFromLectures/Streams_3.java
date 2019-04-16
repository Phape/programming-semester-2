package FunctionalProgramming.ExamplesFromLectures;

import java.util.stream.Stream;

public class Streams_3 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("King's Landing", "Winterfell", "Braavos", "Dragonstone");
        stream = stream.parallel() //delete "parallel" to see the changed order of the output, parallel pays off with 1 million elements or more
                .map(String::toUpperCase)
                .peek(System.out::println) //peek is like forEach, but it does not close the stream
                .map(String::toLowerCase)
                .peek(System.out::println);
        stream.forEach(s -> System.out.println(s)); //as long as there is no operation that closes the stream, there is no output
    }
}
