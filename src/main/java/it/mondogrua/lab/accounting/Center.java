package it.mondogrua.lab.accounting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;



public class Center implements Element {

    private final CenterId _id;

    /**
     * The transaction records belonging to the center.
     */
    private final Collection<Transaction> _transactions = new ArrayList<Transaction>();

    // Constructor ------------------------------------------------------------

    public Center(CenterId centerId) {
        _id = centerId;
    }

    // Public Methods ---------------------------------------------------------

    public String id() {
        return _id.toString();
    }

    public boolean addTransaction(BigDecimal value) {
        return _transactions.add(new Transaction(_id ,new Money(value)));
    }

    public CashFlow directCosts() {
        CashFlow result = new CashFlow(_id);
        for (Transaction transaction : _transactions) {
            transaction.addCostTo(result);
        }

        return result;
    }

    public String name() {
        return _id.name();
    }

	public CashFlow createCashFlow() {
		return new CashFlow(_id);
	}

	@Override
	public void accept(Processor processor) {
		processor.process(this);
	}

}
