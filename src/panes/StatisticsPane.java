package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Statistics Pane which is used to display information in the StatsTab
 * Information Includes: A Statistical Bar Graph
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Dec 3rd 2020
 */
public class StatisticsPane extends BorderPane {

    /**
     * Constructor displaying Statistics content
     */
    public StatisticsPane() {
        //main VBox to contain main content
        VBox content = new VBox();
        //content specs
        content.setSpacing(10);
        content.setAlignment(Pos.CENTER_LEFT);
        content.setPadding(new Insets(20, 20, 20, 20));

        //elements to be contained within the contents vBox
        //title
        Text title = new Text("Statistics Pane");
        title.setFill(Color.BLACK);
        title.setStroke(Color.BLACK);
        title.setStrokeWidth(1);
        title.setFont(Font.font("Comic Sans MS", 15));
        title.setLineSpacing(10);

        //adding these elements to the contents VBox
        content.getChildren().add(title);

        //setting the placement of the content VBox in this pane
        this.setTop(content);
    }
}
