package no.sikt.calculator.expressionnode;

public class DivideExpressionNode implements ExpressionNode {

    private final transient ExpressionNode leftExpressionNode;
    private final transient ExpressionNode rightExpressionNode;

    public DivideExpressionNode(ExpressionNode leftExpressionNode, ExpressionNode rightExpressionNode) {
        this.leftExpressionNode = leftExpressionNode;
        this.rightExpressionNode = rightExpressionNode;
    }

    @Override
    public Integer getValue() {
        var rightExpressionNode = this.rightExpressionNode.getValue();

        if (rightExpressionNode == 0) {
            throw new ArithmeticException("Cant divide by " + rightExpressionNode + " as it equals zero");
        }

        return leftExpressionNode.getValue() / rightExpressionNode;
    }

    @Override
    public String toString() {
        return "(" + leftExpressionNode + " / " + rightExpressionNode + ")";
    }
}
