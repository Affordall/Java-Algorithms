package com.algorithms.impl.quick_hull;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class create ArrayList of Points with specified Quantity. Generate random values with selected Seed and fills the list.
 * Also prints the list in console.
 *
 * @author Vladimir Degtev
 */

public class ListHelper implements IListHelper {

    private int pointQuantity;
    private ArrayList<Point> list;
    /**
     * SEED - The seed is the initial value of the internal state of the pseudorandom number generator.
     */
    private static final int SEED = 12;

    /**
     * Constructor of the class.
     */
    public ListHelper() {
        this.list = new ArrayList<>();
    }

    /**
     * Generate list of points with spec quantity, fills it.
     * @param quantity - quantity of points
     * @return filled list
     */
    @Override
    public ArrayList<Point> generateCompleteList(int quantity) {
        if (quantity == 0 || quantity < 0) {
            throw new IllegalArgumentException("Quantity of point cannot be null or negative");
        }
        this.pointQuantity = quantity;
        fillPointList();
        return list;
    }

    /**
     * Generate and set the coordinates of Points with random values.
     */
    private void fillPointList() {
        Random gen = new Random(SEED);
        for (int i = 0; i < pointQuantity; i++) {
            list.add(new Point(gen.nextInt(pointQuantity), gen.nextInt(pointQuantity)));
        }
    }

    /**
     * Prints the incoming list and message in console.
     * @param message inc tag of list
     * @param arrayList inc list of Point to print
     */
    @Override
    public void printList(String message, ArrayList<Point> arrayList) {
        String output = "----------- " + message + " -----------";
        System.out.println(output);
        arrayList.forEach(System.out::println);
        for (int i = 0; i < output.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
