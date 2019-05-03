package functional_programming.slides_assignments; //slidesPack 2 - A1

import java.util.Arrays;
import java.util.List;

public class A1_LambdaExpressionBasics {

    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(1.0, 2.5, 3.5, 1.1, 2.2);
// 1. Ersetzen Sie alle Einträge durch Zufallswerte
        numbers.replaceAll(z -> Math.random() * 1001);
// 2. Sortieren Sie diese aufsteigend nach ihrem Wert
        numbers.sort(Double::compareTo);
// 3. Geben Sie die Liste auf der Konsole aus
        numbers.forEach(System.out::println);
    }
}

