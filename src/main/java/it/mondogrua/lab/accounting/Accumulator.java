package it.mondogrua.lab.accounting;

public class Accumulator implements Processor {

    private CashFlow _cashFlow;

    public Accumulator(CashFlow cashFlow) {
        super();
        this._cashFlow = cashFlow;
    }

    @Override
    public void process(Center center, int depth) {
        _cashFlow.add(center.directCosts().asMoney());
    }

}
