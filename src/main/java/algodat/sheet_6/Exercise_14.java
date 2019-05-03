package algodat.sheet_6;

import java.util.Collection;
import java.util.HashSet;

public class Exercise_14 {

    public static void main(String[] args) {
        Collection<Integer> collection = new HashSet<>();

        while (collection.size() < 7) {
            collection.add((int)(Math.random()*49+1));
        }
        System.out.println("Die Lottozahlen: " + collection + " Alle Angaben ohne Gewähr.");

    }
}
