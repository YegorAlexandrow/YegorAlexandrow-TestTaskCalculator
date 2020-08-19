package com.yegoralexandrow;

public class Number {

    private int value;
    private NumeralSystem representation = NumeralSystem.ARABIC;

    protected Number(int value, NumeralSystem representation) {
        setValue(value);
        setRepresentation(representation);
    }

    public Number op(String op, Number num) {
        switch (op) {
            case "+": return this.plus(num);
            case "-": return this.minus(num);
            case "/": return this.divide(num);
            case "*": return this.multiply(num);
            default: throw new IllegalArgumentException("Unknown operation");
        }
    }

    public Number plus(Number num) {
        if(this.getRepresentation() != num.getRepresentation()) throw new IllegalArgumentException("Number systems mismatch");

        return NumberFactory.createNumber(this.value + num.getValue(), getRepresentation());
    }

    public Number minus(Number num) {
        if(this.getRepresentation() != num.getRepresentation()) throw new IllegalArgumentException("Number systems mismatch");

        return NumberFactory.createNumber(this.value - num.getValue(), getRepresentation());
    }

    public Number divide(Number num) {
        if(this.getRepresentation() != num.getRepresentation()) throw new IllegalArgumentException("Number systems mismatch");

        return NumberFactory.createNumber(this.value / num.getValue(), getRepresentation());
    }

    public Number multiply(Number num) {
        if(this.getRepresentation() != num.getRepresentation()) throw new IllegalArgumentException("Number systems mismatch");

        return NumberFactory.createNumber(this.value * num.getValue(), getRepresentation());
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NumeralSystem getRepresentation() {
        return representation;
    }

    public void setRepresentation(NumeralSystem representation) {
        this.representation = representation;
    }
}
