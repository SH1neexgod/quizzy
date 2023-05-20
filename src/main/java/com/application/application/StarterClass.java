package com.application.application;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class StarterClass extends Application {

    @Override
    public void start(Stage primaryStage) {

        Image image = new Image("logoTy.png");
        ImageView imageView = new ImageView(image);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), imageView);
        fadeTransition.setFromValue(0.3);
        fadeTransition.setToValue(1.0);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(3), imageView);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.3);
        scaleTransition.setToY(1.3);

        StackPane root = new StackPane(imageView);
        root.setStyle("-fx-background-color: black;");

        fadeTransition.play();
        scaleTransition.play();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root, 1200, 720);
        primaryStage.setScene(scene);
        primaryStage.show();

        fadeTransition.setOnFinished(event -> {

            HelloApplication app = new HelloApplication();
            try {
                app.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            primaryStage.close();
        });
    }

    public  void ShowAnimation()
    {

    }

}
