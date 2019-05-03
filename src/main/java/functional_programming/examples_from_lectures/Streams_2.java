package functional_programming.examples_from_lectures;

import java.util.stream.IntStream;

public class Streams_2 {

    public static void main(String[]args){
        IntStream stream = IntStream.range(1, 100); //1 is inclusive, 100 is exclusive
        stream = stream.map(x -> x*x).filter(x -> x%2 == 0); //map = for each object execute the following lambda expression
        System.out.println(stream.sum()); //sum closes the stream, is a final operation, proof in next line

       // stream.forEach(System.out::println); //this won't work bc the stream is closed
    }
}
