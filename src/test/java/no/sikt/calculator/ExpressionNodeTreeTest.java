package no.sikt.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionNodeTreeTest {

    @Test
    void buildTree_basic_add() {
        var expression = new String[] { "1", "1", "+" };
        var nodeTree = ExpressionNodeTree.buildTree(expression);
        assertEquals("(1 + 1)", nodeTree.toString());
    }

    @Test
    void buildTree_basic_subtract() {
        var expression = new String[] { "1", "1", "-" };
        var nodeTree = ExpressionNodeTree.buildTree(expression);
        assertEquals("(1 - 1)", nodeTree.toString());
    }

    @Test
    void buildTree_basic_divide() {
        var expression = new String[] { "1", "1", "/" };
        var nodeTree = ExpressionNodeTree.buildTree(expression);
        assertEquals("(1 / 1)", nodeTree.toString());
    }

    @Test
    void buildTree_basic_multiply() {
        var expression = new String[] { "1", "1", "*" };
        var nodeTree = ExpressionNodeTree.buildTree(expression);
        assertEquals("(1 * 1)", nodeTree.toString());
    }

    @Test
    void buildTree_2_layers() {
        var expression = new String[] { "1", "1", "*", "1", "/" };
        var nodeTree = ExpressionNodeTree.buildTree(expression);
        assertEquals("((1 * 1) / 1)", nodeTree.toString());
    }
}