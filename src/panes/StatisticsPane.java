package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pojo.TableNumber;
import tables.TableNumTable;

import java.util.ArrayList;

/**
 * Statistics Pane which is used to display information in the StatsTab
 * Information Includes: A Statistical Bar Graph
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Dec 3rd 2020
 */
public class StatisticsPane extends BorderPane {

    public static BarChart<String, Number> barGraph; //graph will be used to indicate how popular each table is
    private static BorderPane graphHolder;
    /**
     * Constructor displaying Statistics content
     */
    public StatisticsPane() {
        //main VBox to contain main content
        graphHolder = new BorderPane();
        VBox content = new VBox();
        //content specs
        content.setSpacing(10);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(20, 20, 20, 20));

        //elements to be contained within the contents vBox
        //title
        Text title = new Text("Hummus Restaurant Statistics");
        title.setFill(Color.BLACK);
        title.setStroke(Color.BLACK);
        title.setStrokeWidth(1);
        title.setFont(Font.font("Comic Sans MS", 15));
        title.setLineSpacing(10);
        //bar graph
        graphHolder.setCenter(barGraph);
        generateChart();

        //adding these elements to the contents VBox
        content.getChildren().addAll(title, graphHolder);

        //setting the placement of the content VBox in this pane
        this.setTop(content);
    }

    public static void generateChart(){

        //getting access to the database
        TableNumTable tablesTable = new TableNumTable();

        //grabbing a list of table types
        ArrayList<TableNumber> tables = tablesTable.getAllTableNumbers();

        //Axes
        NumberAxis reservations = new NumberAxis(); //indicates how many people reserved
        CategoryAxis tableNumbers = new CategoryAxis(); //indicates the individual Tables (Table1, Table2, etc)
        reservations.setLabel("# of Reservations");
        tableNumbers.setLabel("Tables");


        //populating the bar graph with information
        barGraph = new BarChart<String, Number>(tableNumbers, reservations);
        barGraph.setTitle("Most Reserved Tables");

        XYChart.Series series = new XYChart.Series(); //represents a legend icon (in our case our restaurant)
        series.setName("Hummus Restaurant");


        for(TableNumber table: tables){ //retrieving the desired information from the reservations table
            series.getData().add(new XYChart.Data<String, Number>("Table " + table.getTableNum(), tablesTable.getTableCount(table.getId())));
        }

        //clearing the bar graph data and adding them (this is how it refreshes)
        barGraph.getData().clear();
        barGraph.getData().addAll(series);

        //adding specs to bar graph
        barGraph.setMaxHeight(230);
        barGraph.setMaxWidth(600);
        barGraph.setCategoryGap(20);
        graphHolder.setCenter(barGraph);
    }
}
