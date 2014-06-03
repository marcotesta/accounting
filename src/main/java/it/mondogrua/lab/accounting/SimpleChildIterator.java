package it.mondogrua.lab.accounting;

public class SimpleChildIterator implements InternalIterator {

    private Center _center;

    public SimpleChildIterator(Center center) {
        _center = center;
    }

    @Override
    public  void traverse(Processor processor) {
        for (Center child : _center) {
            processor.process(child, 0);
        }
    }
}
