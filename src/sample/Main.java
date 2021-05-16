package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Main extends Application {
    private TableView table = new TableView();

    public int count = 0, test = 0;

//    public Main(int count) {
//        this.count = count;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Time Keeper");
        Group root = new Group();

        //child button
        Button button = new Button("Clock In");
        button.setTranslateX(250);
        button.setTranslateY(20);

//        Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//
//                if (count%2 == 0) {
//
//                    int timer = 0;
////                        Timer1 dim = new Timer1();
////                        dim.counter();
////                        System.out.println(dim.counter(timer));
////                        Timer time = new (22);
//                    while (timer < 1000 || count % 2 == 0) {
//                        timer++;
//                        System.out.println(timer);
//                        try {
//                            TimeUnit.SECONDS.sleep(1);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                }}
//        }));
//        timeLine.setCycleCount(Timeline.INDEFINITE);
//        timeLine.play();

//        root.getChildren().add(button);
//        Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(1),
//                e -> {
//
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException x) {
//                        x.printStackTrace();
//                    }
//                }
//        ));
        SwitchButton test = new SwitchButton();
        test.Timer1();
        test.setTranslateX(250);
        test.setTranslateY(40);

        button.setOnAction(new EventHandler<ActionEvent>() {
                private final long createdMillis = System.currentTimeMillis();

                @Override
                public void handle(ActionEvent actionEvent) {
                    count++;
                    System.out.println(count%2 == 0);
                    long nowMillis = System.currentTimeMillis();
                    nowMillis = nowMillis - ((this.createdMillis) / 1000);

                    if (count%2 == 0) {

                        int timer = 0;
//                        here:
//                        Timer1 dim = new Timer1();
//                        dim.counter();
//                        System.out.println(dim.counter(timer));
//                        Timer time = new (22);
                        Button button = new Button("Clock Out");
                        button.setTranslateX(250);
                        button.setTranslateY(40);
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                System.exit(0);
                            }
                        });
                        while (count%2 == 0) {
//                            if () {
//                                break;
//                            }

                            System.out.println("timer");
                            timer++;
                            System.out.println(timer);
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        System.out.println("test");

                    } else {
//                        count++;
                        System.out.println("test1");
                    }
//                    System.exit(0);
//                    return;
    //                System.out.println(nowMillis);
    //                int count = 0;
    //                count++;
    //                System.out.println(count);
    //                Date startDate = new Date();
    //                Date endDate = new Date();
    //                int numSeconds = 0;
    //                boolean turnOff = false;
    //
    //                while (turnOff = true) {
    //                    numSeconds = (int)((endDate.getTime() - startDate.getTime()) / 1000);
    //                    System.out.println(numSeconds);
    //
    //                }
    //
    //                Text counter = new Text(50, 30, "" + numSeconds + "");
    //                Group root1 = new Group(counter);
    //                primaryStage.setScene(new Scene(root1));
    //                primaryStage.show();
    //                handle(table);
                    }

                }
        );

//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                count = 0;
//                System.out.println(count);
//            }
//        });

//        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("Hello World!");
//            }
//        });
//        //Table
//        final Label label = new Label("Address Book");
////        label.setFont("Arial", 20);

//        table.setEditable(true);
//        TableColumn tableDay = new TableColumn("Day");
//        TableColumn tableClockIn = new TableColumn("Clock In");
//        TableColumn tableClockOut = new TableColumn("Clock Out");
//
//        table.getColumns().addAll(tableDay, tableClockIn, tableClockOut);
//
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        Insets insets = new Insets(4);
//        vbox.setPadding(insets);

        //child button
//        Button button2 = new Button("Clock Out");
//        button2.setTranslateX(250);
//        button2.setTranslateY(100);
//        System.out.println("exit test");
        TextArea textField = new TextArea();
        textField.setBounds(20, 20, 300, 30);
        Text info = new Text(20, 39, "Clock in/out.");
        info.setFont(Font.font("Verdana", 20));
        info.setFill(Color.WHITE);
//        info.set;
//        textField.on

//        Group root2 = new Group(textField);

        Group root1 = new Group(button, info, test);

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

