package no.sikt.calculator.expressionnode;

public class NumberExpressionNode implements ExpressionNode {

    private final transient Integer number;

    public NumberExpressionNode(int number) {
        this.number = number;
    }

    public static final NumberExpressionNode fromInt(int number) {
        return new NumberExpressionNode(number);
    }

    @Override
    public Integer getValue() {
        return number;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
