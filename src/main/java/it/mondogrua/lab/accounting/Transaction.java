package it.mondogrua.lab.accounting;


public class Transaction {

    private final Money _money;
    private final CenterId _id;

    // Constructor ------------------------------------------------------------

    public Transaction(CenterId centerId,Money money) {
        _id = centerId;
        _money = money;
    }

    // Public Methods ---------------------------------------------------------

    public boolean idEquals(CenterId id) {
        return _id.equals(id);
    }

    public void addCostTo(CashFlow directCosts) {

        directCosts.addTo(_money);
    }


}
