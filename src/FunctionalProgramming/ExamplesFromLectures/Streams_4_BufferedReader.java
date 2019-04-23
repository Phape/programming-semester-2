package FunctionalProgramming.ExamplesFromLectures;

import java.io.*;

public class Streams_4_BufferedReader {

    public static void main(String[] args) {
        try {
            File f = new File("Names.csv"); //please put a csv with names in the directory
            InputStream inputStream = new FileInputStream(f);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            reader.lines()
                    .filter(s -> !s.contains("-"))
                    .forEach(System.out::println);
            //you can identify closing operations by their return type --> if it is "stream" than it doesn't close
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
