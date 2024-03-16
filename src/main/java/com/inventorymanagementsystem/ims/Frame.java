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
        JTree tree                      = new JTree(LeftPaneTreeView()); 
        JScrollPane treeScrollPane      = new JScrollPane(tree);
        tree.setBackground(new Color(39, 52, 68));
        treeScrollPane.setPreferredSize(new Dimension(200, getHeight())); // Set fixed width for tree

        // Create center view with a book view (placeholder)
        JPanel centerView               = new JPanel();
        centerView.setBackground(Color.WHITE);
        centerView.setLayout(new BorderLayout());
        JLabel bookViewLabel            = new JLabel("Book View");
        bookViewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerView.add(bookViewLabel, BorderLayout.CENTER);

        // Create a bottom View
        JPanel bottomView               = new JPanel();
        bottomView.setBackground(Color.LIGHT_GRAY);
        bottomView.setPreferredSize(new Dimension(getWidth(), 100)); // Set fixed height for the bottom view
        JLabel bottomLabel              = new JLabel("Bottom View");
        bottomView.add(bottomLabel);

        // Add components to the main view panel
        mainView.add(treeScrollPane, BorderLayout.WEST);    // Add Tree to the left
        mainView.add(centerView, BorderLayout.CENTER);      // Add book view to the center
        mainView.add(bottomView, BorderLayout.SOUTH);       // Add bottom view

        // Add main view panel to the frame
        add(mainView, BorderLayout.CENTER);                 // Add main view to the center of the frame
        add(TabMenu(), BorderLayout.NORTH);                 // Add tabbedPane to the top of the frame
        
        setVisible(true);

        // Main Frame Settings 
        this.setTitle("Inventory Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true); // Do not resie this window
        this.setSize(defaultWindowWidth, defaultWindowHeight); // Set frame size
        this.setVisible(true); // display frame
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\imslogocolored.png");
        this.setIconImage(icon.getImage()); // Set image as window icon
        this.getContentPane().setBackground(new Color(5, 24, 33)); // bg color for frame
        this.setLocationRelativeTo(null);
        System.out.println(this.getX());
    }

    public DefaultMutableTreeNode LeftPaneTreeView(){
        // Create root node / root nodes
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();

        // Create Tree Nodes
        DefaultMutableTreeNode node1    = new DefaultMutableTreeNode();
        DefaultMutableTreeNode node2    = new DefaultMutableTreeNode();
        DefaultMutableTreeNode node3    = new DefaultMutableTreeNode();
        DefaultMutableTreeNode node4    = new DefaultMutableTreeNode();
        DefaultMutableTreeNode node5    = new DefaultMutableTreeNode();
        DefaultMutableTreeNode node6    = new DefaultMutableTreeNode();
        DefaultMutableTreeNode node7    = new DefaultMutableTreeNode();
        DefaultMutableTreeNode node8    = new DefaultMutableTreeNode();

        // Add nodes to the root
        rootNode.add(node1);
        rootNode.add(node2);
        rootNode.add(node3);
        rootNode.add(node4);
        rootNode.add(node5);
        rootNode.add(node6);
        rootNode.add(node7);
        rootNode.add(node8);

        return rootNode; // Return root node to Calling Frame
    }

    public JTabbedPane TabMenu() {
        // Tabbed View menu bar
        JTabbedPane tabMenuBar = new JTabbedPane();
        tabMenuBar.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabMenuBar.setPreferredSize(new Dimension(getWidth(), 100)); // Set Fixed height for the tabbed pane

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
            panels[i].setBackground(new Color(39, 52, 68));
            panels[i].add(new JLabel(titles[i], SwingConstants.CENTER)); // Set label for each panel
            tabMenuBar.addTab(titles[i], null, panels[i], MessageFormat.format("{0} Tab Description", titles[i]));
        }

        return tabMenuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
