package it.mondogrua.lab.accounting;

public class PreorderBranchIterator implements InternalIterator {

    private final Node<? extends Element> _node;

    public PreorderBranchIterator(Node<? extends Element> node) {
        _node = node;
    }


    @Override
    public void traverse(Processor processor) {
    	_node.accept(processor);
        for (Node<? extends Element> child : _node) {
            new PreorderBranchIterator(child).traverse(processor);
        }
    }

}
