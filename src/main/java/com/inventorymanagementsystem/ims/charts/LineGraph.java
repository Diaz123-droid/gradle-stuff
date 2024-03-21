package com.inventorymanagementsystem.ims.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class LineGraph extends JPanel {
    public LineGraph() {
        // Create dataset
        XYSeries series1 = new XYSeries("Series 1");
        series1.add(1.0, 2.0);
        series1.add(2.0, 3.0);
        series1.add(3.0, 2.5);
        series1.add(4.0, 4.5);
        series1.add(5.0, 6.0);

        XYSeries series2 = new XYSeries("Series 2");
        series2.add(1.0, 1.5);
        series2.add(2.0, 2.5);
        series2.add(3.0, 2.0);
        series2.add(4.0, 3.5);
        series2.add(5.0, 5.0);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Complex Line Graph Example",
                "X",
                "Y",
                dataset
        );

        // Customize chart
        chart.setBackgroundPaint(Color.white);

        // Create Panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        add(chartPanel);
    }

    public void lineGraph() {
        // Test the panel
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new LineGraph());
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
