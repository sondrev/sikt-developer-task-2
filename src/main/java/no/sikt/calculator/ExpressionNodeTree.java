package no.sikt.calculator;

import no.sikt.calculator.expressionnode.ExpressionNode;
import no.sikt.calculator.expressionnode.NumberExpressionNode;

import java.util.Stack;
import java.util.regex.Pattern;


/**
 * ExpressionNodeTree is a mathematical expression represented as a Tree with a single root node that spans other nodes
 * that can either be a number or a mathematical operation on two other nodes.
 */
public class ExpressionNodeTree {
    private final transient ExpressionNode rootExpressionNode;

    private static final Pattern numberPattern = Pattern.compile("^-?\\d+?");

    public ExpressionNodeTree(ExpressionNode rootExpressionNode) {
        this.rootExpressionNode = rootExpressionNode;
    }

    /**
     * Builds a ExpressionNodeTree from a string.
     * @param characters the characters representing the expression
     * @return the generated ExpressionNodeTree
     */
    public static ExpressionNodeTree buildTree(String... characters) {
        var nodeStack = new Stack<ExpressionNode>();

        ExpressionNode currentExpressionNode = null;

        for (String character : characters) {

            if (numberPattern.matcher(character).matches()) {
                var number = NumberExpressionNode.fromInt(Integer.parseInt(character));
                nodeStack.add(number);
            } else {
                var operator = Operator.fromString(character);
                var rightHand = nodeStack.pop();
                var leftHand = nodeStack.pop();

                currentExpressionNode = ExpressionNode.fromOperator(operator, leftHand, rightHand);
                nodeStack.add(currentExpressionNode);
            }
        }
        return new ExpressionNodeTree(currentExpressionNode);
    }

    public Integer getValue() {
        return rootExpressionNode.getValue();
    }

    @Override
    public String toString() {
        return rootExpressionNode.toString();
    }
}
