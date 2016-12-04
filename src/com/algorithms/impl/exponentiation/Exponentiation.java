package com.algorithms.impl.exponentiation;

import com.algorithms.IAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Exponentiation is a mathematical operation, written as b^n, involving two numbers, the base b and the exponent n.
 *
 * @author Vladimir Degtev
 */

public class Exponentiation implements IAlgorithm {

    @Override
    public void runAlgorithm() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the base: ");
        int base = Integer.parseInt(reader.readLine());

        System.out.println("Enter the exponent: ");
        int exponent = Integer.parseInt(reader.readLine());

        int result = calculate(base, exponent);
        System.out.println("RESULT: " + result);
    }

    private int calculate(int base, int exponent) {
        int commonExponent = exponent / 2;
        if (isEven(exponent)) {
            return (int) ((Math.pow(base, commonExponent)) * (Math.pow(base, commonExponent)));
        } else {
            double exp = round(commonExponent, 2);
            return (int) ((int) (base * (Math.pow(base, exp))) * (Math.pow(base, exp)));
        }
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.FLOOR);
        return bd.doubleValue();
    }

    private boolean isEven(int num) {
        return (num % 2 == 0);
    }
}
