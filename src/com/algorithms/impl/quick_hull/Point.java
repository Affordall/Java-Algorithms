package com.algorithms.impl.quick_hull;

/**
 * Class represent point in R^2. Point have x- and y-coordinate.
 * You can access and manipulate its
 * coordinates and print it out as a string.
 *
 * @author Vladimir Degtev, Sebastian Bauer
 */

public class Point implements Comparable<Point> {

    private int x;
    private int y;

    /**
     * Creates a new point in R^2.
     *
     * @param oX the x-coordinate (in R)
     * @param oY the y-coordinate (in R)
     */
    public Point(int oX, int oY) {
        this.x = oX;
        this.y = oY;
    }

    /**
     *
     * @return x value of point.
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return y value of point.
     */
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    /**
     * A segment defined by points PS PE and checking on which side of PS PE
     * a third point PF falls, you only need to compute the cross product
     * (произведение векторов) PS PE x PS PF and check it sign.
     * If it's negative, it will be on the "right" side of PS PE
     * (if standing on PS and looking toward at PE).
     * If positive then point PF will be on the "left" side;
     * @param ps - start point of line
     * @param pe - end point of line
     * @param pf - point that need to calculate location.
     * @return sign of PF to determine of "side" half-set.
     */
    private int pointLocation(Point ps, Point pe, Point pf) {
        int cp1 = (pe.getX() - ps.getX()) * (pf.getY() - ps.getY()) - (pe.getY() - ps.getY()) * (pf.getX() - ps.getX());
        return (cp1 > 0) ? 1 : -1;
    }

    /**
     * A point is considered left of a line between points from and to if it is
     * on the lefthand side when looking along the line from point "from" to
     * point "to".
     *
     * The method uses the cross-product to determine if this point is left of
     * the line.
     *
     * @param from Point from which the line is drawn and from where we "look"
     * along the line in direction of point "to" to determine whether the point
     * is left or right of it.
     * @param to Point to which the line is drawn
     */
    public boolean isOnLeftSide(Point from, Point to) {
        return Integer.compare(pointLocation(from, to, this), 0) > 0;
    }

    /**
     * Calculates the distance of this point to the line which is formed by points a and b.
     * @param ps - start point of line
     * @param pe - end point of line
     * @return The distance to the line.
     */
    public double getDistanceToLine(Point ps, Point pe) {
        return Math.abs((pe.getX() - ps.getX()) * (ps.getY() - this.y) - (ps.getX() - this.x) * (pe.getY() - ps.getY()))
                / Math.sqrt(Math.pow(pe.getX() - ps.getX(), 2) + Math.pow(pe.getY() - ps.getY(), 2));
    }


    /**
     * To make of Point is sorting in Collections
     * @param p - point
     * @return compared value
     */
    @Override
    public int compareTo(Point p) {
        if (this.x == p.getX()) {
            return this.y - p.getY();
        } else {
            return this.x - p.getX();
        }
    }
}
