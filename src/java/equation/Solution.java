package equation;

public class Solution {
    private enum RootsType {
        SIMPLE("There are no real roots"),    // 2 simple roots
        MULTIPLE("There is 1 root: "),        // 1 root of multiplicity 2
        COMPLEX("There are 2 roots: ");       // complex roots

        private final String message;

        RootsType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    RootsType rootsType;
    double x1, x2;

    public Solution(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;

        if (Double.isNaN(x1) || Double.isNaN(x2))
            this.rootsType = RootsType.COMPLEX;
        else if (x1 == x2)
            this.rootsType = RootsType.MULTIPLE;
        else
            this.rootsType = RootsType.SIMPLE;
    }

    @Override
    public String toString() {
        return rootsType.getMessage() + switch (rootsType) {
            case COMPLEX:
                yield  "";
            case MULTIPLE:
                yield x1;
            case SIMPLE:
                yield x1 + ", " + x2;
        };
    }
}
