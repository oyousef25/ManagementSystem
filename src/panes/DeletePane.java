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


/**
 * DeletePane Class contains:
 * 1. The Delete Tab form elements
 * 2. Delete Tab Design
 *
 * @author Omar Yousef
 * @version 1.0
 * @since NOV 9th 2020
 */
public class DeletePane extends BorderPane {
    /**
     * DeletePane Constructor
     */
    public DeletePane(){
        //Form VBox
        VBox formVbox = new VBox();

        /*
        The Form Will include:
        1. Form title
        2. Reservation ID
        3. The Delete Button
     */

        //Form Title
        Text title = new Text("Delete Reservation Form");
        title.setFill(Color.BLACK);
        title.setStroke(Color.BLACK);
        title.setStrokeWidth(1);
        title.setFont(Font.font("Comic Sans MS", 15));
        formVbox.getChildren().add(title);

        //Reservation ID and TextField
        Label idLabel = new Label("Reservation ID:");
        TextField idText = new TextField();
        idText.setMaxWidth(150);
        //Add elements to vbox
        formVbox.getChildren().addAll(idLabel, idText);

        Button deleteReservation = new Button("Delete");
        deleteReservation.setAlignment(Pos.BOTTOM_RIGHT);
        formVbox.getChildren().add(deleteReservation);

        //Fixing the VBox properties
        formVbox.setSpacing(10);
        formVbox.setAlignment(Pos.CENTER_LEFT);
        formVbox.setPadding(new Insets(20, 20, 20, 20));


        //Adding the form to the BorderPane
        this.setTop(formVbox);
    }
}
