package com.algorithms.impl.quick_hull.visualization;

import com.algorithms.impl.quick_hull.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PointPanel implements IPointPanel {

    private JFrame frame;
    private LayoutManager overlay;

    public PointPanel() {
        init();
    }

    private void init() {
        frame = new JFrame("QuickHull");
        frame.setBounds(0, 0, 800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void drawOrigListPoints(ArrayList<Point> list) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JLayeredPane pointPanel = new PointPane(list);
                overlay = new OverlayLayout(pointPanel);
                pointPanel.setLayout(overlay);
                frame.add(pointPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    @Override
    public void drawResult(ArrayList<Point> list) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JLayeredPane listPanel = new ListPane(list);
                overlay = new OverlayLayout(listPanel);
                listPanel.setLayout(overlay);
                frame.add(listPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
