package panes;

import Database.DBConst;
import Database.Login;
import Test.HummusApp;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import scenes.MainScene;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

        Text title = new Text("Login Please!");
        title.setFill(Color.BLACK);
        title.setStroke(Color.BLACK);
        title.setStrokeWidth(1);
        title.setFont(Font.font("Comic Sans MS", 30));
        //Add title to vbox
        formBox.getChildren().add(title);

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


        Label databaseLabel = new Label("Database:");
        TextField databaseText = new TextField();
        databaseText.setMaxWidth(150);
        //Add elements to vbox
        formBox.getChildren().addAll(databaseLabel, databaseText);

        //Login Button
        Button login = new Button("Login!");

        //Programming the login button
        login.setOnAction(e->{
            try {
                PrintWriter out =
                        new PrintWriter(new File("src/Database/login"));

                out.print(usernameText.getText() + " ");
                out.print(passwordText.getText() + " ");
                out.print(databaseText.getText() + " ");

                out.close();
                Login.DB_NAME = databaseText.getText();
                Login.DB_PASSWORD = passwordText.getText();
                Login.DB_USER = usernameText.getText();
                HummusApp.mainStage.setScene(new MainScene());

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        formBox.getChildren().addAll(login);

        formBox.setSpacing(10);
        formBox.setAlignment(Pos.CENTER);
        this.setCenter(formBox);
    }
}
