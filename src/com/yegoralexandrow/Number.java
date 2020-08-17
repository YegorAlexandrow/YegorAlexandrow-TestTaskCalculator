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
            default: throw new IllegalArgumentException();
        }
    }

    public Number plus(Number num) {
        if(num.getValue() <= 0 || this.getRepresentation() != num.getRepresentation()) throw new IllegalArgumentException();

        return NumberFactory.createNumber(this.value + num.getValue(), getRepresentation());
    }

    public Number minus(Number num) {
        if(num.getValue() >= this.getValue() || this.getRepresentation() != num.getRepresentation()) throw new IllegalArgumentException();

        return NumberFactory.createNumber(this.value - num.getValue(), getRepresentation());
    }

    public Number divide(Number num) {
        if(num.getValue() <= 0 || this.getRepresentation() != num.getRepresentation()) throw new IllegalArgumentException();

        return NumberFactory.createNumber(this.value / num.getValue(), getRepresentation());
    }

    public Number multiply(Number num) {
        if(num.getValue() <= 0 || this.getRepresentation() != num.getRepresentation()) throw new IllegalArgumentException();

        return NumberFactory.createNumber(this.value * num.getValue(), getRepresentation());
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(value <= 0) throw new IllegalArgumentException();

        this.value = value;
    }

    public NumeralSystem getRepresentation() {
        return representation;
    }

    public void setRepresentation(NumeralSystem representation) {
        this.representation = representation;
    }
}
