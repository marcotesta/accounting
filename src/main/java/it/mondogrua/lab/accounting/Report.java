package it.mondogrua.lab.accounting;

public class Report {

    private Node<Center> _node;
    
    private Center _center;

    public Report(Node<Center> node) {
        _node = node;
        _center = node.getElement();
    }

    public void setCenter(Node<Center> node) {
        _node = node;
    }

    public CashFlow directCosts() {
        return _center.directCosts();
    }

    public CashFlow branchCosts() {
        CashFlow result = _center.createCashFlow();
        new PreorderBranchIterator(_node).traverse(new Accumulator(result));
        return result;
    }
    
    public CashFlow childrenCosts() {
        CashFlow result = _center.createCashFlow();
        new SimpleChildIterator(_node).traverse(new Accumulator(result));
        return result;
    }

}
