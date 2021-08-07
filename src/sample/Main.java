package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.TextArea;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Main extends Application {
    public int count = 0, switchButton = 0;
    private Stopwatch getTime;
    private final TableView<TimeTable> table = new TableView<>();
    private final ObservableList<TimeTable> data =
            FXCollections.observableArrayList(new TimeTable("A", "B"));
    final HBox hb = new HBox();

    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Time Keeper");

        //text
        TextArea textField = new TextArea();
        textField.setBounds(20, 20, 300, 30);
        Stopwatch timeText = new Stopwatch();
        Text info = new Text(20, 39, timeText.countTime);
        info.setFont(Font.font("Verdana", 20));
        info.setFill(Color.WHITE);

        //time counter
        final Stopwatch stopwatch = new Stopwatch();
        stopwatch.setTextFill(Color.BLACK);
        stopwatch.setStyle("-fx-font-size: 4em;");
        stopwatch.setTranslateX(0);
        stopwatch.setTranslateY(50);
        stopwatch.setOnMouseClicked(null);
        stopwatch.setMouseTransparent(true);
        //stopwatch start
        int test = 0;

        //switch button
        SwitchButton switchButton = new SwitchButton();

        System.out.println(test);
        switchButton.switchOnProperty();
        switchButton.setTranslateX(250);
        switchButton.setTranslateY(40);

//        switchButton.setTranslateZ(40);

        //table
        //TableView table = new TableView();
        Stopwatch newWatch = new Stopwatch();

        //set table columns
        TableColumn firstNameCol = new TableColumn("Time");

        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol);

//        final Button addButton = new Button("Add");
//        addButton.setOnAction((ActionEvent e) -> {
//            data.add(new Person("Z","X"));
//        });
        test = switchButton.Timer1(stopwatch, data);
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            newWatch.start();
            //switchButton.switchOnProperty();
            data.add(new TimeTable(newWatch.printTime(),"X"));
        });
//
        hb.getChildren().addAll(addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hb);

        //add columns to the table


//        VBox vbox = new VBox(tableView);


        //Scene
        primaryStage.setScene(new Scene(new HBox(stopwatch), 320, 100));

        primaryStage.setResizable(false);

        Label countUp = new Label();
        countUp.setTranslateX(30);
        countUp.setTranslateY(70);

        Group root1 = new Group(info, switchButton, countUp, stopwatch, table, vbox);

        primaryStage.setScene(new Scene(root1, 600, 900, Color.GRAY));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

}

