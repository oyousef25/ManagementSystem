package Tabs;

import javafx.scene.control.Tab;

/**
 * DeleteReservationTab class - represents Delete Reservation Tab
 * uses Singleton design pattern by
 *   - creating a private static constructor
 *   - creating a private static instance variable and
 *   - creating a public static getInstance() method

 * @author Farzana Moury
 * @version 1.0
 * @since Nov 9th 2020
 */
public class DeleteReservationTab extends Tab {
    //properties
    private static DeleteReservationTab instance = null;

    /**
     * This is the private constructor which sets the tab name to "Delete Reservation"
     */
    private DeleteReservationTab(){
        this.setText("Delete Reservation");
    }

    /**
     * The purpose of this method is to get the instance of the class that will always be used
     * Instance can only be created ONCE and used throughout the program - no new instances can be created
     * @return instance of the class DeleteReservationTab
     */
    public static DeleteReservationTab getInstance(){
        if(instance == null){
            instance = new DeleteReservationTab();
        }
        return instance;
    }
}
