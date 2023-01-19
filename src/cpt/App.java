package cpt;
 
 
import ChartsManagement.ChartGenerator;
import ChartsManagement.ChartValueController;
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

    boolean showLineChart = true;
    

    /**
     * Overriding JavaFX Application Class method to run wanted script
     */

    @Override public void start(Stage primaryStage) throws Exception {
        //Initializes StackPane object
        HBox layout;
        ChartValueController controller = new ChartValueController();

        //User has toggle which indicates whether they want to display a line or pie chart
        if(showLineChart) {
            //adds created linechart to existing stackpane
            
    

            chart.createRankLineChart();
            controller.addChartObject(chart);
           


       
            layout = new HBox(chart.getCurrentChart(), controller.lineControl());
         
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