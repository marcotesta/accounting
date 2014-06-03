package it.mondogrua.lab.accounting;

public class PreorderBranchIterator implements InternalIterator {

    private final Center _center;
    private final int _depth;

    public PreorderBranchIterator(Center center) {
        _center = center;
        _depth = 0;
    }

    protected PreorderBranchIterator(Center center, int depth) {
        _center = center;
        _depth = depth;
    }

    @Override
    public void traverse(Processor processor) {
        processor.process(_center, _depth);
        for (Center child : _center) {
            new PreorderBranchIterator(child, _depth+1).traverse(processor);
        }
    }

}
