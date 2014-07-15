package it.mondogrua.lab.accounting;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

public class Builder {

    private Node<Center> _rootNode = null;
    private Node<Center> _currentNode = null;

    public void createCenter(String centerIdStr) {
        Center center = new Center(getCenterId(centerIdStr));
		_rootNode = new Node<Center>(center);
        _currentNode = _rootNode;
    }

    public void addChildCenter(String centerIdStr) {
        Center center = new Center(getCenterId(centerIdStr));
        Node<Center> node = new Node<Center>(center);
        _currentNode.add(node);
        _currentNode = node;
    }

    public void addSiblingCenter(String centerIdStr) {
        Center center = new Center(getCenterId(centerIdStr));
        Node<Center> node = new Node<Center>(center);
        _currentNode.getParent().add(node);
        _currentNode = node;
    }

    public void addToParent(String parentIdStr, String centerIdStr) {
        Node<Center> parent = getParent(parentIdStr);
        if (parent == null) {
            throw new InvalidParameterException();
        }
        _currentNode = parent;
        addChildCenter(centerIdStr);
    }

    public void addTransaction(BigDecimal value) {
        _rootNode.getElement().addTransaction(value);
    }

    public Node<Center> getProduct() {
        return _rootNode;
    }

    // Protected Methods ---------------------------------------------------------

    protected Node<Center> getParent(String id) {
        Node<Center> result = _currentNode;

        while (result!= null && !result.getElement().id().equals(id)) {
            result = result.getParent();
        }
        return result;
    }

    // Private Method ---------------------------------------------------------

    private CenterId getCenterId(String centerIdString) {
        if (centerIdString == null ||
                centerIdString.length() < 1) {
            throw new InvalidParameterException("Center ID cannot be empty");
        }

        if (!centerIdString.substring(0, 1).equals(CenterId.ROOT_NAME)) {
            throw new InvalidParameterException("ID must start with '"+CenterId.ROOT_NAME+"'");
        }

        if (centerIdString.length() == 1) {
            return CenterId.ROOT;
        }

        CenterId id = CenterId.ROOT;

        String[] tokens = centerIdString.substring(1).split(CenterId.SEPARATOR);
        for (String token : tokens) {
            id = id.add(token);
        }
        return id;
    }

    

}
