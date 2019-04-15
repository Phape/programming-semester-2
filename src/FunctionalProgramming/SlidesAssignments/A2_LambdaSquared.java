package FunctionalProgramming.SlidesAssignments; //slidesPack 2 - A2

import java.util.function.UnaryOperator;

public class A2_LambdaSquared {

    public static void main(String[] args) {
        UnaryOperator<Double> uo = d -> d * d;
        Double result = uo.apply(5.0);
        System.out.println(result);
    }
}
