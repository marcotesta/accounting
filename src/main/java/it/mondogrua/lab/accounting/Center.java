package it.mondogrua.lab.accounting;

import java.util.ArrayList;
import java.util.Collection;

public class Center {

    private final CenterId _id;

    private Center _parent;

    /**
     * The transaction records belonging to the center.
     */
    private final Collection<Transaction> _transactions = new ArrayList<Transaction>();

    /**
     * The sub-centers.
     */
    private final Collection<Center> _children = new ArrayList<Center>();

    // Constructor ------------------------------------------------------------

    public Center(CenterId centerId) {
        _id = centerId;
    }

    // Public Methods ---------------------------------------------------------

    public String id() {
        return _id.toString();
    }

    public Center getParent() {
        return _parent;
    }

    public void setParent(Center parent) {
        this._parent = parent;
    }

    public boolean add(Transaction transaction) {

        if (!transaction.idEquals(_id)) {
            return false;
        }

        return _transactions.add(transaction);
    }

    public boolean add(Center center) {
        // TODO controllare che sia effettivamenete un figlio
        return _children.add(center);
    }

    public CashFlow directCosts() {
        CashFlow result = new CashFlow(_id);
        for (Transaction transaction : _transactions) {
            transaction.addCostTo(result);
        }

        return result;
    }

    public CashFlow branchCosts() {
        CashFlow result = directCosts();
        // o cosi
        new SimpleChildIterator(this).addTo(result);

        // o cosi
        for (Center child : _children) {
            result.addTo(child.branchCosts().asMoney());
        }


        return result;
    }

    public Collection<Center> getChildren() {
        return null;
    }

}
