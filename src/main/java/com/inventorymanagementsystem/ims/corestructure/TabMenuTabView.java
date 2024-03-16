package com.inventorymanagementsystem.ims.corestructure;

import javax.swing.JTabbedPane;

import java.text.MessageFormat;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TabMenuTabView extends JTabbedPane {
    /**
     * This mathod returns a bookstyle menu bar to parent frame
     * @return JTabbedPane
     */
    public JTabbedPane tTabMenu() {
        // Tabbed View menu bar
        JTabbedPane tabMenuBar = new JTabbedPane();
        tabMenuBar.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabMenuBar.setPreferredSize(new Dimension(getWidth(), 100)); // Set Fixed height for the tabbed pane

        String titles[] = {
                "Products", "Inventory", "Sales", "Reports", "Settings", "Help", "Form", "Views"
        };

        JPanel panels[] = {
                new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(),
                new JPanel()
        };

        for (int i = 0, n = titles.length; i < n; i++) {
            panels[i].add(new JLabel(titles[i], SwingConstants.CENTER)); // Set label for each panel
            tabMenuBar.addTab(titles[i], null, panels[i], MessageFormat.format("{0} Tab Description", titles[i]));
        }

        return tabMenuBar;
    }
}
