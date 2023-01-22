package ChartsManagement;
 
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import java.io.*;
import java.util.*;
import javafx.scene.layout.HBox;
import data.Sorter;
import data.GraphType;
import data.DataPoint;


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
    private Sorter sorter;
    private HBox lineChart;
    private HBox barChart;

    /**
     * Constructor automatically creates a CSVScraper object when created
     */
    public ChartGenerator () {
        this.scraper = new CSVScraper();
        this.showPoints = false;
        this.showAssists = false;
        this.showWinShares = false;
        this.showRebounds = false;
        this.startRank = 0;
        this.endRank = 0;
        this.showRank = 0;
        this.sorter = new Sorter();
        this.lineChart = new HBox();
        this.barChart = new HBox();
    }

    /*

    public HBox createBarChart() {
        

        BarChart<String, Double> chart = new BarChart<String, Double>(xAxis, yAxis);

        for(int i = 0; i < 500; i++) {
            sorter.addSort(GraphType.BYPOINTS, scraper.get(i));
        }

        DataPoint[] player = new DataPoint[5];
        String[] playerNames = new String[5];
        ArrayList<DataPoint> playerList = (ArrayList<DataPoint>)sorter.getArray().clone();

        for(int i = 0; i < 5; i++) {
            player[i] = playerList.get(i);
            playerNames[i] = playerList.get(i).getPlayerName();
        }


        
        XYChart.Series<String, Double> points = new XYChart.Series<String, Double>();
        points.getData().add(new XYChart.Data<String, Double>(player[0].getPlayerName(), player[0].getPpg()));
        points.getData().add(new XYChart.Data<String, Double>(player[1].getPlayerName(), player[1].getPpg()));
        points.getData().add(new XYChart.Data<String, Double>(player[2].getPlayerName(), player[2].getPpg()));
        points.getData().add(new XYChart.Data<String, Double>(player[3].getPlayerName(), player[3].getPpg()));
        points.getData().add(new XYChart.Data<String, Double>(player[4].getPlayerName(), player[4].getPpg()));

        XYChart.Series<String, Double> assists = new XYChart.Series<String, Double>();
        assists.getData().add(new XYChart.Data<String, Double>(player[0].getPlayerName(), player[0].getApg()));
        assists.getData().add(new XYChart.Data<String, Double>(player[1].getPlayerName(), player[1].getApg()));
        assists.getData().add(new XYChart.Data<String, Double>(player[2].getPlayerName(), player[2].getApg()));
        assists.getData().add(new XYChart.Data<String, Double>(player[3].getPlayerName(), player[3].getApg()));
        assists.getData().add(new XYChart.Data<String, Double>(player[4].getPlayerName(), player[4].getApg()));

        XYChart.Series<String, Double> rebounds = new XYChart.Series<String, Double>();
        rebounds.getData().add(new XYChart.Data<String, Double>(player[0].getPlayerName(), player[0].getRpg()));
        rebounds.getData().add(new XYChart.Data<String, Double>(player[1].getPlayerName(), player[1].getRpg()));
        rebounds.getData().add(new XYChart.Data<String, Double>(player[2].getPlayerName(), player[2].getRpg()));
        rebounds.getData().add(new XYChart.Data<String, Double>(player[3].getPlayerName(), player[3].getRpg()));
        rebounds.getData().add(new XYChart.Data<String, Double>(player[4].getPlayerName(), player[4].getRpg()));
        
        ObservableList<XYChart.Series<String, Double>> data = FXCollections.observableArrayList();

        data.add(points);
        data.add(assists);
        data.add(rebounds);

        chart.getData().addAll(points, rebounds, assists);

        HBox currentChart = new HBox();
        currentChart.setPrefWidth(1700);
        currentChart.setMinWidth(1000);
        currentChart.setMaxWidth(2500);

        currentChart.getChildren().add(chart);
        return currentChart;
    }

    */

    public Parent createContent() {
        BarChart chart;
        CategoryAxis xAxis;
        NumberAxis yAxis;

        for(int i = 0; i < 500; i++) {
            sorter.addSort(GraphType.BYPOINTS, scraper.get(i));
        }

        DataPoint[] player = new DataPoint[5];
        ArrayList<DataPoint> playerList = (ArrayList<DataPoint>) sorter.getArray().clone();

        

        int i = 1;
        for(i = 0; i < 5; i++) {
            player[i] = playerList.get(499 - i);
        }

        
        String[] playerNames = {player[0].getPlayerName(), player[1].getPlayerName(), player[2].getPlayerName(), player[3].getPlayerName(), player[4].getPlayerName()};
        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(playerNames));
        yAxis = new NumberAxis("Stat Value", 0.0d, 50.0d, 5.0d);
        ObservableList<BarChart.Series> barChartData =
            FXCollections.observableArrayList(
                new BarChart.Series("Points",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(player[0].getPlayerName(), player[0].getPpg()),
                    new BarChart.Data(player[1].getPlayerName(), player[1].getPpg()),
                    new BarChart.Data(player[2].getPlayerName(), player[1].getPpg()),
                    new BarChart.Data(player[3].getPlayerName(), player[1].getPpg()),
                    new BarChart.Data(player[4].getPlayerName(), player[4].getPpg()))),
                new BarChart.Series("Assists",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(player[0].getPlayerName(), player[0].getApg()),
                    new BarChart.Data(player[1].getPlayerName(), player[1].getApg()),
                    new BarChart.Data(player[2].getPlayerName(), player[1].getApg()),
                    new BarChart.Data(player[3].getPlayerName(), player[1].getApg()),
                    new BarChart.Data(player[4].getPlayerName(), player[4].getApg()))),
                    new BarChart.Series("Rebounds",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(player[0].getPlayerName(), player[0].getRpg()),
                    new BarChart.Data(player[1].getPlayerName(), player[1].getRpg()),
                    new BarChart.Data(player[2].getPlayerName(), player[1].getRpg()),
                    new BarChart.Data(player[3].getPlayerName(), player[1].getRpg()),
                    new BarChart.Data(player[4].getPlayerName(), player[4].getRpg())))
            );
        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);

        chart.setPrefWidth(2500);

        this.barChart.getChildren().clear();
        this.barChart.getChildren().add(chart);

        return this.barChart;
    }


    /**
     * Creates a Linechart based of ranks the user wants to see and the stats chosen
     * @param startRank starting rank plotted on graph
     * @param endRank ending rank plotted on graph
     */
    public HBox createRankLineChart() {
        HBox currentChart = new HBox();
        currentChart.setPrefWidth(1700);
        currentChart.setMinWidth(1000);
        currentChart.setMaxWidth(2500);
        NumberAxis xAxis = new NumberAxis("Rank", startRank, endRank, 1);
        NumberAxis yAxis = new NumberAxis("Value", 0, 100, 0.1);
        


        ObservableList<XYChart.Series<Double,Double>> lineChartData =
            FXCollections.observableArrayList();

        //add lines depending on selected stats
        if(showRank != 0) {
            lineChartData.add(this.rankSeries());

            NumberAxis xAxis1 = sorter.axis("Stat Value");
            xAxis = xAxis1;
            yAxis = new NumberAxis("Rank", 0, 500, 1);
        } else {
            if(showPoints) {
                lineChartData.add(this.pointsSeries(startRank, endRank));

                NumberAxis yAxis1 = sorter.axis("Value");
                yAxis = yAxis1;

            } if(showAssists) {
                lineChartData.add(this.assistsSeries(startRank, endRank));

                NumberAxis yAxis1 = sorter.axis("Value");
                yAxis = yAxis1;

            } if(showRebounds) {
                lineChartData.add(this.reboundsSeries(startRank, endRank));

                NumberAxis yAxis1 = sorter.axis("Value");
                yAxis = yAxis1;

            } if(showWinShares) {
                lineChartData.add(this.winshareSeries(startRank, endRank));

                NumberAxis yAxis1 = sorter.axis("Value");
                yAxis = yAxis1;

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

            title += "by Rank";

            
        }
        this.sorter = new Sorter();

        title += " on SLAM's 2011 Top 500 Players";

        chart.setTitle(title);
        chart.setPrefWidth(2500);
        this.lineChart.getChildren().clear();
        this.lineChart.getChildren().add(chart);

        return lineChart;
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
            pointsData.add(new XYChart.Data<>((double) i, sorter.addSort(GraphType.BYPOINTS, scraper.get(i))));

            
        }

        LineChart.Series<Double, Double> points = new LineChart.Series<>("Points Per Game", pointsData);

        return points;
    }

    
    public LineChart.Series<Double, Double> rankSeries() {
        ObservableList<XYChart.Data<Double, Double>> rankData = FXCollections.observableArrayList();

        for(int i = 0; i <= 500; i++) {
            switch(this.showRank) {
                case 1:
                    rankData.add(new XYChart.Data<>(sorter.addSort(GraphType.BYPOINTS, scraper.get(i)), (double) scraper.get(i).getRank()));
                    break;
                case 2:
                    rankData.add(new XYChart.Data<>(sorter.addSort(GraphType.BYASSISTS, scraper.get(i)), (double) scraper.get(i).getRank()));
                    break;
                case 3:
                    rankData.add(new XYChart.Data<>(sorter.addSort(GraphType.BYREBOUNDS, scraper.get(i)), (double) scraper.get(i).getRank()));
                    break;
                case 4:
                    rankData.add(new XYChart.Data<>(sorter.addSort(GraphType.BYWINSHARES, scraper.get(i)), (double) scraper.get(i).getRank()));
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
            assistsData.add(new XYChart.Data<>((double) i, sorter.addSort(GraphType.BYASSISTS, scraper.get(i))));
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
            reboundsData.add(new XYChart.Data<>((double) i, sorter.addSort(GraphType.BYREBOUNDS, scraper.get(i))));
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
            winshareSeries.add(new XYChart.Data<>((double) i, sorter.addSort(GraphType.BYWINSHARES, scraper.get(i))));
        }

        LineChart.Series<Double, Double> winshares = new LineChart.Series<>("Total Win Shares", winshareSeries);

        return winshares;
    }


    public void setStartRank(int startRank) {
        this.startRank = startRank;
    }

    public void setEndRank(int endRank) {
        this.endRank = endRank;
    }    
 
}