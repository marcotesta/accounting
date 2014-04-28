package it.mondogrua.lab.accounting;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BranchCostTest {
    class Director {

        private Builder _builder;

        public Director(Builder builder) {
            _builder = builder;
        }
        public void construct() {
            _builder.createCenter("#pomodoro");
            _builder.addChildCenter("#pomodoro:books");
            _builder.addChildCenter("#pomodoro:books:english");
            _builder.addTransaction(new BigDecimal("0.50"));
            _builder.addSiblingCenter("#pomodoro:books:german");
            _builder.addTransaction(new BigDecimal("0.55"));
        }
    }

    @Test
    public void test_BranchCosts() {
        Builder builder = new Builder();
        Director director = new Director(builder);
        director.construct();
        Center pomodoro = builder.getProduct();

        CashFlow branchCosts = pomodoro.branchCosts();

        Money expected = new Money(new BigDecimal("1.05"));

        assertEquals(expected, branchCosts.amount());
    }

}
