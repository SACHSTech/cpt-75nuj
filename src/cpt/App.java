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
        TabPane tabpane = new TabPane();

        Tab lineChart = new Tab("Line Chart");
        lineChart.setClosable(false);

        chart.createRankLineChart();
        controller.addChartObject(chart);
        HBox layoutLineChart = new HBox(chart.getCurrentChart(), controller.lineControl());

        lineChart.setContent(layoutLineChart);


        
        tabpane.getTabs().add(lineChart);

        Scene scene = new Scene(tabpane);
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