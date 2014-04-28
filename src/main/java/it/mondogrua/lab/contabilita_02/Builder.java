package it.mondogrua.lab.contabilita_02;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

public class Builder {

    public Center newCenter(String centerIdStr) {
        CenterId centerId = newCenterId(centerIdStr);
        return new Center(centerId);
    }

    private CenterId newCenterId(String centerIdString) {
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

    public Transaction newTransaction(String centerIdString, BigDecimal value) {

        CenterId id = newCenterId(centerIdString);
        Money money = new Money(value);
        return new Transaction(id ,money);
    }

}
