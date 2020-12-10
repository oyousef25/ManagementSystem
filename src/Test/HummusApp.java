package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scenes.LoginScene;
import Database.Login;
import scenes.MainScene;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Test.Main Class:
 * 1. It includes The the Applications Intro page designing
 * 2. It includes the Application's Primary Stage
 * 3. It includes the Application's Scene
 *
 * @author Omar Yousef
 * @version 1.0
 * @since 9th NOV 2020
 */
public class HummusApp extends Application {
    public static Stage mainStage;
    public static Scene scene;
    /**
     * Test.Main() Method that launches the Application
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Start method will either take you to the login screen if the login txt file is not created, or else
     * it will automatically load the main screen
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        //Setting the mainStage variable as the main stag
        File file = new File("src/Database/login");
        //if the file exists
        mainStage = stage;
        if (file.exists() && file.length() > 0) { //if the file exists and there are credentials inside
        try {
            Scanner scanner;
            scanner = new Scanner(new File("src/Database/login")); //we store it in a txt file called login
            Login.DB_USER = scanner.next();
            Login.DB_PASSWORD = scanner.next();
            Login.DB_NAME = scanner.next();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            Scene scene = new MainScene(); //then we take them to the main program
            mainStage.setScene(scene);
        }
        else{
            Scene scene = new LoginScene(); //otherwise by default we start the main program
            mainStage.setScene(scene);
        }
        stage.setTitle("Hummus Restaurant Reservations Management System");
        stage.show();
    }
}
