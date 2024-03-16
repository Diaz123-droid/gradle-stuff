package com.inventorymanagementsystem.ims;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.event.*;
import java.text.MessageFormat;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Frame extends JFrame implements ActionListener {
    private int defaultWindowWidth = 1280;
    private int defaultWindowHeight = 800;

    Frame() {
        // Menu Tab Bar Implementation
        TabMenu();
        this.setLayout(new GridLayout(0, 1));

        // this.add(new TabMenu());
        this.add(new JPanel().add(new JLabel("Component 2", SwingConstants.CENTER)));
        this.add(new JPanel().add(new JLabel("Another Component", SwingConstants.CENTER)));
        this.add(new JPanel().add(new JLabel("Another 3", SwingConstants.CENTER)));
        this.add(new JPanel().add(new JLabel("One Another Tab", SwingConstants.CENTER)));

        this.setTitle("Inventory Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true); // Do not resie this window
        this.setSize(defaultWindowWidth, defaultWindowHeight); // Set frame size
        this.setVisible(true); // display frame
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\imslogocolored.png");
        this.setIconImage(icon.getImage()); // Set image as window icon
        this.getContentPane().setBackground(new Color(5, 24, 33)); // bg color for frame
        System.out.println(this.getX());
    }

    public void TabMenu() {
        // Tabbed View
        JTabbedPane tabMenuBar = new JTabbedPane();
        tabMenuBar.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        String titles[] = {
                "Products", "Inventory", "Sales", "Reports", "Settings", "Help", "Form", "Views"
        };
        @SuppressWarnings("unused")
        int mnemonic[] = {
                KeyEvent.VK_P, KeyEvent.VK_I, KeyEvent.VK_S, KeyEvent.VK_R, KeyEvent.VK_T, KeyEvent.VK_H,
                KeyEvent.VK_F, KeyEvent.VK_V
        };
        JPanel panels[] = {
                new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(),
                new JPanel()
        };

        for (int i = 0, n = titles.length; i < n; i++) {
            panels[i].add(new JLabel(titles[i], SwingConstants.CENTER)); // Set label for each panel
            tabMenuBar.addTab(titles[i], null, panels[i], MessageFormat.format("{0} Tab Description", titles[i]));
        }

        tabMenuBar.setSize(1000, 100);
        tabMenuBar.setVisible(true);
        add(tabMenuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
