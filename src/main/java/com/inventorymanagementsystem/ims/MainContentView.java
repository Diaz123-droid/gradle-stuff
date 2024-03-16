package com.inventorymanagementsystem.ims;

import javax.swing.*;
import java.awt.*;

public class MainContentView extends JPanel {
    // Create center view with a book view (placeholder)
    public JPanel MainContentViewModel(){
        JPanel centerView = new JPanel();
        centerView.setBackground(Color.WHITE);
        centerView.setLayout(new BorderLayout());
        JLabel bookViewLabel = new JLabel("Book View");
        bookViewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerView.add(bookViewLabel, BorderLayout.CENTER);

        return centerView;
    }
}
