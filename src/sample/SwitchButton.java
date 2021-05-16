package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;

public class SwitchButton extends Label{

    private SimpleBooleanProperty switchedON = new SimpleBooleanProperty(true);


    public void Timer1(){
        Button switchBtn = new Button();
        switchBtn.setPrefWidth(40);
        switchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switchedON.set(!switchedON.get());
            }
        });
        setGraphic(switchBtn);

        switchedON.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    setText("Clock ON");
                    setStyle("-fx-background-color: green;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.RIGHT);

                }
                else {
                    setText("Clock OFF");
                    setStyle("-fx-background-color: red;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.LEFT);

                }
            }
        });
        switchedON.set(false);
    }
    public SimpleBooleanProperty switchOnProperty() { return switchedON; }
//    public int counter(int timer) {
//
//        while (count % 2 != 0) {
//            timer++;
//
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return timer;
//    }
}
