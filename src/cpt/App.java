package cpt;
 
 
import charts.ChartGenerator;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
 
/**
 * A line chart demonstrating a CategoryAxis implementation.
 */
public class App extends Application {
    ChartGenerator chart = new ChartGenerator();

    int startRank = 1955;
    int endRank = 2021;
    boolean showLineChart = true;

    /**
     * Overriding JavaFX Application Class method to run wanted script
     */

    @Override public void start(Stage primaryStage) throws Exception {
        //Initializes StackPane object
        StackPane layout = new StackPane();

        //User has toggle which indicates whether they want to display a line or pie chart
        if(showLineChart) {
            //adds created linechart to existing stackpane
            layout.getChildren().add(chart.createLineChart(startRank, endRank));
        } else {
            //adds created piechart to existing stackpane
            layout.getChildren().add(chart.createPieGraph(startRank, endRank));
        }
        
        //creates a scene including creating stackpane, then puts it on the window stage
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
    }
}