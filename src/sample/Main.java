package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Main extends Application {
    private TableView table = new TableView();

    public int count = 0, switchButton = 0;

    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Time Keeper");
        Group root = new Group();

        final Stopwatch stopwatch = new Stopwatch();
        stopwatch.setTextFill(Color.BLACK);
        stopwatch.setStyle("-fx-font-size: 4em;");
        stopwatch.setTranslateX(0);
        stopwatch.setTranslateY(50);

        //stopwatch start
//        final Button start = new Button("Start");
//        start.setOnAction(eve -> {
//            start.setText(stopwatch.isActive() ? "Start" : "Stop");
//            stopwatch.start();
//        });

        //stopwatch reset
//        final Button reset = new Button("Reset");
//        reset.setOnAction(eve -> {
//            stopwatch.reset();
//        });

        //switch button
        SwitchButton switchButton = new SwitchButton();
        switchButton.Timer1(stopwatch);
        switchButton.switchOnProperty();
        switchButton.setTranslateX(250);
        switchButton.setTranslateY(40);


        TextArea textField = new TextArea();
        textField.setBounds(20, 20, 300, 30);
        Text info = new Text(20, 39, "Clock in/out.");
        info.setFont(Font.font("Verdana", 20));
        info.setFill(Color.WHITE);



//        primaryStage.setScene(new Scene(new HBox(stopwatch, new VBox(start, reset)), 320, 100));
        primaryStage.setScene(new Scene(new HBox(stopwatch), 320, 100));

        primaryStage.setResizable(false);

        Label countUp = new Label();
        countUp.setTranslateX(30);
        countUp.setTranslateY(70);

//        countUp.setText(Integer.toString(countUpInt()));


//        root.getChildren().add(countUp);


//        TextArea textField1 = new TextArea();
//        textField1.setBounds(20, 20, 300, 30);
//        Text info1 = new Text(20, 39, test2);
//        info1.setFont(Font.font("Verdana", 20));
//        info1.setFill(Color.WHITE);
//        Group root2 = new Group(textField);

        Group root1 = new Group(info, switchButton, countUp, stopwatch);
//        root1.getChildren().add(countUp);
//        Scene scene = new Scene(root1, 20, 20, Color.GREEN);
//        primaryStage.setScene(scene);
        primaryStage.setScene(new Scene(root1, 600, 275, Color.GRAY));
//        primaryStage.show();
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println("Logs");
        launch(args);
    }

}

