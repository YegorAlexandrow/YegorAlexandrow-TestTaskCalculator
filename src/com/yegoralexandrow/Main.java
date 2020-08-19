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

            if(checkOutOfLimit(a) || checkOutOfLimit(b)) throw new IllegalArgumentException("Args should be between 0 and 10");

            return a.op(operator, b);
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.err.println("Incorrect expression!");
            e.printStackTrace();
            //System.exit(0);
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            Number result = calculate(in.nextLine());

            if(result != null) System.out.println(result);
        }

        in.close();
    }
}
