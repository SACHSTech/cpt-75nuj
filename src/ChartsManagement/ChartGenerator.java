package ChartsManagement;
 
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import java.io.*;
import java.util.*;
import javafx.scene.layout.HBox;


import data.CSVScraper;  
 
/**
 * A line chart demonstrating a CategoryAxis implementation.
 */
public class ChartGenerator {
 
    private boolean showPoints;
    private boolean showAssists;
    private boolean showRebounds;
    private boolean showWinShares;
    private int showRank;
    private CSVScraper scraper;
    private int startRank;
    private int endRank;
    private HBox currentChart;

    /**
     * Constructor automatically creates a CSVScraper object when created
     */
    public ChartGenerator () {
        this.scraper = new CSVScraper();
        this.showPoints = false;
        this.showAssists = false;
        this.showWinShares = false;
        this.showRebounds = false;
        this.currentChart = new HBox();
        this.startRank = 0;
        this.endRank = 0;
        this.showRank = 0;
    }


    /**
     * Creates a Linechart based of ranks the user wants to see and the stats chosen
     * @param startRank starting rank plotted on graph
     * @param endRank ending rank plotted on graph
     */
    public void createRankLineChart() {
        //Creates axis for graph
        NumberAxis xAxis = new NumberAxis("Rank", startRank, endRank, 1);
        NumberAxis yAxis = new NumberAxis("Value", 0, 300, 1);


        ObservableList<XYChart.Series<Double,Double>> lineChartData =
            FXCollections.observableArrayList();

        //add lines depending on selected stats
        if(showRank != 0) {
            lineChartData.add(this.rankSeries());
            xAxis = new NumberAxis("Stat Value", 1, 300, 1);
            yAxis = new NumberAxis("Rank", 0, 500, 1);
        } else {
            if(showPoints) {
                lineChartData.add(this.pointsSeries(startRank, endRank));
            } if(showAssists) {
                lineChartData.add(this.assistsSeries(startRank, endRank));
            } if(showRebounds) {
                lineChartData.add(this.reboundsSeries(startRank, endRank));
            } if(showWinShares) {
                lineChartData.add(this.winshareSeries(startRank, endRank));
            }
        }
       

        

        //create and return new LineChart object
        LineChart chart = new LineChart(xAxis, yAxis, lineChartData);


        //Creates a title based on the selected stats
        String title = "";
        if(showRank != 0) {
            title += "Rank vs ";
            switch(showRank) {
                case 1:
                    title += "Points";
                    break;
                case 2:
                    title += "Assists";
                    break;
                case 3:
                    title += "Rebounds";
                    break;
                case 4:
                    title += "Career Win Shares";
                    break;
                
            }
        } else if(showPoints || showAssists || showRebounds || showWinShares) {
            if(showPoints) {
                title += "Points, ";
                
            } if(showAssists) {
                title += "Assists, ";
                
            } if(showRebounds) {
                title += "Rebounds, ";
                
            } if(showWinShares) {
                title += "Win Shares, ";
               
            }

            title += "by Rank ";

            
        }
        

        title += " on SLAM's 2011 Top 500 Players";

        chart.setTitle(title);
        this.currentChart.getChildren().clear();
        this.currentChart.getChildren().add(chart);
    }
    
    public void updateBooleans(boolean showPoints, boolean showAssists, boolean showRebounds, boolean showWinShares) {
        this.showPoints = showPoints;
        this.showAssists = showAssists;
        this.showRebounds = showRebounds;
        this.showWinShares = showWinShares;

        this.createRankLineChart();

    }

    public void setShowRank(int rank) {
        this.showRank = rank;
        if(rank != 0) {
            this.createRankLineChart();
        }
    }
    
    /**
     * Creates a LineChart Series for Points
     * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Double, Double> object
     */
    public LineChart.Series<Double, Double> pointsSeries(int startRank, int endRank) {
        ObservableList<XYChart.Data<Double, Double>> pointsData = FXCollections.observableArrayList();

        for(int i = startRank; i <= endRank; i++) {
            pointsData.add(new XYChart.Data<>((double) i, scraper.get(i).getPpg()));
        }

        LineChart.Series<Double, Double> points = new LineChart.Series<>("Points Per Game", pointsData);

        return points;
    }

    
    public LineChart.Series<Double, Double> rankSeries() {
        ObservableList<XYChart.Data<Double, Double>> rankData = FXCollections.observableArrayList();

        for(int i = 0; i <= 500; i++) {
            switch(this.showRank) {
                case 1:
                    rankData.add(new XYChart.Data<>((double) scraper.get(i).getPpg(), (double) scraper.get(i).getRank()));
                    break;
                case 2:
                    rankData.add(new XYChart.Data<>((double) scraper.get(i).getApg(), (double) scraper.get(i).getRank()));
                    break;
                case 3:
                    rankData.add(new XYChart.Data<>((double) scraper.get(i).getRpg(), (double) scraper.get(i).getRank()));
                    break;
                case 4:
                    rankData.add(new XYChart.Data<>((double) scraper.get(i).getCareerWinShares(), (double) scraper.get(i).getRank()));
                    break;
            
            }
            
        }

        LineChart.Series<Double, Double> rank = new LineChart.Series<>("Rank", rankData);

        return rank;
    }

    
    /**
     * Creates a LineChart Series for assists
    * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Double, Double> object
     */
    public LineChart.Series<Double, Double> assistsSeries(int startRank, int endRank) {
        ObservableList<XYChart.Data<Double, Double>> assistsData = FXCollections.observableArrayList();

        for(int i = startRank; i <= endRank; i++) {
            assistsData.add(new XYChart.Data<>((double) i, scraper.get(i).getApg()));
        }

        LineChart.Series<Double, Double> assists = new LineChart.Series<>("Assists Per Game", assistsData);

        return assists;
    }

    /**
     * Creates a LineChart Series for rebounds
     * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Double, Double> object
     */
    public LineChart.Series<Double, Double> reboundsSeries(int startRank, int endRank) {
        ObservableList<XYChart.Data<Double, Double>> reboundsData = FXCollections.observableArrayList();

        for(int i = startRank; i <= endRank; i++) {
            reboundsData.add(new XYChart.Data<>((double) i, scraper.get(i).getRpg()));
        }

        LineChart.Series<Double, Double> rebounds = new LineChart.Series<>("Rebounds Per Game", reboundsData);

        return rebounds;
    }

    /**
     * Creates a LineChart Series for win shares
     * @param startRank starting rank in series
     * @param endRank ending rank in series
     * @return LineChart.Series<Double, Double> object
     */
    public LineChart.Series<Double, Double> winshareSeries(int startRank, int endRank) {
        ObservableList<XYChart.Data<Double, Double>> winshareSeries = FXCollections.observableArrayList();

        for(int i = startRank; i <= endRank; i++) {
            winshareSeries.add(new XYChart.Data<>((double) i, scraper.get(i).getCareerWinShares()));
        }

        LineChart.Series<Double, Double> winshares = new LineChart.Series<>("Total Win Shares", winshareSeries);

        return winshares;
    }

    public HBox getCurrentChart() {
        return currentChart;
    }

    public void setStartRank(int startRank) {
        this.startRank = startRank;
    }

    public void setEndRank(int endRank) {
        this.endRank = endRank;
    }    
 
}