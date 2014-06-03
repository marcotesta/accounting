package it.mondogrua.lab.accounting;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class DirectCostsTest {

    private Builder fBuilder = new Builder();

    @Test
    public void directCostsForCenterWithTwoTransactions() {
        Money expected = new Money(new BigDecimal("1.05"));

        fBuilder.createCenter("#pomodoro:books:english");
        fBuilder.addTransaction(new BigDecimal("0.50"));
        fBuilder.addTransaction(new BigDecimal("0.55"));
        Center english = fBuilder.getProduct();

        assertEquals(expected, new Report(english).directCosts().asMoney());
    }

}
