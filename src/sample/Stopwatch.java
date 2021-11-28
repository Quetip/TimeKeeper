package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.util.Duration;

import javax.management.timer.Timer;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.util.Date;

/**
 * Stop watch powered by JavaFX.
 *
 * <pre>
 * final Stopwatch stopwatch = new Stopwatch();
 * stopwatch.setTextFill(Color.NAVY);
 * stopwatch.setStyle("-fx-font-size: 2em;");
 * final Button reset = new JFXButton("Reset");
 * reset.setOnAction(eve -> {stopwatch.reset();});
 * new HBox().getChildren().addAll(stopwatch, reset);
 * </pre>
 *
 *
 *
 */
public class Stopwatch extends Button {

    private Timeline timeline;
    private final StringProperty timeSeconds = new SimpleStringProperty();
    private Duration time = Duration.ZERO;
    private boolean active;
    private int remainingTime = 0;
    public String countTime;
    public TimeTable returnTime;
    Timer timer  = new Timer();
    double subTotalTime;
    static public float sec = 0;
    float timeTotal = 0;
    long nowMillis = System.currentTimeMillis();
    Date startDate = new Date();
    long timeValue;

    public Stopwatch() {
        this.textProperty().bind(timeSeconds);
        this.setOnAction(eve -> {
            try {
                start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        reset();
    }

    public float getTimeInSeconds(long start){
        long end = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        sec = (end - start) / 1000F;
//        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");
        timeTotal += sec;
        System.out.println("Total time in Seconds: " + timeTotal);
        sec = System.currentTimeMillis();
        return sec;
    }

    public long countTimeInSeconds() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i <5; i++) {
            Thread.sleep(60);
        }
        return start;
    }
    /**
     * duration to text.
     * @param //duration
     * @return
     */
    private String makeText(final Duration duration) {
        return String.format("%02d:%02d:%02d:%02d",
                (long) (duration.toHours() % 60.0),
                (long) (duration.toMinutes() % 60.0),
                (long) (duration.toSeconds() % 60.0),
                (long) (duration.toMillis() % 60.0));
//           + (active ? "▶" : "■"
    }

    public String printTime() {
        return countTime;
    }

    public int countTime() {
        new KeyFrame(Duration.millis(100),
                e2 -> {
                    final Duration duration = ((KeyFrame) e2.getSource()).getTime();
                    remainingTime = (int) (duration.toSeconds() % 60.0);
                    System.out.println("remaining Time = " + remainingTime);;
                });
        return remainingTime;
    }

    /**
     * reset timer.
     */
    public void reset() {
        time = Duration.ZERO;
        timeSeconds.set(makeText(time));
    }

    public float exportTime(float time) {

        return time;
    }
    public boolean isActive() {

        return active;
    }

    public void start() throws InterruptedException { //throws due to millis counter
        if (active) {
            System.out.println(countTime);
            timer.stop();

            timeline.stop();
            active = false;
            timeSeconds.set(makeText(time));
            getTimeInSeconds(timeValue);

            timeValue = System.currentTimeMillis();
            return;
        }

        active = true;
        timeValue = countTimeInSeconds();
        if (timeline == null) {
            timer.start();
            timeline = new Timeline(
                new KeyFrame(Duration.millis(100),
                e2 -> {
                    if (!active) {
                        return;
                    }
                    final Duration duration = ((KeyFrame) e2.getSource()).getTime();
                    remainingTime = (int) (duration.toSeconds() % 60.0);
                    time = time.add(duration);
                    countTime = makeText(time);
                    timeSeconds.set(makeText(time));
//                    Float.valueOf(String.valueOf(timeSeconds));
                })
            );
        }
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
//    @author Toast kid
}
