package panes;

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
        formVbox.getChildren().add(title);

        Label nameLabel = new Label("Name Of Person");
        TextField nameText = new TextField();
        nameText.setMaxWidth(100);
        formVbox.getChildren().addAll(nameLabel, nameText);

        Label dateLabel = new Label("Date:");
        TextField dateText = new TextField();
        dateText.setMaxWidth(100);
        formVbox.getChildren().addAll(dateLabel, dateText);

        Label tableLabel = new Label("Table #:");
        TextField tableText = new TextField();
        tableText.setMaxWidth(100);
        formVbox.getChildren().addAll(tableLabel, tableText);

        Label numOfPeopleLabel = new Label("Number Of People");
        TextField numOfPeopleText = new TextField();
        numOfPeopleText.setMaxWidth(100);
        formVbox.getChildren().addAll(numOfPeopleLabel, numOfPeopleText);

        Label phoneNumLabel = new Label("Phone Number:");
        TextField phoneNumText = new TextField();
        phoneNumText.setMaxWidth(100);
        formVbox.getChildren().addAll(phoneNumLabel, phoneNumText);

        Button addReservation = new Button("Add");
        formVbox.getChildren().add(addReservation);

        //Aligning the VBox
        formVbox.setAlignment(Pos.CENTER_LEFT);


        //Adding the form to the BorderPane
        this.setCenter(formVbox);
    }
}
