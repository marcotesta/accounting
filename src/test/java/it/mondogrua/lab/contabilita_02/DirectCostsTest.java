package it.mondogrua.lab.contabilita_02;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class DirectCostsTest {

    @Test
    public void test_DirectCosts() {
        Builder builder = new Builder();
        Center english = builder.newCenter("#pomodoro:books:english");

        Transaction translation = builder.newTransaction("#pomodoro:books:english", new BigDecimal("0.50"));
        english.add(translation);

        Transaction promotion = builder.newTransaction("#pomodoro:books:english", new BigDecimal("0.55"));
        english.add(promotion);

        CacheFlow directCosts = english.directCosts();

        Money expected = new Money(new BigDecimal("1.05"));

        assertEquals(expected, directCosts.amount());
    }

}
