package com.inventorymanagementsystem.ims.corestructure.centerview;

import javax.swing.*;

import com.inventorymanagementsystem.ims.charts.LineGraph;

import java.awt.*;

public class MainContentView extends JPanel {
    // Create center view with a book view (placeholder)
    public JPanel MainContentViewModel(){
        JPanel centerView = new JPanel();
        centerView.setBackground(Color.WHITE);
        centerView.setLayout(new BorderLayout());
        centerView.add(new LineGraph().getLineGraph());

        return centerView;
    }
}
