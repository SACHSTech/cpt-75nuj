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
        StackPane layout = new StackPane();

        if(showLineChart) {
            layout.getChildren().add(chart.createLineChart(startRank, endRank));
        } else {
            layout.getChildren().add(chart.createPieGraph(startRank, endRank));
        }
        

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