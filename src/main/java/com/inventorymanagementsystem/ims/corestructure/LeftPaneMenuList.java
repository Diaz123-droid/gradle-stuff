package com.inventorymanagementsystem.ims.corestructure;

import java.awt.*;
import javax.swing.*;

public class LeftPaneMenuList extends JFrame {
    public static JPanel currentJPanel = new JPanel();

    public JPanel LeftPaneMenuListView() {
        // Create a panel to hold the left pane menu list
        JPanel leftPanePanel = new JPanel(new BorderLayout());

        // Create a list model with menu items
        DefaultListModel<MenuItem> menuListModel = new DefaultListModel<>();
        menuListModel.addElement(new MenuItem("Inventory", new ImageIcon("table_icon.png")));
        menuListModel.addElement(new MenuItem("Supplier", new ImageIcon("view_icon.png")));
        menuListModel.addElement(new MenuItem("Product", new ImageIcon("index_icon.png")));
        menuListModel.addElement(new MenuItem("Sales", new ImageIcon("constraint_icon.png")));
        menuListModel.addElement(new MenuItem("Purchase", new ImageIcon("constraint_icon.png")));
        menuListModel.addElement(new MenuItem("Planner", new ImageIcon("constraint_icon.png")));
        menuListModel.addElement(new MenuItem("Constraints", new ImageIcon("constraint_icon.png")));
        menuListModel.addElement(new MenuItem("Settings", new ImageIcon("constraint_icon.png")));

        // Create a JList with the custom model
        JList<MenuItem> menuList = new JList<>(menuListModel);
        menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuList.setLayoutOrientation(JList.VERTICAL);
        menuList.setCellRenderer(new MenuItemRenderer());

        // Add a selection listener to handle menu item selection
        menuList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                MenuItem selectedItem = menuList.getSelectedValue();
                if (selectedItem != null) {
                    // Handle menu item selection (e.g., display relevant content)
                    System.out.println("Selected menu item: " + selectedItem.getLabel());
                }
            }
        });

        // Add the JList to a scroll pane
        JScrollPane menuScrollPane = new JScrollPane(menuList);
        menuList.setBackground(new Color(41,41,41 ));
        // Add the scroll pane to the left pane panel
        leftPanePanel.add(menuScrollPane, BorderLayout.CENTER);

        return leftPanePanel;
    }

    // Custom class to represent a menu item with an icon and a label
    private static class MenuItem {
        private String label;
        private Icon icon;

        public MenuItem(String label, Icon icon) {
            this.label = label;
            this.icon = icon;
        }

        public String getLabel() {
            return label;
        }

        public Icon getIcon() {
            return icon;
        }
    }

    public JPanel GetSelectedPane(){
        return currentJPanel;
    } 

    // Custom cell renderer to display menu items with icon and label
    private static class MenuItemRenderer extends JPanel implements ListCellRenderer<MenuItem> {
        private JLabel iconLabel;
        private JLabel textLabel;

        public MenuItemRenderer() {
            setLayout(new BorderLayout());
            setOpaque(true);

            iconLabel = new JLabel();
            iconLabel.setBorder(BorderFactory.createEmptyBorder(15, 5, 5, 5));
            add(iconLabel, BorderLayout.WEST);

            textLabel = new JLabel();
            textLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            add(textLabel, BorderLayout.CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends MenuItem> list, MenuItem value, int index,
                boolean isSelected, boolean cellHasFocus) {
            iconLabel.setIcon(value.getIcon());
            textLabel.setText(value.getLabel());
            
            if (isSelected) {
                textLabel.setFont(new Font("Arial", Font.BOLD, 16));
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
                textLabel.setForeground(Color.BLACK);
                currentJPanel.add(new JLabel("Hello There!"));
            } else {
                textLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                setBackground(list.getBackground());
                setForeground(list.getForeground());
                textLabel.setForeground(new Color(200,200,200));
            }

            return this;
        }
    }
}