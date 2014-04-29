package it.mondogrua.lab.accounting;

public class Report {

    private Center _center;

    public Report(Center center) {
        _center = center;
    }

    public void setCenter(Center center) {
        _center = center;
    }

    public CashFlow directCosts() {
        return _center.directCosts();
    }

    public CashFlow branchCosts() {
        return _center.branchCosts();
    }

}
