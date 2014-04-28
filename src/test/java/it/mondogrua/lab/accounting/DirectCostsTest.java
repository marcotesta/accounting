package it.mondogrua.lab.accounting;

import static org.junit.Assert.*;
import it.mondogrua.lab.accounting.Builder;
import it.mondogrua.lab.accounting.CashFlow;
import it.mondogrua.lab.accounting.Center;
import it.mondogrua.lab.accounting.Money;

import java.math.BigDecimal;

import org.junit.Test;

public class DirectCostsTest {

    class Director {

        private Builder _builder;

        public Director(Builder builder) {
            _builder = builder;
        }
        public void construct() {
            _builder.createCenter("#pomodoro:books:english");
            _builder.addTransaction(new BigDecimal("0.50"));
            _builder.addTransaction(new BigDecimal("0.55"));
        }
    }

    @Test
    public void test_DirectCosts() {
        Builder builder = new Builder();
        Director director = new Director(builder);
        director.construct();
        Center english = builder.getProduct();

        CashFlow directCosts = english.directCosts();

        Money expected = new Money(new BigDecimal("1.05"));

        assertEquals(expected, directCosts.amount());
    }

}
