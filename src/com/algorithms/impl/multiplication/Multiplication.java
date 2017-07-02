package com.algorithms.impl.multiplication;

import com.algorithms.IAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The multiplication of whole numbers may be thought as a repeated addition;
 * that is, the multiplication of two numbers is equivalent to adding as many copies of one of them, the multiplicand,
 * as the value of the other one, the multiplier.
 *
 * Only positive numbers.
 *
 * @author Vladimir Degtev
 */

public class Multiplication implements IAlgorithm {

    @Override
    public void runAlgorithm() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the M: ");
        int m = Integer.parseInt(reader.readLine());
        System.out.println("Enter the N: ");
        int n = Integer.parseInt(reader.readLine());

        int result = multiply(m,n);
        System.out.println("RESULT: " + result);
    }

    private int multiply(int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        } else if (n == 1) {
            return m;
        } else if (m == 1) {
            return n;
        } else if (n > 1) {
            return m + multiply(m , n - 1);
        } else {
            throw new IllegalArgumentException("wrong input");
        }
    }

}
