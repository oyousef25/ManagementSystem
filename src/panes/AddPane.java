package panes;

import Tabs.DeleteReservationTab;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pojo.Guests;
import pojo.Reservations;
import pojo.TableNumber;
import tables.GuestsTable;
import tables.ReservationsTable;
import tables.TableNumTable;

import static panes.DeletePane.refreshTable;

/**
 * AddPane Class contains:
 * 1. The AddTab form elements
 * 2. Add Tab Design
 *
 * @author Omar Yousef
 * @version 1.0
 * @since NOV 9th 2020
 */
public class AddPane extends BorderPane {

    /**
     * AddPane() Constructor:
     * It holds all the form elements
     */
    public AddPane(){
        //Making a new Reservations Table instance
        ReservationsTable reservationsTable = new ReservationsTable();

        //Making a new Number Of Guests Table instance
        GuestsTable guestsTable = new GuestsTable();

        //Making a new Table Number Table instance
        TableNumTable tableNumTable = new TableNumTable();


        //Form VBox
        VBox formVbox = new VBox();

        /*
        The Form Will include:
        1. Form title
        2. Name of person
        3. Date
        4. Table #
        5. Number of people
        6. Phone number
        7. The Add button
     */
        Text title = new Text("Add Reservation Form");
        title.setFill(Color.BLACK);
        title.setStroke(Color.BLACK);
        title.setStrokeWidth(1);
        title.setFont(Font.font("Comic Sans MS", 15));
        //Add title to vbox
        formVbox.getChildren().add(title);

        /*
            NAME
         */
        Label nameLabel = new Label("Name Of Person");
        TextField nameText = new TextField();
        nameText.setMaxWidth(150);
        //Add elements to vbox
        formVbox.getChildren().addAll(nameLabel, nameText);

        /*
            Date
         */
        Label dateLabel = new Label("Date:");
        TextField dateText = new TextField();
        dateText.setMaxWidth(150);
        //Add elements to vbox
        formVbox.getChildren().addAll(dateLabel, dateText);

        /*
            Table Number
         */
        Label tableLabel = new Label("Table #:");

        //Making a new ComboBox
        ComboBox<TableNumber> tableNumberComboBox = new ComboBox<>();
        //Setting the Combo Box's values to the data inside of our table # table(A list of records)
        tableNumberComboBox.setItems(FXCollections.observableArrayList(tableNumTable.getAllTableNumbers()));

        //Add elements to vbox
        formVbox.getChildren().addAll(tableLabel, tableNumberComboBox);

        /*
            Number Of Guests:
         */
        Label numOfPeopleLabel = new Label("Number Of People");
        //Making a new ComboBox
        ComboBox<Guests> guestsTableComboBox = new ComboBox<>();
        //Setting the Combo Box's values to the data inside of our table # table(A list of records)
        guestsTableComboBox.setItems(FXCollections.observableArrayList(guestsTable.getAllGuests()));

        //Add elements to vbox
        formVbox.getChildren().addAll(numOfPeopleLabel, guestsTableComboBox);

        /*
            Phone Number
         */
        Label phoneNumLabel = new Label("Phone Number:");
        TextField phoneNumText = new TextField();
        phoneNumText.setMaxWidth(150);
        //Add elements to vbox
        formVbox.getChildren().addAll(phoneNumLabel, phoneNumText);

        /*
            Add Button:
            Inserts a new record into the database by retrieving the data entered in the form
         */
        Button addReservation = new Button("Add");
        addReservation.setAlignment(Pos.CENTER_RIGHT);

        //Inserting a new record when clicking on the ad reservation button
        addReservation.setOnAction(e->{
            //Making a new Reservation object
            Reservations reservation = new Reservations(
                    nameText.getText(),
                    Integer.parseInt(dateText.getText()),
                    tableNumberComboBox.getSelectionModel().getSelectedItem().getId(),
                    guestsTableComboBox.getSelectionModel().getSelectedItem().getId(),
                    Integer.parseInt(phoneNumText.getText()));

            //Creating a new Reservation record using the object we created above
            reservationsTable.createReservation(reservation);

            //Refresh table
            refreshTable();

            //TODO: Add the statistics tab code below
        });

        //Add Button to vbox
        formVbox.getChildren().add(addReservation);

        //Fixing the VBox properties
        formVbox.setSpacing(1);
        formVbox.setPadding(new Insets(20, 20, 20, 20));
        formVbox.setAlignment(Pos.CENTER_LEFT);


        //Adding the form to the BorderPane
        this.setCenter(formVbox);
    }
}
