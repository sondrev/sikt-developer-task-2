package no.sikt.calculator;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    public String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets an Operator from a string.
     * @param string a string that should be one of the 4 supported operator
     * @return The Operator, or null if not found
     */
    public static Operator fromString(String string) {
        for (Operator o : Operator.values()) {
            if (o.symbol.equals(string)) {
                return o;
            }
        }
        return null;
    }
}


