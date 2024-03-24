package com.inventorymanagementsystem.ims.corestructure;

import javax.swing.*;

import com.inventorymanagementsystem.ims.corestructure.centerview.MainContentView;

/**
 * CenterTabs
 */
public class CenterTabs {
    public JTabbedPane centerJTabbedPane = new JTabbedPane();

    public CenterTabs(){
        centerJTabbedPane.addTab("EURUSD", new MainContentView().MainContentViewModel());
        centerJTabbedPane.addTab("EURJPY", new MainContentView().MainContentViewModel());
        centerJTabbedPane.addTab("EURGBP", new MainContentView().MainContentViewModel());
        centerJTabbedPane.addTab("GBPUSR", new MainContentView().MainContentViewModel());
        centerJTabbedPane.addTab("XAUUSD", new MainContentView().MainContentViewModel());
        centerJTabbedPane.addTab("BTCUSR", new MainContentView().MainContentViewModel());
    }

    public JTabbedPane getJTabbedPane(){
        return centerJTabbedPane;
    }
}