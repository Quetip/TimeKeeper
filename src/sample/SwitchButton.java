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
//    private Stopwatch stopwatch = new Stopwatch();
    int time = 0;
//    private int countTime = 0;
//CountTimeInMilis timeCount = new CountTimeInMilis();


    public int Timer1(Stopwatch stopwatch, ObservableList<TimeTable> data){
        //button
        //TimeTable updateTime = new TimeTable();
        Button switchBtn = new Button();
        switchBtn.setPrefWidth(40);
        switchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                //                CountTime timeCount = new CountTime();
                switchedON.set(!switchedON.get());
                try {
                    stopwatch.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //time = stopwatch.countTime();
            }
        });
        setGraphic(switchBtn);
        SwitchButtonOn(stopwatch, data);
        //button listener
        return time;
    }

    public void SwitchButtonOn(Stopwatch stopwatch, ObservableList<TimeTable> data){
        //DateAndTime printTime = new DateAndTime();

        switchedON.addListener(new ChangeListener<Boolean>() {
            long createdMillis = System.currentTimeMillis();

            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                long start = System.nanoTime();
                if (t1) {

                    //System.out.println("date = " + printTime.StartTime());
                    //printTime.StartTime();

                    System.out.println("System ON");

//                    System.out.println(timeInSeconds.getAgeInSeconds(time));
                    setText("Clock IN");
                    setStyle("-fx-background-color: green;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.RIGHT);
                }
                else {
                    setText("Clock OUT");
                    setStyle("-fx-background-color: red;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.LEFT);
                    if (time > 0){
                        data.add(new TimeTable(stopwatch.printTime(),"X"));
                    }
                    time++;
                    stopwatch.reset();
                    stopwatch.countTime();
                    //System.out.println("time = " + time);
                    System.out.println("System OFF");
                    long nowMillis = System.currentTimeMillis();
                    // finding the time after the operation is executed
                    long end = System.currentTimeMillis();
                    //finding the time difference and converting it into seconds
                    float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
//                    System.out.println("Count in sec" + (int)((nowMillis - this.createdMillis) / 1000));
                    createdMillis = System.currentTimeMillis();

//                    timeCount.getAgeInSeconds();
                }
            }
        });
        switchedON.set(false);
    }

//    public void getTotalTime(int time){
//        countTime += time;
//        System.out.println("Time = " + countTime);
//        //data.add(new TimeTable(stopwatch.printTime(),"X"));
//    }

    public SimpleBooleanProperty switchOnProperty() {
        return switchedON;
    }
}
