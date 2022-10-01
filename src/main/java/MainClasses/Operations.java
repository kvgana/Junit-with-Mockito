package MainClasses;

import java.util.stream.DoubleStream;


public class Operations {

    public static double add(double... operands) {
        return DoubleStream.of(operands)
                .sum();
    }

    public static double multiply(double... operands) {
        return DoubleStream.of(operands)
                .reduce(1, (a, b) -> a * b);
    }

    public static double divide(double a, double b) {
        return a/b;
    }
}