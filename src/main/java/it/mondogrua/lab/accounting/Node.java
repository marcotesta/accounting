package it.mondogrua.lab.accounting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Node<T extends Element> implements Iterable<Node<T>>, Element {
	
	private final T _element;
	
    private Node<T> _parent = null;

    /**
     * The sub-centers.
     */
    private final Collection<Node<T>> _children = new ArrayList<Node<T>>();
    
    
	public Node(T element) {
		_element = element;
	}
	

    public Node<T> getParent() {
        return _parent;
    }

    private void setParent(Node<T> parent) {
        this._parent = parent;
    }

    public boolean add(Node<T> node) {
    	node.setParent(this);
        return _children.add(node);
    }
    
    @Override
    public Iterator<Node<T>> iterator() {
        return _children.iterator();
    }


	public T getElement() {
		return _element;
	}


	public int getLevel() {
		return _parent == null ? 0 : _parent.getLevel()+1;
	}


	@Override
	public void accept(Processor processor) {
		processor.process(this);
		_element.accept(processor);
	}
	
}
