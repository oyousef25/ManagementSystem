package Tabs;

import javafx.scene.control.Tab;

public class DeleteReservationTab extends Tab {
    private static DeleteReservationTab instance = null;

    private DeleteReservationTab(){
        this.setText("Delete Reservation");
    }

    public static DeleteReservationTab getInstance(){
        if(instance == null){
            instance = new DeleteReservationTab();
        }
        return instance;
    }
}
