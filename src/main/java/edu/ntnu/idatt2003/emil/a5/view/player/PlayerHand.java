package edu.ntnu.idatt2003.emil.a5.view.player;

import edu.ntnu.idatt2003.emil.a5.controller.PokerController;
import edu.ntnu.idatt2003.emil.a5.model.poker.PlayingCard;
import edu.ntnu.idatt2003.emil.a5.view.Card;
import javafx.collections.ListChangeListener;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class PlayerHand extends StackPane {
  private final PokerController controller;
  private final HBox cards = new HBox();

  public PlayerHand(PokerController pokerController) {
    this.controller = pokerController;

    getStylesheets().add(
        getClass().getResource("/css/PlayerHand.css").toExternalForm()
    );

    cards.setId("cards");
    cards.setSpacing(15);
    cards.setAlignment(Pos.CENTER);

    getChildren().add(cards);

    setId("player_hand");
    setAlignment(Pos.CENTER);

    // Initial render
    refreshCards();
    // Automatic updates
    controller.getObsPlayerCards().addListener(
        (ListChangeListener<PlayingCard>) change -> refreshCards()
    );
  }

  public void refreshCards() {
    cards.getChildren().clear();

    for (PlayingCard card : controller.getObsPlayerCards()) {
      cards.getChildren().add(new Card(card));
    }
  }
}
