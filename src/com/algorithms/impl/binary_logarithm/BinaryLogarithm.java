package com.algorithms.impl.binary_logarithm;

import com.algorithms.IAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * In mathematics, the binary logarithm (log2( n)) is the power to which the number 2 must be raised to obtain the value n.
 * The binary logarithm is the logarithm to the base 2.
 * The binary logarithm function is the inverse function of the power of two function.
 *
 * @author Vladimir Degtev
 */

public class BinaryLogarithm implements IAlgorithm {

    @Override
    public void runAlgorithm() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the N: ");
        int n = Integer.parseInt(reader.readLine());

        double result = log(n);
        System.out.println("RESULT: " + result);
    }

    private double log(int n) {
        if (n == 1) {
            return 0;
        } else if (n > 1) {
            return 1 + log(n / 2);
        } else {
            throw new IllegalArgumentException("Wrong Input");
        }
    }

}
