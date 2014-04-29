package it.mondogrua.lab.accounting;

import java.math.BigDecimal;

/**
 * Represent an amount of money related to a Cost Center.
 * Is mutable
 */
public class CashFlow {

    private final CenterId _id;
    private Money _amount;

    // Constructor ------------------------------------------------------------

    public CashFlow(CenterId id) {
        _id = id;
        _amount = new Money(new BigDecimal("0"));
    }

    // Public Methods ---------------------------------------------------------

    public String id() {
        return _id.toString();
    }

    public Money asMoney() {
        return _amount;
    }

    public void addTo(Money money) {
        _amount = _amount.add(money);
    }

}
