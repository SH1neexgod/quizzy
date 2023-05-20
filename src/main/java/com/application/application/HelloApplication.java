package com.application.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Timer;
import java.util.TimerTask;

import java.sql.ResultSet;

public class HelloApplication extends Application {

 @Override
 public void start(Stage stage) throws Exception {


  Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));

  SceneController sceneC = new SceneController();
  sceneC.LoadMainMenu();

  stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("/logo.png")));
  stage.initStyle(StageStyle.UNDECORATED);
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
}
