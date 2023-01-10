/* ....Show License.... */
package charts;
 
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import java.io.*;
import java.util.*;  
 
/**
 * A line chart demonstrating a CategoryAxis implementation.
 */
public class ChartGenerator {
 
    private boolean showPoints;
    private boolean showAssists;
    private boolean showRebounds;
    private boolean showWinShares;
    private LineChart chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;



    public Parent createLineChart(int startYear, int endYear) {
        xAxis = new NumberAxis("Values for X-Axis", 0, 3, 1);
        yAxis = new NumberAxis("Values for Y-Axis", 0, 3, 1);


        ObservableList<XYChart.Data<Integer, Double>> dataset1 = FXCollections.observableArrayList();

        dataset1.add(new XYChart.Data<>(0, 1.0));
        dataset1.add(new XYChart.Data<>(1, 1.4));
        dataset1.add(new XYChart.Data<>(2, 1.9));
        dataset1.add(new XYChart.Data<>(2, 2.3));

        LineChart.Series<Integer, Double> series1 = new LineChart.Series<>("Series 1", dataset1);

        xAxis = new NumberAxis("Values for X-Axis", 0, 3, 1);
        yAxis = new NumberAxis("Values for Y-Axis", 0, 3, 1);

        ObservableList<XYChart.Series<Integer,Double>> lineChartData =
            FXCollections.observableArrayList();

        if(showPoints) {
            lineChartData.add(pointsSeries(startYear, endYear));
        } if(showAssists) {
            lineChartData.add(assistsSeries(startYear, endYear));
        } if(showRebounds) {
            lineChartData.add(reboundsSeries(startYear, endYear));
        } if(showWinShares) {
            lineChartData.add(winsharesSeries(startYear, endYear));
        }

        chart = new LineChart(xAxis, yAxis, lineChartData);
        return chart;
    }    
 
  
}