package com.inventorymanagementsystem.ims.charts;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.text.MessageFormat;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CombinedLineBarGraph extends JPanel {
    private CombinedDomainXYPlot plot;
    
    public CombinedLineBarGraph() {
        XYSeries series1 = new XYSeries("Stock Records Line Graph");
        plot = new CombinedDomainXYPlot();

        for (int i = 0; i < 25; i++) {
            series1.add(i * 10, (int) (Math.random() * 20));
        }

        XYSeriesCollection lineDataset = new XYSeriesCollection();
        lineDataset.addSeries(series1);

        // Create chart
        JFreeChart lineChart = ChartFactory.createXYLineChart(
                null,
                null,
                null,
                lineDataset);
        lineChart.setBackgroundPaint(Color.black); // Customize chart background

        JFreeChart barChart = ChartFactory.createBarChart(TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, null, PlotOrientation.HORIZONTAL, isBackgroundSet(), getIgnoreRepaint(), getFocusTraversalKeysEnabled());
        barChart.setBackgroundPaint(Color.black); // Customize chart background

        // Get the plot and set its background color
        XYPlot linePlot = (XYPlot) lineChart.getPlot();
        linePlot.setBackgroundPaint(Color.black);

        XYPlot barPlot = (XYPlot) barChart.getPlot();
        barPlot.setBackgroundPaint(Color.BLACK);

        plot.setDomainPannable(true);
        plot.add(linePlot,1);
        plot.add(barPlot,1);

        // Use XYSplineRenderer to make lines curved
        XYSplineRenderer renderer = new XYSplineRenderer(); // Create an XYSplineRenderer instance
        renderer.setSeriesShapesVisible(0, true); // Turn off visibility for series markers
        renderer.setSeriesShapesFilled(0, false); // Turn off visibility for series markers
        renderer.setSeriesLinesVisible(0, true); // Turn on visibility of series lines
        renderer.setSeriesPaint(0, Color.RED); // Make series lines color red
        renderer.setSeriesStroke(0, new BasicStroke(1.0f)); // Set line thickness for series line
        renderer.setPrecision(20); // Set line smoothness
        linePlot.setRenderer(renderer); // Plot renderer

        linePlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        // Customize x-axis
        NumberAxis xAxis = (NumberAxis) linePlot.getDomainAxis();
        xAxis.setLabelPaint(Color.white); // Change x-axis label color
        xAxis.setTickLabelPaint(Color.white); // Change x-axis tick label color

        // Customize y-axis
        NumberAxis yAxis = (NumberAxis) linePlot.getRangeAxis();
        yAxis.setLabelPaint(Color.white); // Change y-axis label color
        yAxis.setTickLabelPaint(Color.white); // Change y-axis tick label color

        // Set fixed scales for axes
        xAxis.setAutoRange(false);
        yAxis.setAutoRange(false);
        xAxis.setRange(-5.0, 250.0); // Set x-axis range
        yAxis.setRange(-5.0, 25.0); // Set y-axis range

        // Enable tooltips
        XYItemRenderer xyItemRenderer = linePlot.getRenderer();
        xyItemRenderer.setDefaultToolTipGenerator(new XYToolTipGenerator() {
            @Override
            public String generateToolTip(XYDataset lineDataset, int series, int item) {
                final double xHoveredValue = lineDataset.getXValue(series, item);
                final double yHoveredValue = lineDataset.getYValue(series, item);

                return MessageFormat.format("({0}, {1})", xHoveredValue, yHoveredValue);
            }
        });

        JFreeChart combinedChart = new JFreeChart("Combined Chart", JFreeChart.DEFAULT_TITLE_FONT, plot, true);

        // Create Panel
        ChartPanel chartPanel = new ChartPanel(combinedChart);
        chartPanel.setInitialDelay(1000); // Set initial delay to 1 second (1000 milliseconds)
        chartPanel.setDismissDelay(Integer.MAX_VALUE); // Set dismiss delay to maximum value (effectively infinite)
        chartPanel.setPreferredSize(new Dimension(900, 600));
        add(chartPanel);
    }

    public LineGraph getLineGraph() {
        return new LineGraph();
    }
}
