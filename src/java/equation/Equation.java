package equation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Double.NaN;

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
        InputStream input;
        if (args.length >= 1)
            try {
                input = new FileInputStream(args[0]);
            } catch (FileNotFoundException e) {
                System.err.println("File not found");
                System.exit(1);
                return;
            }
        else
            input = System.in;

        var scanner = new Scanner(input);

        double  a = scanner.nextDouble(),
                b = scanner.nextDouble(),
                c = scanner.nextDouble();

        double[] roots = new Equation(a, b, c).solve();
        if (roots.length != 2)
            throw new UnsupportedOperationException("There must be 2 roots.");

        if (Double.isNaN(roots[0]) || Double.isNaN(roots[1]))
            System.out.println("\nThere are no real roots");
        else if (roots[0] == roots[1])
            System.out.println("\nThere is 1 root: " + roots[0]);
        else
            System.out.println("\nThere are 2 roots: " + roots[0] + ", " + roots[1]);
    }
}
