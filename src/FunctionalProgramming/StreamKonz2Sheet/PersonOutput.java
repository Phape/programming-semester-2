package FunctionalProgramming.StreamKonz2Sheet;

import java.util.List;
import java.util.Optional;

public class PersonOutput {
    public static void main(String[] args) {
        List<Person> personList = TestPersonen.erzeuge();

        System.out.println("a)"); //every person is printed
        personList.stream().forEach(System.out::println);

        System.out.println("b)");
        personList.stream().filter(s -> s.geschlecht == 'w').forEach(System.out::println);

        System.out.println("c)");
        personList.stream()
                .filter(s -> s.geschlecht == 'm')
                .filter(s -> s.gebJahr > 2300)
                .forEach(System.out::println);

        System.out.println("d)");
        personList.stream()
                .filter(s -> s.vorname.charAt(0) == s.nachname.charAt(0))
                .forEach(System.out::println);

        System.out.println("e)");
        long amountWomen = personList.stream()
                .filter(s -> s.geschlecht == 'w')
                .count();
        System.out.println(amountWomen);

        System.out.println("f)");
        Double avgAge = personList.stream()
                .mapToInt(s -> 2400 - s.gebJahr) //create an intStream
                .average()
                .getAsDouble();
        System.out.println(avgAge);

        System.out.println("g)");
        Optional<Person> max = personList.stream()
                .max((a, b) -> a.gebJahr - b.gebJahr);
        System.out.println(max.get());
    }
}
