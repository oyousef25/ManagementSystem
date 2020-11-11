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

public class UpdatePane extends BorderPane {
    public UpdatePane(){
        //Form VBox
        VBox formVbox = new VBox();

        /*
        The Form Will include:
        1. Form title
        2. Name Of person
        3. The Update Button
     */

        //Form Title
        Text title = new Text("Update Reservation Form");
        title.setFill(Color.BLACK);
        title.setStroke(Color.BLACK);
        title.setStrokeWidth(1);
        title.setFont(Font.font("Comic Sans MS", 15));
        formVbox.getChildren().add(title);

        //Reservation ID and TextField
        Label nameLabel = new Label("Reservation ID:");
        TextField nameText = new TextField();
        nameText.setMaxWidth(150);
        //Add elements to vbox
        formVbox.getChildren().addAll(nameLabel, nameText);

        Button updateReservation = new Button("Update");
        updateReservation.setAlignment(Pos.BOTTOM_RIGHT);
        formVbox.getChildren().add(updateReservation);

        //Fixing the VBox properties
        formVbox.setSpacing(10);
        formVbox.setAlignment(Pos.CENTER_LEFT);
        formVbox.setPadding(new Insets(20, 20, 20, 20));


        //Adding the form to the BorderPane
        this.setTop(formVbox);
    }
}
