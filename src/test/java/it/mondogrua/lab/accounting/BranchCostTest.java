package it.mondogrua.lab.accounting;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BranchCostTest {

    private Builder builder = new Builder();


    @Test
    public void branchCostsForCenterWithSubCenters() {
        Money expected = new Money(new BigDecimal("1.05"));

        builder.createCenter("#pomodoro");
        builder.addChildCenter("#pomodoro:books");
        builder.addChildCenter("#pomodoro:books:english");
        builder.addTransaction(new BigDecimal("0.50"));
        builder.addSiblingCenter("#pomodoro:books:german");
        builder.addTransaction(new BigDecimal("0.55"));
        Center pomodoro = builder.getProduct();

        assertEquals(expected, new Report(pomodoro).branchCosts().asMoney());
    }

}
