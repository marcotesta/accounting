package it.mondogrua.lab.accounting;

public class SimpleChildIterator {

    private Center _center;

    public SimpleChildIterator(Center center) {
        _center = center;
    }

   // public void execute(Command something)
    public void addTo(CashFlow aCashFlow) {
        for (Center center : _center.getChildren()) {
            aCashFlow.addTo(center.branchCosts().asMoney());
        }
    }

}
