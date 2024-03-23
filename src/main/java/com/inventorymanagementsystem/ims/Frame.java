package com.inventorymanagementsystem.ims;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.*;

import com.inventorymanagementsystem.ims.corestructure.LeftPaneMenuList;
import com.inventorymanagementsystem.ims.corestructure.centerview.CenterViewTabManager;
import com.inventorymanagementsystem.ims.corestructure.leftview.LeftViewTabManager;
import com.inventorymanagementsystem.ims.corestructure.rightview.RightViewTabManager;

public class Frame extends JFrame implements ActionListener {
    Frame() {
        // Create main view
        JSplitPane mainView = new JSplitPane();
        JSplitPane mainRightPane = new JSplitPane();
        // mainView.setLayout(new BorderLayout());
        mainView.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

        // Create left pane with for core models
        JScrollPane treeScrollPane = new JScrollPane(new LeftPaneMenuList().LeftPaneMenuListView());
        treeScrollPane.setPreferredSize(new Dimension(300, getHeight())); // Set fixed width for tree

        // Add components to the main view panel
        mainRightPane.setLeftComponent(new CenterViewTabManager().getTabbedMainPane());
        mainRightPane.setRightComponent(new RightViewTabManager().getRightViewTabManager());

        mainView.setLeftComponent(treeScrollPane );            // Add Tree to the left
        mainView.setRightComponent(mainRightPane);              // Add split pane to the right
        
        add(mainView, BorderLayout.CENTER);                         // Add main view to the frame
        add(new LeftViewTabManager().tTabMenu(), BorderLayout.NORTH);   // Add tabbedPane to the top of the frame
        
        setVisible(true);

        // Main Frame Settings
        this.setTitle("Inventory Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true); // Do resize this window
        this.setSize(getMaximumSize()); // Set frame size
        this.setVisible(true); // display frame
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\imslogocolored.png");
        this.setIconImage(icon.getImage()); // Set image as window icon
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
