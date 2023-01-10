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


    /**
     * Creates a Linechart based of ranks the user wants to see and the stats chosen
     * @param startRank starting rank plotted on graph
     * @param endRank ending rank plotted on graph
     * @return LineChart Object
     */
    public Parent createLineChart(int startRank, int endRank) {
        //Creates axis for graph
        NumberAxis xAxis = new NumberAxis("Values for X-Axis", 0, 3, 1);
        NumberAxis yAxis = new NumberAxis("Values for Y-Axis", 0, 3, 1);


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

        //add lines depending on selected stats
        if(showPoints) {
            lineChartData.add(pointsSeries(startRank, endRank));
        } if(showAssists) {
            lineChartData.add(assistsSeries(startRank, endRank));
        } if(showRebounds) {
            lineChartData.add(reboundsSeries(startRank, endRank));
        } if(showWinShares) {
            lineChartData.add(winshareSeries(startRank, endRank));
        }

        //create and return new LineChart object
        LineChart chart = new LineChart(xAxis, yAxis, lineChartData);
        return chart;
    }   
    

    

    /**
     * Creates a LineChart Series for Points
     * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Integer, Double> object
     */
    public LineChart.Series<Integer, Double> pointsSeries(int startRank, int endRank) {

    }

    /**
     * Creates a LineChart Series for assists
    * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Integer, Double> object
     */
    public LineChart.Series<Integer, Double> assistsSeries(int startRank, int endRank) {

    }

    /**
     * Creates a LineChart Series for rebounds
     * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Integer, Double> object
     */
    public LineChart.Series<Integer, Double> reboundsSeries(int startRank, int endRank) {

    }

    /**
     * Creates a LineChart Series for win shares
     * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Integer, Double> object
     */
    public LineChart.Series<Integer, Double> winshareSeries(int startRank, int endRank) {

    }
    
    /**
     * ScatterPlot Graphs with given Parameters
     * @param startRank
     * @param endRank
     * @return LineChart.Series<Integer, Double> object
     */    
    public Parent createScatterPlot (int startRank, int endRank) {
    
    }

    
    
 
  
}