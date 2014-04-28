package it.mondogrua.lab.contabilita_02;

import java.math.BigDecimal;

/**
 * Represent an amount of money related to a Cost Center.
 * Is mutable
 */
public class CacheFlow {

    private final CenterId _id;
    private Money _amount;

    // Constructor ------------------------------------------------------------

    public CacheFlow(CenterId id) {
        _id = id;
        _amount = new Money(new BigDecimal("0"));
    }

    // Public Methods ---------------------------------------------------------

    public Money amount() {
        return _amount;
    }

    public void addTo(Money money) {
        _amount = _amount.add(money);
    }

}
