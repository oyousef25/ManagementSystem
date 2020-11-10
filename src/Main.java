import Tabs.AddReservationTab;
import Tabs.DeleteReservationTab;
import Tabs.StatsTab;
import Tabs.UpdateReservationTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        //Create a textView
        //Create the imageView that has the Logo_image.jpg(Header Image)

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

        //Add tabPane to the borderPane
        root.setBottom(tabPane);

        //Scene and stage setup
        Scene scene = new Scene(root, 1024, 768);
        stage.setScene(scene);
        stage.setTitle("Hummus Restaurant Reservations Management System");
        stage.show();
    }
}
