package com.yegoralexandrow;

public class ArabicNumber extends Number {

    public ArabicNumber(int value) {
        super(value, NumeralSystem.ARABIC);
    }

    public ArabicNumber(String value) {
        super(Integer.parseInt(value), NumeralSystem.ARABIC);
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
