package com.algorithms.impl.quick_hull;

import java.util.ArrayList;

public interface IListHelper {
    ArrayList<Point> generateCompleteList(int quantity);
    void printList(String message, ArrayList<Point> list);
}
