package it.mondogrua.lab.accounting;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

public class Builder {

    private Center _rootCenter = null;
    private Center _currentCenter = null;

    public void createCenter(String centerIdStr) {
        CenterId centerId = getCenterId(centerIdStr);
        _rootCenter = new Center(centerId);
        _currentCenter = _rootCenter;
    }

    public void addChildCenter(String centerIdStr) {
        CenterId centerId = getCenterId(centerIdStr);
        Center center = new Center(centerId);
        center.setParent(_currentCenter);
        _currentCenter.add(center);
        _currentCenter = center;
    }

    public void addSiblingCenter(String centerIdStr) {
        CenterId centerId = getCenterId(centerIdStr);
        Center center = new Center(centerId);
        Center parent  = _currentCenter.getParent();
        parent.add(center);
        _currentCenter = center;
    }

    public void addToParent(String centerIdStr) {
        Center parent = getParent(centerIdStr);
        if (parent == null) {
            throw new InvalidParameterException();
        }
        _currentCenter = parent;
        addChildCenter(centerIdStr);
    }

    public void addTransaction(BigDecimal bigDecimal) {
        String centerIdString = _rootCenter.id();
        Transaction translation = newTransaction(centerIdString, bigDecimal);
        _rootCenter.add(translation);
    }

    public Center getProduct() {
        return _rootCenter;
    }

    // Protected Methods ---------------------------------------------------------

    protected Center getParent(String id) {
        Center result = _currentCenter;

        while (result!= null && !result.id().equals(id)) {
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

    private Transaction newTransaction(String centerIdString, BigDecimal value) {

        CenterId id = getCenterId(centerIdString);
        Money money = new Money(value);
        return new Transaction(id ,money);
    }

}
