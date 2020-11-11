package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AddPane extends BorderPane {
    public AddPane(){
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

        Label nameLabel = new Label("Name Of Person");
        TextField nameText = new TextField();
        nameText.setPadding(new Insets(0, 0, 10, 0));
        nameText.setMaxWidth(150);
        //Add elements to vbox
        formVbox.getChildren().addAll(nameLabel, nameText);

        Label dateLabel = new Label("Date:");
        TextField dateText = new TextField();
        dateText.setPadding(new Insets(0, 0, 10, 0));
        dateText.setMaxWidth(150);
        //Add elements to vbox
        formVbox.getChildren().addAll(dateLabel, dateText);

        Label tableLabel = new Label("Table #:");
        TextField tableText = new TextField();
        tableText.setPadding(new Insets(0, 0, 10, 0));
        tableText.setMaxWidth(150);
        //Add elements to vbox
        formVbox.getChildren().addAll(tableLabel, tableText);

        Label numOfPeopleLabel = new Label("Number Of People");
        TextField numOfPeopleText = new TextField();
        numOfPeopleText.setPadding(new Insets(0, 0, 10, 0));
        numOfPeopleText.setMaxWidth(150);
        //Add elements to vbox
        formVbox.getChildren().addAll(numOfPeopleLabel, numOfPeopleText);

        Label phoneNumLabel = new Label("Phone Number:");
        TextField phoneNumText = new TextField();
        phoneNumText.setPadding(new Insets(0, 0, 10, 0));
        phoneNumText.setMaxWidth(150);
        //Add elements to vbox
        formVbox.getChildren().addAll(phoneNumLabel, phoneNumText);

        Button addReservation = new Button("Add");
        addReservation.setAlignment(Pos.CENTER_RIGHT);
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
