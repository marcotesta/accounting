package it.mondogrua.lab.accounting;

public class InorderBranchIterator implements InternalIterator {

    private final Center _center;
    private final int _depth;

    public InorderBranchIterator(Center _center) {
        super();
        this._center = _center;
        this._depth = 0;
    }

    protected InorderBranchIterator(Center _center, int _depth) {
        super();
        this._center = _center;
        this._depth = _depth;
    }

    @Override
    public void traverse(Processor processor) {
        for (Center child : _center) {
            new InorderBranchIterator(child, _depth+1).traverse(processor);
        }
        processor.process(_center, _depth);
    }

}
