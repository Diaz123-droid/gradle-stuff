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
        XYSeries series1 = new XYSeries("Stock Records");

        for (int i = 0; i < 25; i++) {
            series1.add(i*10, (int)(Math.random()*20));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                null,
                null,
                null,
                dataset);

        // Customize chart
        chart.setBackgroundPaint(Color.black);

        // Create Panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(900, 600));
        add(chartPanel);
    }

    public LineGraph getLineGraph() {
        return new LineGraph();
    }
}
