package Test;

import Database.Database;
import Tabs.AddReservationTab;
import Tabs.DeleteReservationTab;
import Tabs.StatsTab;
import Tabs.UpdateReservationTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import panes.AddPane;
import panes.DeletePane;
import panes.StatisticsPane;
import panes.UpdatePane;
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
 * @since 9th NOV
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
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        //Setting the mainStage variable as the main stag
        File file = new File("src/Database/login");
        //if the file exists
        mainStage = stage;
        if (file.exists() && file.length() > 0) {
        try {
            Scanner scanner;
            scanner = new Scanner(new File("src/Database/login"));
            Login.DB_USER = scanner.next();
            Login.DB_PASSWORD = scanner.next();
            Login.DB_NAME = scanner.next();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            Scene scene = new MainScene();
            mainStage.setScene(scene);
        }
        else{
            Scene scene = new LoginScene();
            mainStage.setScene(scene);
        }
        stage.setTitle("Hummus Restaurant Reservations Management System");
        stage.show();
    }
}
