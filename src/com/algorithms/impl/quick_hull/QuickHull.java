package com.algorithms.impl.quick_hull;

import com.algorithms.IAlgorithm;
import com.algorithms.impl.quick_hull.visualization.PointPanel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * QuickHull is an algorithm to compute the convex hull of a set of points. The time complexity is O(n^2) in the worst
 * case and O(n*log n) on average case.
 *
 * @author Vladimir Degtev
 */

public class QuickHull implements IAlgorithm {

    @Override
    public void runAlgorithm() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Would you like to see visualization? (max 500 points) (y/n)");

        boolean showGraph = readBoolean(reader);

        System.out.println("Please enter quantity of points: ");

        int pointsQuantity = Integer.parseInt(reader.readLine());

        ListHelper listHelper = new ListHelper();
        ArrayList<Point> list = listHelper.generateCompleteList(pointsQuantity);
        listHelper.printList("Original list",list);

        QuickHull qh = new QuickHull();
        ArrayList<Point> convexHull = qh.computeQuickHull(list);
        listHelper.printList("Convex Hull list",convexHull);

        if (showGraph) {
            PointPanel canvas = new PointPanel();
            canvas.drawOrigListPoints(list);
            canvas.drawResult(convexHull);
        }
    }

    private static boolean readBoolean(BufferedReader bf) throws IOException {
        String s = bf.readLine();
        if (s.equals("y")) {
            return true;
        } else if (s.equals("n")) {
            return false;
        }
        return false;
    }

    private ArrayList<Point> computeQuickHull(ArrayList<Point> inputList) {
        return quickHull(inputList);
    }

    /**
     * Implementation of the QuickHull algorithm.
     * @param inputList - incoming list of Points
     * @return A list of points which form the convex hull of the given list of points.
     */
    private ArrayList<Point> quickHull(ArrayList<Point> inputList) {
        if (inputList.isEmpty()) {
            throw new IllegalArgumentException("List of Points must not be null.");
        }
        ArrayList<Point> convexHull = new ArrayList<>();

        // search for extreme values
        sortList(inputList);
        Point mostRightPoint = inputList.get(0);
        Point mostLeftPoint = inputList.get(inputList.size() - 1);
        // ===========================================

//        // search for extreme values  - alternative way
//        Point mostRightPoint = inputList.get(0);
//        Point mostLeftPoint = inputList.get(0);
//        for (Point point : inputList) {
//            if (point.getX() < mostRightPoint.getX()) {
//                mostRightPoint = point;
//            } else if (point.getX() > mostLeftPoint.getX()) {
//                mostLeftPoint = point;
//            }
//        }
//        // ===========================================

        System.out.println("Most Right Point: " + mostRightPoint);
        System.out.println("Most Left Point: " + mostLeftPoint);

        // divide the set in two half-sets
        ArrayList<Point> leftHalfSet = new ArrayList<>();
        ArrayList<Point> rightHalfSet = new ArrayList<>();

        for (Point point : inputList) {
            if (point.equals(mostRightPoint) || point.equals(mostLeftPoint)) {
                continue;
            }
            if (point.isOnLeftSide(mostLeftPoint, mostRightPoint)) {
                leftHalfSet.add(point);
            } else {
                rightHalfSet.add(point);
            }
        }

        // add the Most Left Point in final list of Convex Hull.
        convexHull.add(mostLeftPoint);
        // find the Hull of leftHalfSet
        List<Point> hull = divide(leftHalfSet, mostLeftPoint, mostRightPoint);
        convexHull.addAll(hull);
        // add the Most Right Point in final list of Convex Hull.
        convexHull.add(mostRightPoint);
        // find the Hull of rightHalfSet
        hull = divide(rightHalfSet, mostRightPoint, mostLeftPoint);
        convexHull.addAll(hull);

        return convexHull;
    }

    /**
     * Sort incoming list
     * @param list - inc list of Points
     */
    private void sortList(ArrayList<Point> list) {
        Collections.sort(list);
    }

    /**
     * Recursive implementation of QuickHull to find the farthermost point to the line between the points p1
     * and p2 and divide the list of points.
     * @param points - inc list
     * @param p1 - point 1
     * @param p2 - point 2
     * @return divided list
     */
    private List<Point> divide(List<Point> points, Point p1, Point p2) {

        ArrayList<Point> hull = new ArrayList<>();

        if (points.isEmpty()) {
            return hull;
        } else if (points.size() == 1) {
            hull.add(points.get(0));
            return hull;
        }

        Point maxDistancePoint = points.get(0);
        List<Point> l1 = new LinkedList<>();
        List<Point> l2 = new LinkedList<>();
        double distance = 0.0;
        for (Point point : points) {
            if (point.getDistanceToLine(p1, p2) > distance) {
                distance = point.getDistanceToLine(p1, p2);
                maxDistancePoint = point;
            }
        }

        // remove non-hull vertices
        points.remove(maxDistancePoint);

        for (Point point : points) {
            if (point.isOnLeftSide(p1, maxDistancePoint)) {
                l1.add(point);
            } else if (point.isOnLeftSide(maxDistancePoint, p2)) {
                l2.add(point);
            }
        }

        points.clear();

        List <Point> hullPart = divide(l1, p1, maxDistancePoint);
        hull.addAll(hullPart);
        hull.add(maxDistancePoint);
        hullPart = divide(l2, maxDistancePoint, p2);
        hull.addAll(hullPart);

        return hull;
    }


}
