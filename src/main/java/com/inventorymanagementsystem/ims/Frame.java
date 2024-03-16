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
import javax.swing.tree.*;
import javax.swing.JTree;
import javax.swing.JScrollPane;

public class Frame extends JFrame implements ActionListener {
    private int defaultWindowWidth = 1280;
    private int defaultWindowHeight = 800;

    Frame() {
        // Create main view
        JPanel mainView = new JPanel();
        mainView.setLayout(new BorderLayout());

        // Create left pane wih a tree
        JTree tree = new JTree(LeftPaneTreeView());
        tree.setEditable(false);
        tree.setScrollsOnExpand(true);
        tree.setEnabled(true);
        tree.setExpandsSelectedPaths(true);
        tree.setAutoscrolls(true);
        tree.setFont(new Font("Dialogs", Font.PLAIN, 12));
        tree.setRootVisible(false);
        JScrollPane treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setPreferredSize(new Dimension(250, getHeight())); // Set fixed width for tree

        // Create center view with a book view (placeholder)
        JPanel centerView = new JPanel();
        centerView.setBackground(Color.WHITE);
        centerView.setLayout(new BorderLayout());
        JLabel bookViewLabel = new JLabel("Book View");
        bookViewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerView.add(bookViewLabel, BorderLayout.CENTER);

        // Create a bottom View
        JPanel bottomView = new JPanel();
        bottomView.setBackground(Color.LIGHT_GRAY);
        bottomView.setPreferredSize(new Dimension(getWidth(), 100)); // Set fixed height for the bottom view
        JLabel bottomLabel = new JLabel("Bottom View");
        bottomView.add(bottomLabel);

        // Add components to the main view panel
        mainView.add(treeScrollPane, BorderLayout.WEST); // Add Tree to the left
        mainView.add(centerView, BorderLayout.CENTER); // Add book view to the center
        mainView.add(bottomView, BorderLayout.SOUTH); // Add bottom view

        // Add main view panel to the frame
        add(mainView, BorderLayout.CENTER); // Add main view to the center of the frame
        add(TabMenu(), BorderLayout.NORTH); // Add tabbedPane to the top of the frame

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

    /**
     * This method returns a selectable tree view to parent frame
     * @return DefaultMutableTreeNode
     */
    public DefaultMutableTreeNode LeftPaneTreeView() {
        final String nodeTitles[] = { "Inventory", "supplier", "Product", "Sales", "Purchase", "Planner", "Settings" };

        // Create root node / root nodes
        final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("[IMS ROOT]");

        for (int index = 0; index < 7; index++) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(String.format("[%s]", nodeTitles[index]));

            for (int i = 0; i < (int) (Math.random() * 10); i++) {
                node.add(new DefaultMutableTreeNode(MessageFormat.format("{0} Leaf Node {1}", nodeTitles[index], i)));
            }

            rootNode.add(node);
        }

        return rootNode; // Return root node to Calling Frame
    }

    /**
     * This mathod returns a bookstyle menu bar to parent frame
     * @return JTabbedPane
     */
    public JTabbedPane TabMenu() {
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

    public JPanel productsPanel(){
        JPanel productsPanelObject = new JPanel();
        // BorderLayout layout = new BorderLayout(0,0);
        
        return productsPanelObject;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
