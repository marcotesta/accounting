package it.mondogrua.lab.accounting;

public class SimpleChildIterator implements InternalIterator {

    private Node<? extends Element> _node;

    public SimpleChildIterator(Node<? extends Element> node) {
        _node = node;
    }

    @Override
    public  void traverse(Processor processor) {
        for (Node<? extends Element> child : _node) {
        	child.accept(processor);
        }
    }
}
