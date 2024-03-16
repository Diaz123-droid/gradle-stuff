package com.inventorymanagementsystem.ims;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("unused")
public class TabMenu extends JTabbedPane {
    public void tTabMenu(){
        // Tabbed View
        JTabbedPane tabMenuBar = new JTabbedPane();
        tabMenuBar.setName("Menu Bar Book View");
        
        // Set panel1 and add it to JTabbedPane
        JLabel label1 = new JLabel("Products", SwingConstants.CENTER);
        JPanel panel1 = new JPanel();   // Create first panel
        panel1.add(label1);             // Add Label to panel
        tabMenuBar.addTab("Products", null, panel1, "View Products Tab Controls");

        // Set panel1 and add it to JTabbedPane
        JLabel label2 = new JLabel("Inventory", SwingConstants.CENTER);
        JPanel panel2 = new JPanel();   // Create first panel
        panel2.add(label2);             // Add Label to panel
        tabMenuBar.addTab("Inventory", null, panel2, "View Inventory Tab Controls");

        // Set panel1 and add it to JTabbedPane
        JLabel label3 = new JLabel("Sales", SwingConstants.CENTER);
        JPanel panel3 = new JPanel();   // Create first panel
        panel3.add(label3);             // Add Label to panel
        tabMenuBar.addTab("Sales", null, panel3, "View Sales Tab Controls");

        // Set panel1 and add it to JTabbedPane
        JLabel label4 = new JLabel("Reports", SwingConstants.CENTER);
        JPanel panel4 = new JPanel();   // Create first panel
        panel4.add(label4);             // Add Label to panel
        tabMenuBar.addTab("Reports", null, panel4, "View Reports Tab Controls");

        // Set panel1 and add it to JTabbedPane
        JLabel label5 = new JLabel("Settings", SwingConstants.CENTER);
        JPanel panel5 = new JPanel();   // Create first panel
        panel5.add(label5);             // Add Label to panel
        tabMenuBar.addTab("Settings", null, panel5, "View Settings Tab Controls");
        // Set panel1 and add it to JTabbedPane

        JLabel label6 = new JLabel("Help", SwingConstants.CENTER);
        JPanel panel6 = new JPanel();   // Create first panel
        panel6.add(label6);             // Add Label to panel
        tabMenuBar.addTab("Help", null, panel6, "View Help Tab Controls");
        
        // Set panel1 and add it to JTabbedPane
        JLabel label7 = new JLabel("Forms", SwingConstants.CENTER);
        JPanel panel7 = new JPanel();   // Create first panel
        panel7.add(label7);             // Add Label to panel
        tabMenuBar.addTab("Forms", null, panel7, "View Forms Tab Controls");

        // Set panel1 and add it to JTabbedPane
        JLabel label8 = new JLabel("View", SwingConstants.CENTER);
        JPanel panel8 = new JPanel();   // Create first panel
        panel8.add(label8);             // Add Label to panel
        tabMenuBar.addTab("View", null, panel8, "View View Tab Controls");
        // Set panel1 and add it to JTabbedPane

        JLabel label9 = new JLabel("Help", SwingConstants.CENTER);
        JPanel panel9 = new JPanel();   // Create first panel
        panel9.add(label9);             // Add Label to panel
        tabMenuBar.addTab("Help", null, panel9, "View Help Tab Controls");

        tabMenuBar.setSize(1000, 100);
        tabMenuBar.setVisible(true);
        add(tabMenuBar);
    }
}
