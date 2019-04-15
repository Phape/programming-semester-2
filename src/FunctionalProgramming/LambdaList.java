package FunctionalProgramming; //sheet 2 ex. 3

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaList {
    public static void main(String[] args) { // Erzeuge eine Liste mit Zahlen vom Typ Integer
        List<Integer> list = Arrays.asList(11,21,24,36,41,55,62,66);

        list.forEach(i -> System.out.print(i + " "));
        System.out.println();
        list.sort(Comparator.comparingInt(i -> i % 8));
        list.forEach(i -> System.out.print(i + " "));
        System.out.println();

    }
}
