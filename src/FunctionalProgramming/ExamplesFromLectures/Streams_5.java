package FunctionalProgramming.ExamplesFromLectures;

import java.util.Arrays;
import java.util.stream.Stream;

public class Streams_5 {

    public static void main(String[] args) {
        Integer[] field = Stream
                .generate(() ->(int) (Math.random() * 201 - 100)) //see class "SortOut" from ExerciseSheet2
                .limit(30)
                .toArray(size -> new Integer[size]);

        System.out.println(Arrays.toString(field));
    }
}
