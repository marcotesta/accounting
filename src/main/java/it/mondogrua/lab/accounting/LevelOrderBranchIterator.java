package it.mondogrua.lab.accounting;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBranchIterator implements InternalIterator {

    private final Node<? extends Element> _root;
    
    public LevelOrderBranchIterator(Node<? extends Element> _root) {
        super();
        this._root = _root;
    }

    @Override
    public void traverse(Processor processor) {
        Queue<Node<? extends Element>> level  = new LinkedList<Node<? extends Element>>();
        level.add(_root);
        while(!level.isEmpty()){
            Node<? extends Element> node = level.poll();
            node.accept(processor);
            for (Node<? extends Element> child : node) {
                level.add(child);
            }
        }
    }

}
