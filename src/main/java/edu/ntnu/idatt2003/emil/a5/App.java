package edu.ntnu.idatt2003.emil.a5;

import edu.ntnu.idatt2003.emil.a5.model.DeckOfCards;
import edu.ntnu.idatt2003.emil.a5.model.Hand;
import edu.ntnu.idatt2003.emil.a5.view.GameView;
import edu.ntnu.idatt2003.emil.a5.view.HandView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {
  private BorderPane root;

  @Override
  public void start(Stage stage) throws Exception {
    root = new BorderPane();
    Scene scene = new Scene(root, 1280, 720);

    try {
      Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.jpg"), "Icon cannot be null"));
      stage.getIcons().add(icon);
    } catch (NullPointerException e) {
      System.err.println("Exception message: " + e.getMessage());
    }
    stage.setTitle("Card Game");
    stage.setScene(scene);
    stage.show();

    root.getChildren().add(new GameView(this));

    DeckOfCards deck = new DeckOfCards();
    Hand hand = new Hand();
    hand.setCards(deck.dealHand(5));
    hand.getCards().forEach(c -> System.out.println(c.getAsString()));
    System.out.println(hand.checkHand());
  }

  public void showHandView() {
    root.getChildren().setAll(new HandView(this));
  }

  static void main(String[] args) {
    launch(args);
  }
}
