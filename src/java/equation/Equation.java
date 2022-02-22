package equation;

public record Equation(
        double a,
        double b,
        double c
        ) {
    public double[] solve() {
        var d = Math.sqrt(b*b - 4*a*c);

        return new double[]{(-b - d) /2/a, (-b + d) /2/a};
    }

}