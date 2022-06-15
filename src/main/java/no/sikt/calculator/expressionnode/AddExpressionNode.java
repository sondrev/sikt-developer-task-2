package no.sikt.calculator.expressionnode;

public class AddExpressionNode implements ExpressionNode {

    private final transient ExpressionNode leftExpressionNode;
    private final transient ExpressionNode rightExpressionNode;

    public AddExpressionNode(ExpressionNode leftExpressionNode, ExpressionNode rightExpressionNode) {
        this.leftExpressionNode = leftExpressionNode;
        this.rightExpressionNode = rightExpressionNode;
    }

    @Override
    public Integer getValue() {
        return leftExpressionNode.getValue() + rightExpressionNode.getValue();
    }

    @Override
    public String toString() {
        return "(" + leftExpressionNode + " + " + rightExpressionNode + ")";
    }
}
