package ChartsManagement;
 

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text; 
import javafx.scene.control.Slider;
import javafx.beans.value.*;
import javafx.scene.control.Button;
import java.util.*;
import data.GraphType;

import javafx.event.ActionEvent;

 
/**
 * An example of radio buttons in various states.
 */
public class ChartValueController {

    private VBox lineControls;
    private VBox barControls;
    private boolean secondaryPanel;
    private ArrayList<Boolean> rankBooleans;
    private ChartGenerator chartObject;

    public ChartValueController () {
        lineControls = new VBox(18);
        lineControls.setPadding(new Insets(100, 50, 50, 50));
        barControls = new VBox(18);
        barControls.setAlignment(Pos.CENTER);
        barControls.setPadding(new Insets(100, 50, 50, 50));
        rankBooleans = new ArrayList<>();
        rankBooleans.add(false);
        rankBooleans.add(false);
        rankBooleans.add(false);
        rankBooleans.add(false);
    }
 
    public void initialLineControl() {
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER_LEFT);

        Text txt = new Text();
        txt.setText("X-Axis");
 
        ToggleGroup tg = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Rank");
        rb1.setToggleGroup(tg);
 
        RadioButton rb2 = new RadioButton("Points");
        rb2.setToggleGroup(tg);
 
        RadioButton rb3 = new RadioButton("Assists");
        rb3.setToggleGroup(tg);

        RadioButton rb4 = new RadioButton("Rebounds");
        rb4.setToggleGroup(tg);

        RadioButton rb5 = new RadioButton("Win Shares");
        rb5.setToggleGroup(tg);

        

        Text text = new Text();      
      
        //Setting the text to be added. 
        text.setText("Starting Rank"); 

        Slider fromSlider = new Slider(1, 500, 50);
        fromSlider.setShowTickMarks(true);
        fromSlider.setPrefWidth(200);
        fromSlider.setShowTickLabels(true);
        fromSlider.setMajorTickUnit(50f);
        fromSlider.setBlockIncrement(50f);
        fromSlider.setDisable(true);

        Text text1 = new Text();      
      
        //Setting the text to be added. 
        text1.setText("Ending Rank");

        Slider toSlider = new Slider(1, 500, 50);
        toSlider.setShowTickMarks(true);
        toSlider.setPrefWidth(200);
        toSlider.setShowTickLabels(true);
        toSlider.setMajorTickUnit(50f);
        toSlider.setBlockIncrement(50f);
        toSlider.setDisable(true);

