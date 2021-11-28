package sample;

import com.sun.javafx.css.StyleCache;
import com.sun.prism.paint.Stop;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;

import java.awt.*;


import java.util.concurrent.TimeUnit;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
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
    int time = 0;
    private boolean active;
    long timeValue;
    float timeValue2;
    long timeTotal = 0;
    static public float sec = 0;

    public float getTimeInSeconds(long start){
        long end = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        sec = (end - start) / 1000F;
        System.out.println(sec + " Switch button seconds");

        timeTotal += sec;
        System.out.println("Total time in Seconds (switchButton): " + timeTotal);
        sec = System.currentTimeMillis();
        return sec;
    }

    public int Timer1(Stopwatch stopwatch, ObservableList<TimeTable> data){
        //button
        Button switchBtn = new Button();
        switchBtn.setPrefWidth(40);
        switchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switchedON.set(!switchedON.get());
                try {
                    stopwatch.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        setGraphic(switchBtn);
        SwitchButtonOn(stopwatch, data);
        //button listener
        return time;
    }

    public long countTimeInSeconds() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i <5; i++) {
            Thread.sleep(60);
        }
        return start;
    }

    public void SwitchButtonOn(Stopwatch stopwatch, ObservableList<TimeTable> data){
        //DateAndTime printTime = new DateAndTime();

        switchedON.addListener(new ChangeListener<Boolean>() {
            long createdMillis = System.currentTimeMillis();

            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                active = true;
                try {
                    timeValue = countTimeInSeconds();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (t1) {

                    System.out.println("System ON");

//                    System.out.println(timeInSeconds.getAgeInSeconds(time));
                    setText("Clock IN");
                    setStyle("-fx-background-color: green;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.RIGHT);
//                    timeValue2 = stopwatch.getTimeInSeconds(timeValue);
                }

                else {
                    setText("Clock OUT");
                    setStyle("-fx-background-color: red;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.LEFT);
                    Stopwatch test = new Stopwatch();
                    if (time > 0){
//                        data.add(new TimeTable(stopwatch.printTime(),String.valueOf(sample.Stopwatch.sec)));
                        timeValue = System.currentTimeMillis();
                        data.add(new TimeTable(stopwatch.printTime(),String.valueOf(getTimeInSeconds(timeValue))));
                    }
                    time++;
                    stopwatch.reset();
                    stopwatch.countTime();
                    System.out.println("System OFF");
                    createdMillis = System.currentTimeMillis();
                }
            }
        });
        switchedON.set(false);
    }
    public void PrintTime() {
//        data.add(new TimeTable(stopwatch.printTime(),String.valueOf(sample.Stopwatch.sec)));
    }
    public SimpleBooleanProperty switchOnProperty() {
        return switchedON;
    }
}
