package FunctionalProgramming.ExamplesFromLectures;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Streams_7 {
    public static void main(String[] args) {
        OptionalDouble avg = IntStream.range(1, 100).average();

        if () {//something like optional is empty
            System.out.println("Calculation went wrong");
        }

        if (avg.isPresent()) { //I don't know what the condition was here either
            System.out.println(avg.getAsDouble());
        }
    }
}
