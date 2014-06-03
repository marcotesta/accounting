package it.mondogrua.lab.accounting;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class PrintTreeTest {

    private Builder builder = new Builder();

    @Test
    public void printPreorderTree() {
        String expected = new String(
                "#\n"
                + "  pomodoro\n"
                + "    books\n"
                + "      english\n"
                + "      german\n"
                + "    site\n"
                + "      hosting\n"
                );

        builder.createCenter("#");
        builder.addChildCenter("#pomodoro");
        builder.addChildCenter("#pomodoro:books");
        builder.addChildCenter("#pomodoro:books:english");
        builder.addSiblingCenter("#pomodoro:books:german");
        builder.addToParent("#pomodoro","#pomodoro:site");
        builder.addChildCenter("#pomodoro:site:hosting");
        Center root = builder.getProduct();

        StringBuilder result = new StringBuilder();
        new PreorderBranchIterator(root).traverse(new Printer(result));

        assertEquals(expected, result.toString());
    }

    @Test
    public void printInorderTree() {
        String expected = new String(""
                + "      english\n"
                + "      german\n"
                + "    books\n"
                + "      hosting\n"
                + "    site\n"
                + "  pomodoro\n"
                + "#\n"
                );

        builder.createCenter("#");
        builder.addChildCenter("#pomodoro");
        builder.addChildCenter("#pomodoro:books");
        builder.addChildCenter("#pomodoro:books:english");
        builder.addSiblingCenter("#pomodoro:books:german");
        builder.addToParent("#pomodoro","#pomodoro:site");
        builder.addChildCenter("#pomodoro:site:hosting");
        Center root = builder.getProduct();

        StringBuilder result = new StringBuilder();
        new InorderBranchIterator(root).traverse(new Printer(result));

        assertEquals(expected, result.toString());
    }

    @Test
    public void printLevelOrderTree() {
        String expected = new String(""
                + "#\n"
                + "  pomodoro\n"
                + "    books\n"
                + "    site\n"
                + "      english\n"
                + "      german\n"
                + "      hosting\n"
                );

        builder.createCenter("#");
        builder.addChildCenter("#pomodoro");
        builder.addChildCenter("#pomodoro:books");
        builder.addChildCenter("#pomodoro:books:english");
        builder.addSiblingCenter("#pomodoro:books:german");
        builder.addToParent("#pomodoro","#pomodoro:site");
        builder.addChildCenter("#pomodoro:site:hosting");
        Center root = builder.getProduct();

        StringBuilder result = new StringBuilder();
        new LevelOrderBranchIterator(root).traverse(new Printer(result));

        assertEquals(expected, result.toString());
    }
}
