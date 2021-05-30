package sample;

import com.sun.javafx.css.StyleCache;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;

import java.awt.*;


import java.util.concurrent.TimeUnit;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SwitchButton extends Label{

    private SimpleBooleanProperty switchedON = new SimpleBooleanProperty(true);
    int split = 0;
    //method
    public void Timer1(Stopwatch stopwatch){
        //button
        int timeSplit = 0;
        Button switchBtn = new Button();
        switchBtn.setPrefWidth(40);
        switchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switchedON.set(!switchedON.get());
            }
        });
        setGraphic(switchBtn);

        //button
        switchedON.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    split++;
                    setText("Clock ON");
                    setStyle("-fx-background-color: green;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.RIGHT);
//                    splitTime = Duration.ZERO;
//                    splitTimeSeconds.set(splitTime.toSeconds());
                    System.out.println(split);
                    if (split == 0) {
                        stopwatch.start();
                        System.out.println("System ON");
                    }
                }
                else {
                    split--;
                    setText("Clock OFF");
                    setStyle("-fx-background-color: red;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.LEFT);
                    stopwatch.reset();
                    System.out.println("System OFF");
                }
            }
        });
        switchedON.set(false);
    }
    public SimpleBooleanProperty switchOnProperty() { return switchedON; }
}