        rb1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {    
                    fromSlider.setDisable(false);
                    toSlider.setDisable(false);
                } else {
                    fromSlider.setDisable(true);
                    toSlider.setDisable(true);
                }
            }
        });

        Button submit = new Button("Submit");

 
        vbox.getChildren().addAll(txt, rb1, rb2, rb3, rb4, rb5, text, fromSlider, text1, toSlider, submit);
        vbox.setPrefWidth(400);
        vbox.setMinWidth(250);
        vbox.setMaxWidth(700);

        this.addLineControl(vbox);

        submit.setOnAction((ActionEvent t) -> {
            if (fromSlider.getValue() < toSlider.getValue()) {
                chartObject.setEndRank((int)toSlider.getValue());
                chartObject.setStartRank((int)fromSlider.getValue());
            }
            
            if(rb2.isSelected()) {
                chartObject.setShowRank(1);
            } else if(rb3.isSelected()){
                chartObject.setShowRank(2);
            } else if(rb4.isSelected()) {
                chartObject.setShowRank(3);
            } else if(rb5.isSelected()) {
                chartObject.setShowRank(4);
            } else {
                chartObject.setShowRank(0);
            }

            if(!secondaryPanel && rb1.isSelected() ) {
                nextLineChart();
            } 
        });
        
 
    }

    

    
    
    public void nextLineChart() {
        this.secondaryPanel = true;

        
        RadioButton rb2 = new RadioButton("Points");
 
        RadioButton rb3 = new RadioButton("Assists");

        RadioButton rb4 = new RadioButton("Rebounds");

        RadioButton rb5 = new RadioButton("Win Shares");

        VBox vbox = new VBox();

        Text yaxis = new Text();      
      
        //Setting the text to be added. 
        yaxis.setText("Y-Axis"); 

        Button submit = new Button("Submit");

        vbox.getChildren().addAll(yaxis, rb2, rb3, rb4, rb5, submit);
            
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER_LEFT);
      
        this.addLineControl(vbox);

        submit.setOnAction((ActionEvent t) -> {
    
            rankBooleans.add(0, rb2.isSelected());
            rankBooleans.add(1, rb3.isSelected());
            rankBooleans.add(2, rb4.isSelected());
            rankBooleans.add(3, rb5.isSelected());


            boolean one = this.getRankBooleans().get(0);
            boolean two = this.getRankBooleans().get(1);
            boolean three = this.getRankBooleans().get(2);
            boolean four = this.getRankBooleans().get(3);
            
            if(one || two || three || four) {
                chartObject.updateBooleans(one, two, three, four);
                this.secondaryPanel = false;
                this.reset();
            }
                

        });
     

    }

    public void initialBarControl() {
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER_LEFT);

        Text txt = new Text();
        txt.setText("Select Stat");
 
        ToggleGroup tg = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Rank");
        rb1.setToggleGroup(tg);
 
        RadioButton rb2 = new RadioButton("Points");
        rb2.setToggleGroup(tg);
 
        RadioButton rb3 = new RadioButton("Assists");
        rb3.setToggleGroup(tg);

        RadioButton rb4 = new RadioButton("Rebounds");
        rb4.setToggleGroup(tg);

        RadioButton rb5 = new RadioButton("Win Shares");
        rb5.setToggleGroup(tg);


        Text text1 = new Text();      
      
        //Setting the text to be added. 
        text1.setText("Position");

        Slider position = new Slider(1, 496, 50);
        position.setShowTickMarks(true);
        position.setPrefWidth(200);
        position.setShowTickLabels(true);
        position.setMajorTickUnit(50f);
        position.setBlockIncrement(50f);

        

        Button submit = new Button("Submit");

 
        vbox.getChildren().addAll(txt, rb1, rb2, rb3, rb4, rb5, text1, position, submit);
        vbox.setPrefWidth(400);
        vbox.setMinWidth(250);
        vbox.setMaxWidth(700);

        this.addBarControl(vbox);

        submit.setOnAction((ActionEvent t) -> {
            if(rb1.isSelected()) {
                chartObject.changeBarChart(GraphType.BYRANK, (int) position.getValue());
            } else if(rb2.isSelected()) {  
                chartObject.changeBarChart(GraphType.BYPOINTS, (int) position.getValue());
            } else if(rb3.isSelected()) {
                chartObject.changeBarChart(GraphType.BYASSISTS, (int) position.getValue());
            } else if(rb4.isSelected()) {
                chartObject.changeBarChart(GraphType.BYREBOUNDS, (int) position.getValue());
            } else if(rb5.isSelected()) {
                chartObject.changeBarChart(GraphType.BYWINSHARES, (int) position.getValue());
            }



        });
        
 
    }


    public VBox barControl() {
        initialBarControl();
        return barControls;
    }

    
    public void addBarControl(VBox newBox) {
        barControls.getChildren().addAll(newBox);
    }


    public void addLineControl(VBox newBox) {
        lineControls.getChildren().addAll(newBox);
      
    }

    

    public VBox lineControl() {
        initialLineControl();
        return lineControls;
    }

    public void reset() {
        lineControls.getChildren().clear();
        lineControl();
    }

    public ArrayList<Boolean> getRankBooleans() {
        return rankBooleans;
    }

    public void addChartObject(ChartGenerator chart) {
        this.chartObject = chart;
    }

}


