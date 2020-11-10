package Tabs;

import javafx.scene.control.Tab;

public class AddReservationTab extends Tab {
    private static AddReservationTab instance = null;

    private AddReservationTab(){
        this.setText("Add Reservation");
    }

    public static AddReservationTab getInstance(){
        if(instance == null){
            instance = new AddReservationTab();
        }
        return instance;
    }

}
