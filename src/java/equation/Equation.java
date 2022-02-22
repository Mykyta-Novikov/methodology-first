package equation;

public record Equation(
        double a,
        double b,
        double c
        ) {
    public Equation {
        if (a == 0) throw new ArithmeticException("Quadratic equation must have non-zero first coefficient");
    }

    public Solution solve() {
        var d = Math.sqrt(b*b - 4*a*c);

        return new Solution(
                (-b - d) /2/a,
                (-b + d) /2/a
        );
    }

    @Override
    public String toString() {
        return "Equation: " +
                "(" + a + ")x^2 + " +
                "(" + b + ")x + " +
                "(" + c + ")";
    }
}