package it.mondogrua.lab.contabilita_02;


import java.math.BigDecimal;

/**
 * Value object representing a certain amount of money
 *
 */
public class Money {

    private final BigDecimal _value;

    // Constructor ------------------------------------------------------------

    public Money(BigDecimal value) {
        _value = value;
    }

    // Overridden Object Methods ----------------------------------------------

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_value == null) ? 0 : _value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Money other = (Money) obj;
        if (_value == null) {
            if (other._value != null) {
                return false;
            }
        } else if (!_value.equals(other._value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Money [value=" + _value + "]";
    }

    // Public Methods ---------------------------------------------------------

    public Money add(Money augend) {
        return new Money(_value.add(augend._value));
    }


}
