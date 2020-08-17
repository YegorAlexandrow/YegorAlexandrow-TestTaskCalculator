package com.yegoralexandrow;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static boolean checkOutOfLimit(Number n) {
        return n.getValue() < 1 || n.getValue() > 10;
    }

    public static Number calculate(String expression) {
        try {
            Scanner in = new Scanner(expression);

            Number a = NumberFactory.createNumber(in.next());
            String operator = in.next();
            Number b = NumberFactory.createNumber(in.next());

            if(checkOutOfLimit(a) || checkOutOfLimit(b)) throw new IllegalArgumentException();

            return a.op(operator, b);
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.err.println("Incorrect expression!");
            e.printStackTrace();
            //System.exit(0);
        }
        return new ArabicNumber(1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(calculate(in.nextLine()));
        }

        in.close();
    }
}
