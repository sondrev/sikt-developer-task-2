package no.sikt.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionEvaluatorTest {

    @Test
    void shouldEvaluvateValidExpression()  {
        var expression = "1 1 +";
        new ExpressionEvaluator(expression);
    }

    @Test
    void shouldNotEvaluvateInvalidExpression_too_short()  {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            var expression = "1 1";
            new ExpressionEvaluator(expression);
        });
    }

    @Test
    void shouldNotEvaluvateInvalidExpression_invalid_characters()  {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            var expression = "1 1 e";
            new ExpressionEvaluator(expression);
        });
    }

    @Test
    void add()  {
        var expression = "1 1 +";
        var actual = new ExpressionEvaluator(expression).getResult();
        assertEquals(2, actual);
    }

    @Test
    void subtract()  {
        var expression = "2 1 -";
        var actual = new ExpressionEvaluator(expression).getResult();
        assertEquals(1, actual);
    }

    @Test
    void multiply()  {
        var expression = "2 2 *";
        var actual = new ExpressionEvaluator(expression).getResult();
        assertEquals(4, actual);
    }

    @Test
    void divide()  {
        var expression = "9 3 /";
        var actual = new ExpressionEvaluator(expression).getResult();
        assertEquals(3, actual);
    }

    @Test
    void divide_byZero_evaluvatesButDoesNotCalulcate()  {
        var expression = "1 0 /";
        var expressionEvaluator = new ExpressionEvaluator(expression);

        Assertions.assertThrows(ArithmeticException.class, () ->
                expressionEvaluator.getResult()
        );
    }

    @Test
    void correctOrder_MultipleOperators() {
        var expression = "5 1 + 2 -";
        var actual = new ExpressionEvaluator(expression).getResult();
        assertEquals(4, actual);
    }

    @Test
    void correctOrder_OperatorsAtEnd() {
        var expression = "6 5 2 + -";
        var actual = new ExpressionEvaluator(expression).getResult();
        assertEquals(-1, actual);
    }

    @Test
    void allExamplesEvaluatesCorrectly() throws IOException {
        var stream = getClass().getClassLoader().getResourceAsStream("examples.tsv");
        Reader reader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        bufferedReader.readLine();
        var line = bufferedReader.readLine();
        while (line != null) {
            var expression = line.split("\t")[0];
            var expectedResult = Integer.parseInt(line.split("\t")[1]);
            var actual = new ExpressionEvaluator(expression).getResult();

            assertEquals(expectedResult, actual, expression);

            line = bufferedReader.readLine();
        }

    }
}
