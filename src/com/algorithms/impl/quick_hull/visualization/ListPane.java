package com.algorithms.impl.quick_hull.visualization;

import com.algorithms.impl.quick_hull.Point;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class ListPane extends JLayeredPane {

    private ArrayList<Point> list;

    public ListPane(ArrayList<Point> list) {
        this.list = list;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int capacity = list.size();

        int[] xArray = new int[capacity];
        int[] yArray = new int[capacity];
        int nPoint = capacity;
        for (int i = 0; i < capacity; i++) {
            xArray[i] = list.get(i).getX();
            yArray[i] = list.get(i).getY();
        }
        Color newColor = new Color(0, 0, 255);
        g.setColor(newColor);
        g.drawPolygon(xArray, yArray, nPoint);
    }
}
