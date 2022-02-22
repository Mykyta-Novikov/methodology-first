package equation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public final class Main {
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

        var equation = new Equation(a, b, c);

        System.out.println("\n" + equation);
        System.out.println(equation.solve());
    }
}
