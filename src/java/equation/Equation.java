package equation;

import java.util.Arrays;
import java.util.Scanner;

public record Equation(
        double a,
        double b,
        double c
        ) {
    public double[] solve() {
        var d = Math.sqrt(b*b - 4*a*c);

        return new double[]{(-b - d) /2/a, (-b + d) /2/a};
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        double  a = scanner.nextDouble(),
                b = scanner.nextDouble(),
                c = scanner.nextDouble();

        System.out.println("\n" + Arrays.toString(new Equation(a, b, c).solve()));
    }
}
