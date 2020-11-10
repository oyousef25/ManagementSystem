package Tabs;

import javafx.scene.control.Tab;

/**
 * StatsTab class - represents Statistics Tab
 * uses Singleton design pattern by
 *   - creating a private static constructor
 *   - creating a private static instance variable and
 *   - creating a public static getInstance() method

 * @author Farzana Moury
 * @version 1.0
 * @since Nov 9th 2020
 */
public class StatsTab extends Tab {
    //properties
    private static StatsTab instance = null;

    /**
     * This is the private constructor which sets the tab name to "Statistics"
     */
    private StatsTab(){
        this.setText("Statistics");
    }

    /**
     * The purpose of this method is to get the instance of the class that will always be used
     * Instance can only be created ONCE and used throughout the program - no new instances can be created
     * @return instance of the class StatisticsTab
     */
    public static StatsTab getInstance(){
        if(instance == null){
            instance = new StatsTab();
        }
        return instance;
    }
}
