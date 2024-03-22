package com.inventorymanagementsystem.ims.corestructure.centerview;

import javax.swing.*;

public class TabbedMainPane {
    private JTabbedPane centerJTabbedPane = new JTabbedPane();

    public TabbedMainPane(){
        centerJTabbedPane.addTab("EURUSD", new MainContentView().MainContentViewModel());
        centerJTabbedPane.addTab("EURJPY", new MainContentView().MainContentViewModel());
        centerJTabbedPane.addTab("EURGBP", new MainContentView().MainContentViewModel());
        centerJTabbedPane.addTab("GBPUSR", new MainContentView().MainContentViewModel());
        centerJTabbedPane.addTab("XAUUSD", new MainContentView().MainContentViewModel());
        centerJTabbedPane.addTab("BTCUSR", new MainContentView().MainContentViewModel());
    }

    public JTabbedPane getTabbedMainPane(){
        return centerJTabbedPane;
    }
}
