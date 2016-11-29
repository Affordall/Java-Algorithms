package com.algorithms.impl.permute_heap;

import com.algorithms.IAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Heap's algorithm generates all possible permutations of N objects.
 *
 * @author Vladimir Degtev
 */

public class HeapPermute implements IAlgorithm {

    private static final String OUT_OF_RANGE = "Null. Out of range.";
    private int searchPosition;
    /**
     * Count to calculate searching position
     * */
    private int hiddenCount;
    /**
     * Default string value of foundSequence
     * */
    private String foundSequence = OUT_OF_RANGE;

    @Override
    public void runAlgorithm() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of elements in a sequence: ");
        int count = Integer.parseInt(reader.readLine());

        System.out.println("Enter the sequence: ");

//        int elem[] = new int[10];
//        for (int i = 0; i < 10; i++) {
//            elem[i] = i;
//        }
//
//        int sequence[][] = new int[3][];
//        for (int i = 0; i < 3; i++) {
//            sequence[i] = elem;
//        }

        int sequence[] = new int[count];
        for (int i = 0; i < count; i++) {
            sequence[i] = Integer.parseInt(reader.readLine());
        }

        System.out.println("Enter the position of element to search (Or press Enter, if you don't need this): ");
        String position = reader.readLine();

        if (position != null && !position.isEmpty()) {
            int intToBeFound = Integer.parseInt(position);
            runAlgorithm(sequence, count, intToBeFound);
        } else {
            runAlgorithm(sequence, count);
        }
    }

    /**
     * Implementation of the HeapPermute algorithm.
     * @param v - sequence of elements
     * @param n - count of elements
     */
    private synchronized void runAlgorithm(int[] v, int n) {
        permute(v, n);
        printTotalPermutationsCount();
    }

    /**
     * Implementation of the HeapPermute algorithm with search by position
     * @param v - sequence of elements
     * @param n - count of elements
     * @param positionToSearch - position of wanted sequence
     */
    private synchronized void runAlgorithm(int[] v, int n, int positionToSearch) {
        this.searchPosition = positionToSearch;
        permute(v, n);
        printTotalPermutationsCount();
        System.out.println("AT POSITION: " + searchPosition + ", SEQUENCE IS: " + foundSequence);
    }

    private void permute(int[] v, int n) {
        if (n == 1) {
            hiddenCount++;
            if (hiddenCount == searchPosition) {
                foundSequence = Arrays.toString(v);
            }
            System.out.println(Arrays.toString(v));
        }
        else {
            for (int i = 0; i < n; i++) {
                permute(v, n - 1);
                if (n % 2 == 1) {
                    swap(v, 0, n - 1);
                }
                else {
                    swap(v, i, n - 1);
                }

            }
        }
    }

    /***
     * Swap position elements in array
     * @param v incoming array
     * @param i - an element that is changing
     * @param j - an element on which change
     */
    private void swap(int[] v, int i, int j) {
        int t = v[i];
        v[i] = v[j];
        v[j] = t;
    }

    private void printTotalPermutationsCount() {
        System.out.println("TOTAL PERMUTATIONS COUNT: " + hiddenCount);
    }
}
