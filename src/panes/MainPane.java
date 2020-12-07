package panes;

import Database.Database;
import Tabs.AddReservationTab;
import Tabs.DeleteReservationTab;
import Tabs.StatsTab;
import Tabs.UpdateReservationTab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainPane extends BorderPane {
    public static StatisticsPane statsPane = new StatisticsPane();

    public MainPane(){
        //Create a text that contains the developers names
        Text creditsTitle = new Text("Credits: Developed By Omar Yousef and Farzana Moury");
        creditsTitle.setFill(Color.BLACK);
        creditsTitle.setStroke(Color.BLACK);
        creditsTitle.setStrokeWidth(1);
        creditsTitle.setFont(Font.font("Comic Sans MS", 15));

        //Create the imageView that has the Logo_image.jpg(Header Image)
        ImageView headerImage = new ImageView("images/logo-image.png");
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
        addReservationTab.setContent(new AddPane());

        DeleteReservationTab deleteReservationTab = DeleteReservationTab.getInstance();
        deleteReservationTab.setContent(new DeletePane());

        UpdateReservationTab updateReservationTab = UpdateReservationTab.getInstance();
        updateReservationTab.setContent(new UpdatePane());

        StatsTab statsTab = StatsTab.getInstance();
        statsTab.setContent(statsPane);

        //Add Tabs to the tabPane
        tabPane.getTabs().addAll(addReservationTab,updateReservationTab, deleteReservationTab, statsTab);
        //Add tabPane and Header VBox to the borderPane
        this.setCenter(tabPane);
        this.setTop(headerBox);

        //Scene and stage setup
        //scene = new Scene(root, 1024, 768);
    }

}
