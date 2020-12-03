package panes;

import com.mysql.cj.xdevapi.Table;
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

    private BarChart<String, Number> barGraph; //graph will be used to indicate how popular each table is

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

    public void generateChart(){
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
        barGraph.setTitle("Most Used Tables");

        XYChart.Series series = new XYChart.Series();

        for(TableNumber table: tables){
            series.getData().add(new XYChart.Data<String, Number>("Table " + table.getTableNum(), tablesTable.getItemCount(table.getId())));
        }

    }
}
