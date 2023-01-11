package ChartsManagement;
 
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
 
/**
 * An example of radio buttons in various states.
 */
public class ChartValueController {
 
    public static HBox initialLineChart() {
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
        rb1.setSelected(true);
 
        RadioButton rb2 = new RadioButton("Points");
        rb2.setToggleGroup(tg);
 
        RadioButton rb3 = new RadioButton("Assists");
        rb3.setToggleGroup(tg);

        RadioButton rb4 = new RadioButton("Rebounds");
        rb4.setToggleGroup(tg);

        RadioButton rb5 = new RadioButton("Win Shares");
        rb5.setToggleGroup(tg);
 
        vbox.getChildren().addAll(txt, rb1, rb2, rb3, rb4, rb5);
        hbox.getChildren().add(vbox);

        
 
        return hbox;
    }
 


}