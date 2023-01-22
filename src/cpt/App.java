package cpt;
 
 
import ChartsManagement.ChartGenerator;
import ChartsManagement.ChartValueController;
import data.CSVScraper;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;


 
/**
 * A line chart demonstrating a CategoryAxis implementation.
 */
public class App extends Application {
    ChartGenerator chart = new ChartGenerator();

    

    /**
     * Overriding JavaFX Application Class method to run wanted script
     */

    @Override public void start(Stage primaryStage) throws Exception {
        
        ChartValueController controller = new ChartValueController();
        

        Tab lineChart = new Tab("Line Chart");
        lineChart.setClosable(false);

        controller.addChartObject(chart);
        HBox layoutLineChart = new HBox(chart.createRankLineChart(), controller.lineControl());

        lineChart.setContent(layoutLineChart);

        Tab barChart = new Tab("Bar Chart");
        barChart.setClosable(false);

        controller.addChartObject(chart);
        HBox layoutBarChart = new HBox(chart.createContent());

        barChart.setContent(layoutBarChart);

        


        
        TabPane tabpane = new TabPane(lineChart, barChart);

        HBox layout = new HBox(tabpane);
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