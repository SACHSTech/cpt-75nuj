package ChartsManagement;
 

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text; 
import javafx.scene.control.Slider;
import javafx.beans.value.*;
import javafx.scene.control.Button;
import java.util.*;

import javafx.event.ActionEvent;

 
/**
 * An example of radio buttons in various states.
 */
public class ChartValueController {

    private VBox lineControls;
    private boolean secondaryPanel;
    private ArrayList<Boolean> rankBooleans;
    private ChartGenerator chartObject;

    public ChartValueController () {
        lineControls = new VBox(18);
        lineControls.setAlignment(Pos.CENTER);
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
      
        lineControl(vbox);

        submit.setOnAction((ActionEvent t) -> {
            if (fromSlider.getValue() < toSlider.getValue()) {
                chartObject.setEndRank((int)toSlider.getValue());
                chartObject.setStartRank((int)fromSlider.getValue());
                if(!secondaryPanel) {
                    nextLineChart(rb1.isSelected());
                }
            }
        });
        
 
    }

    public void nextLineChart(boolean rank) {
        this.secondaryPanel = true;

        if(rank) { 
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
      
            lineControl(vbox);

            submit.setOnAction((ActionEvent t) -> {
               

                rankBooleans.add(0, rb2.isSelected());
                rankBooleans.add(0, rb3.isSelected());
                rankBooleans.add(0, rb4.isSelected());
                rankBooleans.add(0, rb5.isSelected());


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

        } else  {

        }

    }


    public void lineControl(VBox one) {
        lineControls.getChildren().addAll(one);
      
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


