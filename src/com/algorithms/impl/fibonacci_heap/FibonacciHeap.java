package com.algorithms.impl.fibonacci_heap;

import com.algorithms.IAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Fibonacci Heap.
 *
 * @author Vladimir Degtev
 */

public class FibonacciHeap implements IAlgorithm {

    private long sum = 0;

    @Override
    public void runAlgorithm() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number: ");
        int fibNumber = Integer.parseInt(reader.readLine());

        for (int i = 0; i <= fibNumber; i++) {
            long result = fibonacci(i);
            sum += result;
            printResult(result);
        }
        System.out.println("TOTAL SUM: " + sum);
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    private void printResult(long result) {
        System.out.println(result);
    }
}
