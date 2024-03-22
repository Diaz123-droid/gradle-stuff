package com.inventorymanagementsystem.ims.corestructure.rightview;

import javax.swing.*;
import java.awt.*;

public class RightViewTabManager extends JPanel {
    JTabbedPane rightViewTabView = new JTabbedPane();

    public RightViewTabManager(){
        rightViewTabView.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        rightViewTabView.setPreferredSize(new Dimension(300, getHeight()));

        // Temporary labels for each tab
        JLabel rightPanelLabel0 = new JLabel("Patterns Tab Label");
        JLabel rightPanelLabel1 = new JLabel("Notications Tab Label");
        JLabel rightPanelLabel2 = new JLabel("Settings Tab Label");

        rightPanelLabel0.setForeground(Color.WHITE);
        rightPanelLabel1.setForeground(Color.WHITE);
        rightPanelLabel2.setForeground(Color.WHITE);

        JPanel rightViewLabel0 = new JPanel();
        JPanel rightViewLabel1 = new JPanel();
        JPanel rightViewLabel2 = new JPanel();

        rightViewLabel0.setBackground(new Color(41,41,41));
        rightViewLabel1.setBackground(new Color(41,41,41));
        rightViewLabel2.setBackground(new Color(41,41,41));

        rightViewLabel0.add(rightPanelLabel0);
        rightViewLabel1.add(rightPanelLabel1);
        rightViewLabel2.add(rightPanelLabel2);

        rightViewTabView.addTab("Patterns", rightViewLabel0);
        rightViewTabView.addTab("Notications", rightViewLabel1);
        rightViewTabView.addTab("Settings", rightViewLabel2);
    }

    public JTabbedPane getRightViewTabManager(){
        return rightViewTabView;
    }
}
