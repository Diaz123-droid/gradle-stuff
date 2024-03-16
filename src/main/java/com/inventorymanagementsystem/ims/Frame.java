package com.inventorymanagementsystem.ims;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class Frame extends JFrame implements ActionListener {
    private int defaultWindowWidth = 1280;
    private int defaultWindowHeight = 800;

    Frame() {
        // Create main view
        JPanel mainView = new JPanel();
        mainView.setLayout(new BorderLayout());

        // Create left pane with for core models
        JScrollPane treeScrollPane = new JScrollPane(new LeftPaneMenuList().LeftPaneMenuListView());
        treeScrollPane.setPreferredSize(new Dimension(250, getHeight())); // Set fixed width for tree

        // Create a bottom View
        JPanel bottomView = new JPanel();
        bottomView.setBackground(Color.LIGHT_GRAY);
        bottomView.setPreferredSize(new Dimension(getWidth(), 100)); // Set fixed height for the bottom view
        JLabel bottomLabel = new JLabel("Bottom View");
        bottomView.add(bottomLabel);

        // Add components to the main view panel
        mainView.add(treeScrollPane, BorderLayout.WEST);                                 // Add Tree to the left
        mainView.add(new MainContentView().MainContentViewModel(), BorderLayout.CENTER); // Add book view to the center
        mainView.add(bottomView, BorderLayout.SOUTH);                                    // Add bottom view

        add(mainView, BorderLayout.CENTER); // Add main view to the center of the frame
        add(new TopTabMenu().tTabMenu(), BorderLayout.NORTH); // Add tabbedPane to the top of the frame

        setVisible(true);

        // Main Frame Settings
        this.setTitle("Inventory Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true); // Do not resie this window
        this.setSize(defaultWindowWidth, defaultWindowHeight); // Set frame size
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
