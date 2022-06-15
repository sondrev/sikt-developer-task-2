package no.sikt.calculator;

import java.util.regex.Pattern;

import static java.util.Objects.nonNull;

public class ExpressionEvaluator {

    private static final Pattern validCharactersPattern = Pattern.compile("^[\\s\\d+*-\\/]*$");
    private static final int minCharacters = 3;

    private final transient ExpressionNodeTree expressionNodeTree;

    /**
     * Evaluates a string to a ExpressionEvaluator which later can be calculated using getResult().
     * @param expression The expression to be evaluated.
     *                   each number and operator needs to be
     *                   seperated by whitespace
     * @throws IllegalStateException if expression cant be evaluated
     */
    public ExpressionEvaluator(String expression) {
        assert nonNull(expression);

        var characters = expression.split("\\s");

        if (characters.length < minCharacters) {
            throw new IllegalStateException(expression + " needs at least " + minCharacters + " characters");
        }

        if (!validCharactersPattern.matcher(expression).matches()) {
            throw new IllegalStateException(expression + " contains invalid characters");
        }

        this.expressionNodeTree = ExpressionNodeTree.buildTree(characters);
    }

    /**
     * @return The result of the evaluated equation
     * @throws ArithmeticException
     */
    public Integer getResult() {
        return expressionNodeTree.getValue();
    }
}
