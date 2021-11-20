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

    /** timeline. */
    private Timeline timeline;
    long someTime;
    /** String property. */
    private final StringProperty timeSeconds = new SimpleStringProperty();

    /** contanis duration. */
    private Duration time = Duration.ZERO;

    /** this timer is active. */
    private boolean active;

    private int remainingTime = 0;
    //private int incrementTime = 0;
    private SwitchButton callTime = new SwitchButton();

    /** print time **/

    public String countTime;
    public TimeTable returnTime;
//    CountTimeInMilis timeCount = new CountTimeInMilis();

    private long startTime  = System.currentTimeMillis();
    Timer timer  = new Timer();
    double subTotalTime;

    float timeTotal = 0;
    /**
     * initialize this component.
     */
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
    /**
     * start count up.
     */
    private long createdMillis = System.currentTimeMillis();
    long nowMillis = System.currentTimeMillis();
    Date startDate = new Date();
    long timeValue;

    public float getTimeInSeconds(long start){
        long end = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");

        timeTotal += sec;
        System.out.println("Total time in Seconds: " + timeTotal);
        end = System.currentTimeMillis();
        start = System.currentTimeMillis();
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

    public void start() throws InterruptedException {
//        TimeTable timeTime = new TimeTable();

        //long nanTime1 = System.nanoTime();
        if (active) {
            //System.out.println(timeCount.createdMillis);
            System.out.println(countTime);
            timer.stop();
            long endTime = System.currentTimeMillis();
//            long timeInMilliseconds = (endTime - startTime);
            Date endDate = new Date();
            int numSeconds = (int)((endDate.getTime() - startDate.getTime()) / 1000);

            //int subTotalTimes = );
//            System.out.println("time in seconds?: " + ((int)((nowMillis - this.createdMillis) / 1000))/3);

            System.out.println("time in milis?: " + ((endTime - startTime) / 1000F)%2);
//            subTotalTime += timeInMilliseconds / 1000;
            System.out.println("Subtotaled time: " + subTotalTime);
//            timeCount.getAgeInSeconds();
            createdMillis = System.currentTimeMillis();
            startTime = System.currentTimeMillis();
//            System.out.println("hmm: " + timeCount.getAgeInSeconds());
            timeline.stop();
            active = false;
            timeSeconds.set(makeText(time));
//            timeSeconds.get();
//            Integer output = Integer.parseInt(timeSeconds));
//            System.out.println("The integer of a string input is: " + timeSeconds.get());
//            AddUpMillis(timeSeconds.get());
            getTimeInSeconds(timeValue);

            timeValue = System.currentTimeMillis();
            return;
        }

        active = true;
        timeValue = countTimeInSeconds();
        if (timeline == null) {
            timer.start();
//            timeCount.getAgeInSeconds();

            //System.out.println("Nano Time = " + (System.nanoTime() / 1000));
            //timeCount.startTimer();
            timeline = new Timeline(
                new KeyFrame(Duration.millis(100),
                e2 -> {
                    if (!active) {
                        return;
                    }
                    final Duration duration = ((KeyFrame) e2.getSource()).getTime();
                    remainingTime = (int) (duration.toSeconds() % 60.0);
                    //System.out.println(remainingTime);
                    time = time.add(duration);
                    //int getTime = Duration.seconds(time);
                    countTime = makeText(time);
                    timeSeconds.set(makeText(time));
                })
            );

//            System.out.println("is this running?");
        }
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
//    public String getTime() {
////        this.countTime;
//        return countTime;
//    }

    /**
     * duration to text.
     * @param //duration
     * @return
     */

    private String makeText(final Duration duration) {
//        long timeout = System.currentTimeMillis() + (remainingTime * 1000);
//        System.out.println((timeout - System.currentTimeMillis()) / 1000);
        //long integerTime = (long) (duration.toSeconds() % 60.0);

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
        int countTime = -1;

        new KeyFrame(Duration.millis(100),
            e2 -> {
                final Duration duration = ((KeyFrame) e2.getSource()).getTime();
                remainingTime = (int) (duration.toSeconds() % 60.0);
//                    remainingTime = remainingTime + 100;
                System.out.println("remaining Time = " + remainingTime);;
                //callTime.getTotalTime(remainingTime);
                //incrementTime += remainingTime;
                //System.out.println(remainingTime);
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

    /**
     * get is active.
     * @return active(boolean)
     */
    public boolean isActive() {

        return active;
    }
//    @author Toast kid
}
