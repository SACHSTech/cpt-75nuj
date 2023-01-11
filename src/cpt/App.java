package cpt;
 
 
import ChartsManagement.ChartGenerator;
import data.CSVScraper;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Insets; 
 
/**
 * A line chart demonstrating a CategoryAxis implementation.
 */
public class App extends Application {
    ChartGenerator chart = new ChartGenerator();

    int startRank = 1;
    int endRank = 10;
    boolean showLineChart = true;
    

    /**
     * Overriding JavaFX Application Class method to run wanted script
     */

    @Override public void start(Stage primaryStage) throws Exception {
        //Initializes StackPane object
        HBox layout;
        Button button1 = new Button("Button Number 1");

        //User has toggle which indicates whether they want to display a line or pie chart
        if(showLineChart) {
            //adds created linechart to existing stackpane
            LineChart charts = chart.createRankLineChart(startRank, endRank);
           

            charts.setPrefWidth(900);
            charts.setMinWidth(400);
            charts.setMaxWidth(1000);

       
            layout = new HBox(charts, button1);
            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            //adds created piechart to existing stackpane
            //layout.getChildren().add(chart.createPieGraph(startRank, endRank));
        }

        




        
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
       
        
    }
}