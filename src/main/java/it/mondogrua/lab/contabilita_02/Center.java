package it.mondogrua.lab.contabilita_02;

import java.util.ArrayList;
import java.util.Collection;

public class Center {

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

    public boolean add(Transaction transaction) {

        if (!transaction.idEquals(_id)) {
            return false;
        }

        return _transactions.add(transaction);
    }

    public CacheFlow directCosts() {
        CacheFlow directCosts = new CacheFlow(_id);
        for (Transaction transaction : _transactions) {
            transaction.addCostTo(directCosts);
        }

        return directCosts;
    }

}
