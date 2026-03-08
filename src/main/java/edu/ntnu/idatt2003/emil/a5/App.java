package edu.ntnu.idatt2003.emil.a5;

import edu.ntnu.idatt2003.emil.a5.controller.GameController;
import edu.ntnu.idatt2003.emil.a5.view.MainView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {
  private BorderPane root;

  @Override
  public void start(Stage stage) throws Exception {
    GameController gameController = new GameController();
    MainView mainView = new MainView(gameController);
    Scene scene = new Scene(mainView, 1280, 720);

    try {
      Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.jpg"), "Icon cannot be null"));
      stage.getIcons().add(icon);
    } catch (NullPointerException e) {
      System.err.println("Exception message: " + e.getMessage());
    }

    stage.setTitle("Card Game");
    stage.setScene(scene);
    stage.show();
  }

  static void main(String[] args) {
    launch(args);
  }
}
