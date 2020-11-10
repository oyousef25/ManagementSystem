package Tabs;

import javafx.scene.control.Tab;

/**
 * UpdateReservationTab class - represents Update Reservation Tab
 * uses Singleton design pattern by
 *   - creating a private static constructor
 *   - creating a private static instance variable and
 *   - creating a public static getInstance() method

 * @author Farzana Moury
 * @version 1.0
 * @since Nov 9th 2020
 */
public class UpdateReservationTab extends Tab {
    //properties
    private static UpdateReservationTab instance = null;

    /**
     * This is the private constructor which sets the tab name to "Update Reservation"
     */
    private UpdateReservationTab(){
        this.setText("Update Reservation");
    }

    /**
     * The purpose of this method is to get the instance of the class that will always be used
     * Instance can only be created ONCE and used throughout the program - no new instances can be created
     * @return instance of the class UpdateReservationTab
     */
    public static UpdateReservationTab getInstance(){
        if(instance == null){
            instance = new UpdateReservationTab();
        }
        return instance;
    }
}
