package equation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class Main {
    private static final int INVALID_FORMAT_EXIT_STATUS = 2;
    private static final int FILE_NOT_FOUND_EXIT_STATUS = 1;

    public static void main(String[] args) {
        InputStream input;
        if (args.length >= 1)
            try {
                input = new FileInputStream(args[0]);
            } catch (FileNotFoundException e) {
                System.err.println("File not found");
                System.exit(FILE_NOT_FOUND_EXIT_STATUS);
                return;
            }
        else
            input = System.in;

        Equation equation;
        try (var scanner = new Scanner(input)) {
            double  a = scanner.nextDouble(),
                    b = scanner.nextDouble(),
                    c = scanner.nextDouble();

            equation = new Equation(a, b, c);
        }
        catch (NoSuchElementException e) {
            System.err.println("Invalid input format");
            System.exit(INVALID_FORMAT_EXIT_STATUS);
            return;
        }
        catch (ArithmeticException e) {
            System.err.println(e.getMessage());
            System.exit(INVALID_FORMAT_EXIT_STATUS);
            return;
        }

        System.out.println("\n" + equation);
        System.out.println(equation.solve());
    }
}
