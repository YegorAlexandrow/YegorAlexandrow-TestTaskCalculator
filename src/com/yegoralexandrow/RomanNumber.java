package com.yegoralexandrow;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumber extends Number {

    private static final TreeMap<Integer, String> mapToRoman = new TreeMap<Integer, String>();
    private static final Map<Character, Integer> mapFromRoman = new HashMap<>(7);

    static {
        mapToRoman.put(100, "C");
        mapToRoman.put(90, "XC");
        mapToRoman.put(50, "L");
        mapToRoman.put(40, "XL");
        mapToRoman.put(10, "X");
        mapToRoman.put(9, "IX");
        mapToRoman.put(5, "V");
        mapToRoman.put(4, "IV");
        mapToRoman.put(1, "I");

        mapFromRoman.put('I', 1);
        mapFromRoman.put('V', 5);
        mapFromRoman.put('X', 10);
        mapFromRoman.put('L', 50);
        mapFromRoman.put('C', 100);
        mapFromRoman.put('D', 500);
        mapFromRoman.put('M', 1000);
    }

    public RomanNumber(int value) {
        super(value, NumeralSystem.ROMAN);
    }

    public RomanNumber(String value) {
        super(parseRoman(value), NumeralSystem.ROMAN);
    }

    private static int parseRoman(String value) {
        int sum = 0;
        int len = value.length() - 1;
        value = value.toUpperCase();

        for (int i=0; i<len; i++) {
            if (mapFromRoman.get(value.charAt(i)) < mapFromRoman.get(value.charAt(i + 1))) {
                sum -= mapFromRoman.get(value.charAt(i));
            } else {
                sum += mapFromRoman.get(value.charAt(i));
            }
        }

        return sum + mapFromRoman.get(value.charAt(len));
    }

    public String toString() {
        int value = getValue();
        StringBuilder result = new StringBuilder("");

        while(value > 0) {
            int l = mapToRoman.floorKey(value);
            result.append(mapToRoman.get(l));
            value -= l;
        }

        return result.toString();
    }
}
