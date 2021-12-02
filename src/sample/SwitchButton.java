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
    long timeValue = 0;
    float timeValue2;
    long timeTotal = 0;
    static public float sec = 0;

    public float getTimeInSeconds(long start){
        long end = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        sec = (end - start) / 1000F;
        System.out.println(sec + " seconds (Switch Button)");

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
        System.out.println("start time = " + start);
        return start;
    }

    public void SwitchButtonOn(Stopwatch stopwatch, ObservableList<TimeTable> data){
        //DateAndTime printTime = new DateAndTime();

        switchedON.addListener(new ChangeListener<Boolean>() {
            private long timeValue;

//            long createdMillis = System.currentTimeMillis();
            for (int i = 0; i <5; i++) {
                try {
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
//                active = true;
                long createdMillis = System.currentTimeMillis();

//                try {
//                    timeValue = 0;
//                    timeValue = countTimeInSeconds();
//                    System.out.println("test");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


//                timeValue = System.currentTimeMillis();
                if (t1) {

                    System.out.println("System ON");

//                    System.out.println(timeInSeconds.getAgeInSeconds(time));
                    setText("Clock IN");
                    setStyle("-fx-background-color: green;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.RIGHT);
//                    getTimeInSeconds(timeValue);

                    return;
                }

                else {


                    if (time > 0){
//                        data.add(new TimeTable(stopwatch.printTime(),String.valueOf(sample.Stopwatch.sec)));
                    }
                    time++;
//                    stopwatch display
                    stopwatch.reset();
                    stopwatch.countTime();
                    System.out.println("System OFF");
                    long nowMillis = System.currentTimeMillis();
                    System.out.println("test " + (int)((nowMillis - this.timeValue) / 1000));
                    createdMillis = System.currentTimeMillis();
                    timeValue = System.currentTimeMillis();
                    data.add(new TimeTable(stopwatch.printTime(),String.valueOf(getTimeInSeconds(timeValue))));

                    System.out.println("Time Value = " + timeValue);
                    //                    display
                    setText("Clock OUT");
                    setStyle("-fx-background-color: red;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.LEFT);
                }
            }
        });
        switchedON.set(false);
    }
    public SimpleBooleanProperty switchOnProperty() {
        return switchedON;
    }
}
