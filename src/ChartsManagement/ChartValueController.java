package ChartsManagement;
 
import java.util.logging.Handler;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text; 
import javafx.scene.control.Slider;
import javafx.scene.control.*;
import javafx.beans.value.*;
import javafx.event.*;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.event.ActionEvent;

 
/**
 * An example of radio buttons in various states.
 */
public class ChartValueController {
 
    public static VBox initialLineControl() {
        HBox hbox = new HBox(18);
        hbox.setAlignment(Pos.CENTER);
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

        submit.setOnAction((ActionEvent t) -> {
            nextLineChart();
        });


 
        vbox.getChildren().addAll(txt, rb1, rb2, rb3, rb4, rb5, text, fromSlider, text1, toSlider, submit);
      

        
 
        return vbox;
    }

    public static VBox nextLineChart() {



    }


    public static HBox lineControl() {
        
    }

    




    
 


}


