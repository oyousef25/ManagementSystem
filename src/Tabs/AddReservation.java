package Tabs;

import javafx.scene.control.Tab;

public class AddReservation extends Tab {
    private static AddReservation instance = null;

    private AddReservation(){
        this.setText("Add Reservation");
    }

    public static AddReservation getInstance(){
        if(instance == null){
            instance = new AddReservation();
        }
        return instance;
    }

}
