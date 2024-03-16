package com.inventorymanagementsystem.ims;

import java.text.MessageFormat;
import java.awt.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeView {
    /**
     * This method returns a selectable tree view to parent frame
     * @return DefaultMutableTreeNode
     */
    public JTree TreeViewMenu() {
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

        JTree tree = new JTree(rootNode);
        tree.setEditable(false);
        tree.setScrollsOnExpand(true);
        tree.setEnabled(true);
        tree.setExpandsSelectedPaths(true);
        tree.setAutoscrolls(true);
        tree.setFont(new Font("Dialogs", Font.PLAIN, 12));
        tree.setRootVisible(false);

        return tree; // Return root node to Calling Frame
    }
}
