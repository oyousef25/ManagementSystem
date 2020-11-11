import Tabs.AddReservationTab;
import Tabs.DeleteReservationTab;
import Tabs.StatsTab;
import Tabs.UpdateReservationTab;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        //Create a text that contains the developers names
        Text creditsTitle = new Text("Credits: Developed By Omar Yousef and Farzana Moury");
        creditsTitle.setFill(Color.BLACK);
        creditsTitle.setStroke(Color.BLACK);
        creditsTitle.setStrokeWidth(1);
        creditsTitle.setFont(Font.font("Comic Sans MS", 15));

        //Create the imageView that has the Logo_image.jpg(Header Image)
        ImageView headerImage = new ImageView("logo-image.png");
        headerImage.setFitWidth(1024);
        headerImage.setFitHeight(400);

        //Create a vbox that has the text and imageview in it
        VBox headerBox = new VBox(creditsTitle, headerImage);
        headerBox.setSpacing(10);

        //Create a tabPane
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        //Create Tabs
        AddReservationTab addReservationTab = AddReservationTab.getInstance();
        DeleteReservationTab deleteReservationTab = DeleteReservationTab.getInstance();
        UpdateReservationTab updateReservationTab = UpdateReservationTab.getInstance();
        StatsTab statsTab = StatsTab.getInstance();

        //Add Tabs to the tabPane
        tabPane.getTabs().addAll(addReservationTab, deleteReservationTab, updateReservationTab, statsTab);

        //Create a borderPane
        BorderPane root = new BorderPane();

        //Add tabPane and Header VBox to the borderPane
        root.setCenter(tabPane);
        root.setTop(headerBox);

        //Scene and stage setup
        Scene scene = new Scene(root, 1024, 768);
        stage.setScene(scene);
        stage.setTitle("Hummus Restaurant Reservations Management System");
        stage.show();
    }
}
