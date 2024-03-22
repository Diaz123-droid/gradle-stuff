package com.inventorymanagementsystem.ims;

import com.inventorymanagementsystem.ims.corestructure.LeftPaneMenuList;
import com.inventorymanagementsystem.ims.corestructure.centerview.TabMenuTabView;
import com.inventorymanagementsystem.ims.corestructure.centerview.TabbedMainPane;
import com.inventorymanagementsystem.ims.corestructure.rightview.RightViewTabManager;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class Frame extends JFrame implements ActionListener {
    Frame() {
        // Create main view
        JPanel mainView = new JPanel();
        mainView.setLayout(new BorderLayout());

        // Create left pane with for core models
        JScrollPane treeScrollPane = new JScrollPane(new LeftPaneMenuList().LeftPaneMenuListView());
        treeScrollPane.setPreferredSize(new Dimension(300, getHeight())); // Set fixed width for tree

        // Add components to the main view panel
        mainView.add(treeScrollPane, BorderLayout.WEST);            // Add Tree to the left
        mainView.add(new TabbedMainPane().getTabbedMainPane(), BorderLayout.CENTER);       // Add book view to the center
        mainView.add(new RightViewTabManager().getRightViewTabManager(), BorderLayout.EAST);                // Add bottom view
        
        add(mainView, BorderLayout.CENTER);                         // Add main view to the frame
        add(new TabMenuTabView().tTabMenu(), BorderLayout.NORTH);   // Add tabbedPane to the top of the frame
        
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
