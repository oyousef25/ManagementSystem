package panes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import pojo.DisplayReservation;
import tables.ReservationsTable;


/**
 * DeletePane Class contains:
 * 1. The Delete Tab UI elements
 * 2. Delete Functionality
 *
 * @author Omar Yousef
 * @version 1.0
 * @since NOV 9th 2020
 */
public class DeletePane extends BorderPane {
    //Making the Reservations TableView
    public static TableView tableView;

    /**
     * DeletePane Constructor:
     *
     * 1. This is a borderPane.
     * 2. it will hold all the Delete tab UI elements.
     * 3. It will give the user to delete a record.
     */
    public DeletePane(){
        //Creating the reservations table
        ReservationsTable reservationsTable = new ReservationsTable();

        //instantiating the tableView
        tableView = new TableView();


        /*
            Name Column
         */
        TableColumn<DisplayReservation, String> column1 = new TableColumn("Name");

        //Setting the column's value
        column1.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getName())
        );

        //Adding the column to table
        tableView.getColumns().add(column1);


        /*
            Date Column
         */
        TableColumn<DisplayReservation, String> column2 = new TableColumn("Date");

        //Setting the column's value
        column2.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getDate())
        );

        //Adding the column to table
        tableView.getColumns().add(column2);


        /*
            Table Number Column
         */
        TableColumn<DisplayReservation, String> column3 = new TableColumn("Table #");

        //Setting the column's value
        column3.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getTableNum())
        );

        //Adding the column to table
        tableView.getColumns().add(column3);


        /*
            Number Of People Column
         */
        TableColumn<DisplayReservation, String> column4 = new TableColumn("# of Guests");

        //Setting the column's value
        column4.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getGuests())
        );

        //Adding the column to table
        tableView.getColumns().add(column4);


        /*
            Phone Number Column
         */
        TableColumn<DisplayReservation, Number> column5 = new TableColumn("Phone");

        //Setting the column's value
        column5.setCellValueFactory(
                e-> new SimpleIntegerProperty(e.getValue().getPhoneNumber())
        );

        //Adding the column to table
        tableView.getColumns().add(column5);


        /*
            Adding all data to the reservationsTable variable declared above
         */
        tableView.getItems().addAll(reservationsTable.getPrettyItems());
        this.setCenter(tableView);


        /*
            Delete Button:
            To allow the user to select a specific record and delete it
         */
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e->{
            //Getting the selected reservation record
            DisplayReservation reservation = (DisplayReservation) tableView.getSelectionModel().getSelectedItem();

            //Deleting record from Database
            reservationsTable.deleteReservation(reservation.getId());

            //Refreshing table
            refreshTable();

            //generating the bar graph again
            StatisticsPane.generateChart();

        });
        //Setting the button at the bottom of the tab
        this.setBottom(deleteButton);
    }

    public static void refreshTable() {
        //Creating a new instance of the Reservations Table
        ReservationsTable table = new ReservationsTable();

        //Clearing all tableView items
        tableView.getItems().clear();

        //Re adding the items
        tableView.getItems().addAll(table.getPrettyItems());
    }
}
