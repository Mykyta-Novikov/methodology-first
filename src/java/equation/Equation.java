package equation;

import java.util.Arrays;
import java.util.Scanner;

public record Equation(
        double a,
        double b,
        double c
        ) {
    public double[] solve() {
        return new double[]{0d, 0d};
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        double  a = scanner.nextDouble(),
                b = scanner.nextDouble(),
                c = scanner.nextDouble();

        System.out.println("\n" + Arrays.toString(new Equation(a, b, c).solve()));
    }
}
