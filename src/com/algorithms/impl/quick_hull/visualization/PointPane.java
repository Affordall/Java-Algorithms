package com.algorithms.impl.quick_hull.visualization;

import com.algorithms.impl.quick_hull.Point;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class PointPane extends JLayeredPane {

    private ArrayList<Point> list;

    public PointPane(ArrayList<Point> list) {
        this.list = list;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Baseline
        int x = (getWidth() / 2);
        int y = (getHeight() / 2);

        int capacity = list.size();
        int nPoint = capacity;

        Color oldColor = new Color(255, 0 , 0);

        g.setColor(oldColor);

        for (int i = 0; i < capacity; i++) {
            int xP = list.get(i).getX();
            int yP = list.get(i).getY();
            g.drawLine(xP, yP, xP, yP);
        }
    }
}
