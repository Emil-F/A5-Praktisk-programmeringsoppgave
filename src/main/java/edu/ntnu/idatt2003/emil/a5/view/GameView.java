package edu.ntnu.idatt2003.emil.a5.view;

import edu.ntnu.idatt2003.emil.a5.App;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class GameView extends BorderPane {
  public GameView(App app) {
    setCenter(cards());
  }

  public HBox cards() {
    HBox cards = new HBox();
    for(int i = 0; i < 5; i++) {
      cards.getChildren().add(card());
    }
    cards.setSpacing(15);
    return cards;
  }

  public Rectangle card() {
    Rectangle card = new Rectangle();
    card.setId("card");
    getClass().getResource("/css/card.css").toExternalForm();
    card.setWidth(50);
    card.setHeight(50);
    return card;
  }
}
