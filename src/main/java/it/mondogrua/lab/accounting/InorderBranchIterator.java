package it.mondogrua.lab.accounting;



import java.util.LinkedList;
import java.util.Queue;

public class InorderBranchIterator implements InternalIterator {

    private final Node<? extends Element> _root;

    public InorderBranchIterator(Node<? extends Element> root) {
        super();
        this._root = root;
    }

    @Override
    public void traverse(Processor processor) {
        Queue<Node<? extends Element>> queue  = new LinkedList<Node<? extends Element>>();

        recursiveAdd(queue, _root);

        while(!queue.isEmpty()){
            Node<? extends Element> node = queue.poll();
            node.accept(processor);
        }
    	
    }

	private void recursiveAdd(Queue<Node<? extends Element>> queue, Node<? extends Element> node) {
		recursiveAdd(queue, node, 0);
	}

	private void recursiveAdd(Queue<Node<? extends Element>> queue, Node<? extends Element> node, int level) {
		for (Node<? extends Element> child : node) {
			recursiveAdd(queue, child, level+1);
        }
		queue.add(node);
	}

}
