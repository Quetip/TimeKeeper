package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Time Keeper");


        Button button = new Button("Clock In");
        button.setTranslateX(500);
        button.setTranslateY(20);

        Button button2 = new Button("Clock Out");
        button2.setTranslateX(500);
        button2.setTranslateY(100);

        TextArea textField = new TextArea();
        textField.setBounds(20, 20, 300, 30);

//        Group root2 = new Group(textField);

        Group root1 = new Group(button, button2);

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

