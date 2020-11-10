package Tabs;

import javafx.scene.control.Tab;

public class UpdateReservationTab extends Tab {
    private static UpdateReservationTab instance = null;

    private UpdateReservationTab(){
        this.setText("Update Reservation");
    }

    public static UpdateReservationTab getInstance(){
        if(instance == null){
            instance = new UpdateReservationTab();
        }
        return instance;
    }
}
