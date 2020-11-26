package Tabs;

import javafx.scene.control.Tab;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * AddReservationTab class - represents Add Reservation Tab
 * uses Singleton design pattern by
 *   - creating a private static constructor
 *   - creating a private static instance variable and
 *   - creating a public static getInstance() method

 * @author Farzana Moury
 * @version 1.0
 * @since Nov 9th 2020
 */

public class AddReservationTab extends Tab {
    //properties
    private static AddReservationTab instance = null;

    /**
     * This is the private constructor which sets the tab name to "Add Reservation"
     */
    private AddReservationTab(){
        this.setText("Add Reservation");
    }

    /**
     * The purpose of this method is to get the instance of the class that will always be used
     * Instance can only be created ONCE and used throughout the program - no new instances can be created
     * @return instance of the class AddReservationTab
     */
    public static AddReservationTab getInstance(){
        if(instance == null){
            instance = new AddReservationTab();
        }
        return instance;
    }

}
