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
    //time fields
    private Timeline timeline;
    private Label timerLabel = new Label(), splitTimerLabel = new Label();
    private DoubleProperty timeSeconds = new SimpleDoubleProperty(),
            splitTimeSeconds = new SimpleDoubleProperty();
    private Duration time = Duration.ZERO, splitTime = Duration.ZERO;

    //method
    public void Timer1(){
        //button
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
                    setText("Clock ON");
                    setStyle("-fx-background-color: green;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.RIGHT);
                    splitTime = Duration.ZERO;
                    splitTimeSeconds.set(splitTime.toSeconds());
                    System.out.println("test");

                }
                else {
                    setText("Clock OFF");
                    setStyle("-fx-background-color: red;-fx-text-fill:white;");
                    setContentDisplay(ContentDisplay.LEFT);
                    System.out.println("test1");
//                    timeline = new Timeline(new KeyFrame(
//                            Duration.millis(1000), new EventHandler<ActionEvent>() {
//                        @Override
//                        public void handle(ActionEvent actionEvent) {
//                            Duration duration = ((KeyFrame) actionEvent.getSource()).getTime();
//                            time = time.add(duration);
//                            splitTime = splitTime.add(duration);
//                            timeSeconds.set(time.toSeconds());
//                            splitTimeSeconds.set(splitTime.toSeconds());
//                        }
                }
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();
            }
        });
        switchedON.set(false);
        TextArea textField = new TextArea();
        textField.setBounds(20, 20, 300, 30);
        Text info = new Text(20, 39, "timerLabel");
        //display
//        StackPane root = new StackPane();
//        Scene scene = new Scene(root, 300, 300);
//        VBox vb = new VBox(20);
//        vb.setAlignment(Pos.CENTER);
//        vb.setPrefWidth(scene.getWidth());
//        vb.setLayoutY(30);
//        vb.getChildren().add(vb);
//
//        primaryStage.setTitle("timer");
//        primaryStage.setScene(scene);
//        primaryStage.show();

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
