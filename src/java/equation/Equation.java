package equation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

        System.out.println("\n" + Arrays.toString(new Equation(a, b, c).solve()));
    }
}