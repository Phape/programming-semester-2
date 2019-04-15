package FunctionalProgramming.SlidesAssignments; //slidePack2 - A4

import java.util.ArrayList;
import java.util.List;

public class A4_MethodReferences {
    public static void main(String[] args) {
        List<String> characters = new ArrayList<>();
        characters.add("z3");
        characters.add("b74");
        characters.add(null);
        characters.add("a1");

// Ersetzen Sie alle null-Werte durch leere Strings
        characters.replaceAll(z -> {
            if (z == null)
                return "";
            else
                return z;
        }); //ALTERNAtIVELY: characters.replaceAll(s -> s == null ? "" : s)
// Wandeln Sie alle Buchstaben in Großbuchstaben um
        characters.replaceAll(String::toUpperCase);
// Sortieren Sie die Elemente gemäß dem Alphabet
        characters.sort(String::compareTo);
// Geben Sie alle Elemente am Stück auf der Konsole aus
        characters.forEach(System.out::print);
    }
}

