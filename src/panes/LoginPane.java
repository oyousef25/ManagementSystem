package panes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Login Pane:
 * It will contain all the Login Page's UI elements
 *
 * @author Omar Yousef & Farzana Moury
 * @version 1.0
 * @since 5th December
 */
public class LoginPane extends BorderPane {
    /**
     * LoginPane() constructor:
     * It will help us make a new instance of the Login Pane in the Login scene.
     */
    public LoginPane() {
        //The software must have an account settings section that allow the user to
        //specify username, password, server location and database

        //Make a VBox to design form
        VBox formBox = new VBox();

        Label usernameLabel = new Label("Username:");
        TextField usernameText = new TextField();
        usernameText.setMaxWidth(150);
        //Add elements to vbox
        formBox.getChildren().addAll(usernameLabel, usernameText);


        Label passwordLabel = new Label("Password:");
        TextField passwordText = new TextField();
        passwordText.setMaxWidth(150);
        //Add elements to vbox
        formBox.getChildren().addAll(passwordLabel, passwordText);


        Label locationLabel = new Label("Server Location:");
        TextField locationText = new TextField();
        locationText.setMaxWidth(150);
        //Add elements to vbox
        formBox.getChildren().addAll(locationLabel, locationText);

        this.setCenter(formBox);
    }
}
