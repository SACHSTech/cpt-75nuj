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
 
/**
 * An example of radio buttons in various states.
 */
public class ChartValueController {
 
    public HBox createContent() {
        HBox hbox = new HBox(18);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER_LEFT);
 
        ToggleGroup tg = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Hello");
        rb1.setToggleGroup(tg);
 
        RadioButton rb2 = new RadioButton("Bye");
        rb2.setToggleGroup(tg);
        rb2.setSelected(true);
 
        RadioButton rb3 = new RadioButton("Disabled");
        rb3.setToggleGroup(tg);
        rb3.setSelected(false);
        rb3.setDisable(true);
 
        vbox.getChildren().addAll(rb1, rb2, rb3);
        hbox.getChildren().add(vbox);
 
        return hbox;
    }
 


}