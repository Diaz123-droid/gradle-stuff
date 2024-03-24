package com.inventorymanagementsystem.ims;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import com.inventorymanagementsystem.ims.corestructure.centerview.CenterViewTabManager;
import com.inventorymanagementsystem.ims.corestructure.leftview.LeftPaneMenuList;
import com.inventorymanagementsystem.ims.corestructure.leftview.LeftViewTabManager;
import com.inventorymanagementsystem.ims.corestructure.leftview.TreeView;
import com.inventorymanagementsystem.ims.corestructure.rightview.RightViewTabManager;

public class Frame extends JFrame {
    private static final String ICON_IMSLOGOCOLORED_PNG = "src\\main\\resources\\icons\\imslogocolored.png";
    private static final ImageIcon icon = new ImageIcon(ICON_IMSLOGOCOLORED_PNG);
    private String frameTitle = "Inventory Management System";
    private int exitOnClose = JFrame.EXIT_ON_CLOSE;

    /**
     * This frame is the entry frame for the program.
     */
    Frame() {
        try {
            entryFrame();

            this.setTitle(frameTitle); // Frame title
            this.setDefaultCloseOperation(exitOnClose);// Frame close action
            this.setResizable(true); // Do resize this window
            this.setSize(getMaximumSize()); // Set frame size
            this.setVisible(true); // display frame
            this.setIconImage(icon.getImage()); // Set image as window icon
            this.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Frame entryFrame() {
        final JTabbedPane topCustomToolBar = new LeftViewTabManager().tTabMenu();
        final JTabbedPane rightTabbedView = new RightViewTabManager().getRightViewTabManager();
        final JTabbedPane leftTabbedView = getLeftViewJTabbedPane();
        final JTabbedPane middleTopTabbedView = new CenterViewTabManager().getTabbedMainPane();
        final var HORIZONTAL_SPLIT = JSplitPane.HORIZONTAL_SPLIT;

        final JSplitPane middleSplitViews = new JSplitPane(JSplitPane.VERTICAL_SPLIT, middleTopTabbedView, getMiddleBottomTabbedView());
        middleSplitViews.setResizeWeight(1);
        final JSplitPane middleAndRightSplitViews = new JSplitPane(HORIZONTAL_SPLIT, middleSplitViews, rightTabbedView);
        middleAndRightSplitViews.setResizeWeight(1);
        final JSplitPane allContentSplitViews = new JSplitPane(HORIZONTAL_SPLIT, leftTabbedView,
                middleAndRightSplitViews);
        add(allContentSplitViews, BorderLayout.CENTER); // Add main view to the frame
        add(topCustomToolBar, BorderLayout.NORTH); // Add tabbedPane to the top of the frame
        setVisible(true);

        return this;
    }

    private JTabbedPane getLeftViewJTabbedPane() {
        JTabbedPane leftTabbedView = new JTabbedPane();
        leftTabbedView.setPreferredSize(new Dimension(300, getHeight()));
        leftTabbedView.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        JScrollPane sp_leftPaneListView = new JScrollPane(new LeftPaneMenuList().LeftPaneMenuListView());
        JScrollPane sp_leftPaneListView2 = new JScrollPane(new LeftPaneMenuList().LeftPaneMenuListView());
        JScrollPane sp_treeViewMenu = new JScrollPane(new TreeView().getTreeViewMenu());

        leftTabbedView.addTab("watchlist", sp_leftPaneListView);
        leftTabbedView.addTab("all symbols", sp_leftPaneListView2);
        leftTabbedView.addTab("file structure", sp_treeViewMenu);

        return leftTabbedView;
    }

    private JTabbedPane getMiddleBottomTabbedView() {
        JTabbedPane bottomJTabbedPane = new JTabbedPane();
        bottomJTabbedPane.setPreferredSize(new Dimension(900, 150));

        bottomJTabbedPane.addTab("current trades", new JPanel());
        bottomJTabbedPane.addTab("pending trades", new JPanel());
        bottomJTabbedPane.addTab("complete trades", new JPanel());

        return bottomJTabbedPane;
    }
}
