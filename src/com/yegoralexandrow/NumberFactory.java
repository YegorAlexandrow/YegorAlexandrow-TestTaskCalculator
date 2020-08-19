package com.yegoralexandrow;

public class NumberFactory {

    private NumberFactory() {}

    public static Number createNumber(String value) {
        switch (determineNumeralSystem(value)) {

            case UNDEFINED: throw new IllegalArgumentException("Unknown numeral system");

            case ROMAN: return new RomanNumber(value);

            case ARABIC: return new ArabicNumber(value);
        }

        return new ArabicNumber(1);
    }

    public static Number createNumber(int value, NumeralSystem representation) {
        switch (representation) {

            case UNDEFINED: throw new IllegalArgumentException("Unknown numeral system");

            case ROMAN: return new RomanNumber(value);

            case ARABIC: return new ArabicNumber(value);
        }

        return new ArabicNumber(1);
    }

    private static NumeralSystem determineNumeralSystem(String value) {
        boolean isArabic = true, isRoman = true;

        for(int i=0; i<value.length(); i++) {
            isRoman &= "ivxlcdmIVXLCDM".indexOf(value.charAt(i)) != -1;
            isArabic &= '0' <= value.charAt(i) && value.charAt(i) <= '9';
        }

        if(isArabic) return NumeralSystem.ARABIC;
        if(isRoman) return NumeralSystem.ROMAN;

        return NumeralSystem.UNDEFINED;
    }
}
