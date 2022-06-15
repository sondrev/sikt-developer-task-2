package no.sikt.calculator.expressionnode;

import no.sikt.calculator.Operator;

public interface ExpressionNode {

    Integer getValue();

    /**
     * Creates and return a ExpressionNode based on an operator and 2 values.
     * @param operator A Operator
     * @param leftValue Left-hand expression/node of the Node to create
     * @param rightValue Right-hand expression/node of the Node to create
     * @return One of the 4 Operator ExpressionNode
     */
    static ExpressionNode fromOperator(Operator operator, ExpressionNode leftValue, ExpressionNode rightValue) {
        switch (operator) {
            case ADD: return new AddExpressionNode(leftValue, rightValue);
            case SUBTRACT: return new SubtractExpressionNode(leftValue, rightValue);
            case MULTIPLY: return new MultiplyExpressionNode(leftValue, rightValue);
            case DIVIDE: return new DivideExpressionNode(leftValue, rightValue);
            default: throw new IllegalStateException("Could not create Node for operator " + operator.symbol);
        }
    }

}
