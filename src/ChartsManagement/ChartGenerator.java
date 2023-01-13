package ChartsManagement;
 
 
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


import data.CSVScraper;  
 
/**
 * A line chart demonstrating a CategoryAxis implementation.
 */
public class ChartGenerator {
 
    private boolean showPoints;
    private boolean showAssists;
    private boolean showRebounds;
    private boolean showWinShares;
    private CSVScraper scraper;

    /**
     * Constructor automatically creates a CSVScraper object when created
     */
    public ChartGenerator () {
        this.scraper = new CSVScraper();
    }


    /**
     * Creates a Linechart based of ranks the user wants to see and the stats chosen
     * @param startRank starting rank plotted on graph
     * @param endRank ending rank plotted on graph
     * @return LineChart Object
     */
    public LineChart createRankLineChart(int startRank, int endRank) {
        //Creates axis for graph
        NumberAxis xAxis = new NumberAxis("Rank", startRank, endRank, 1);
        NumberAxis yAxis = new NumberAxis("Value", 0, 300, 1);


        ObservableList<XYChart.Series<Integer,Double>> lineChartData =
            FXCollections.observableArrayList();

        showPoints = true;
        showAssists = true;
        showRebounds = true;
        showWinShares = true;
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


        //Creates a title based on the selected stats
        String title = "";

        if(showPoints) {
            title += "Points, ";
        } if(showAssists) {
            title += "Assists, ";
        } if(showRebounds) {
            title += "Rebounds, ";
        } if(showWinShares) {
            title += "Win Shares, ";
        }

        title += "By Rank on SLAM's 2011 Top 500 Players";

        chart.setTitle(title);
        return chart;
    }  
    
    /**
     * Creates a LineChart Series for Points
     * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Integer, Double> object
     */
    public LineChart.Series<Integer, Double> pointsSeries(int startRank, int endRank) {
        ObservableList<XYChart.Data<Integer, Double>> pointsData = FXCollections.observableArrayList();

        for(int i = startRank; i <= endRank; i++) {
            pointsData.add(new XYChart.Data<>(i, scraper.get(i).getPpg()));
        }

        LineChart.Series<Integer, Double> points = new LineChart.Series<>("Points Per Game", pointsData);

        return points;
    }

    
    /**
     * Creates a LineChart Series for assists
    * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Integer, Double> object
     */
    public LineChart.Series<Integer, Double> assistsSeries(int startRank, int endRank) {
        ObservableList<XYChart.Data<Integer, Double>> assistsData = FXCollections.observableArrayList();

        for(int i = startRank; i <= endRank; i++) {
            assistsData.add(new XYChart.Data<>(i, scraper.get(i).getApg()));
        }

        LineChart.Series<Integer, Double> assists = new LineChart.Series<>("Assists Per Game", assistsData);

        return assists;
    }

    /**
     * Creates a LineChart Series for rebounds
     * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Integer, Double> object
     */
    public LineChart.Series<Integer, Double> reboundsSeries(int startRank, int endRank) {
        ObservableList<XYChart.Data<Integer, Double>> reboundsData = FXCollections.observableArrayList();

        for(int i = startRank; i <= endRank; i++) {
            reboundsData.add(new XYChart.Data<>(i, scraper.get(i).getRpg()));
        }

        LineChart.Series<Integer, Double> rebounds = new LineChart.Series<>("Rebounds Per Game", reboundsData);

        return rebounds;
    }

    /**
     * Creates a LineChart Series for win shares
     * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Integer, Double> object
     */
    public LineChart.Series<Integer, Double> winshareSeries(int startRank, int endRank) {
        ObservableList<XYChart.Data<Integer, Double>> winshareSeries = FXCollections.observableArrayList();

        for(int i = startRank; i <= endRank; i++) {
            winshareSeries.add(new XYChart.Data<>(i, scraper.get(i).getCareerWinShares()));
        }

        LineChart.Series<Integer, Double> winshares = new LineChart.Series<>("Total Win Shares", winshareSeries);

        return winshares;
    }
    
 
}