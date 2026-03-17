package edu.ntnu.idatt2003.emil.a5.view.player;

import edu.ntnu.idatt2003.emil.a5.controller.PokerController;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PlayerInfo extends StackPane {
  private final PokerController controller;

  public PlayerInfo(PokerController controller) {
    this.controller = controller;
    getStylesheets().add(getClass().getResource("/css/PlayerInfo.css").toExternalForm());

    getChildren().addAll(
      createBody()
    );
  }

  private HBox createBody() {
    HBox hBox = new HBox();
    hBox.setAlignment(Pos.CENTER_LEFT);
    hBox.getChildren().addAll(
      createPanel()
    );
    return hBox;
  }

  private HBox createPanel() {
    HBox panel = new HBox();
    panel.setAlignment(Pos.CENTER_LEFT);
    panel.getStyleClass().add("info-box");
    panel.setSpacing(10);

    VBox infoName = new VBox();

    Label rankName = new Label("Hand Rank:");
    Label cardValueName = new Label("Hand Value:");
    Label winnerName = new Label("Winner:");
    Label winningHandName = new Label("Winning Hand:");

    VBox infoValue = new VBox();

    Label cardValue = new Label();
    cardValue.getStyleClass().add("info");
    cardValue.textProperty().bind(controller.getCurrentCardValue());

    Label rank = new Label();
    rank.textProperty().bind(controller.getCurrentRank());
    rank.getStyleClass().add("info");

    Label winner = new Label();
    winner.textProperty().bind(controller.getCurrentWinner());
    winner.getStyleClass().add("info");

    Label winningHand = new Label();
    winningHand.textProperty().bind(controller.getCurrentWinningHand());
    winningHand.getStyleClass().add("info");

    Label cardsOfHeartsName = new Label("Cards of Hearts:");
    Label heartCards = new Label();
    heartCards.textProperty().bind(controller.getCardsOfHearts());
    heartCards.getStyleClass().add("info");

    Label queenOfSpadesName = new Label("Queen of spades:");
    Label queenOfSpades = new Label();
    queenOfSpades.textProperty().bind(controller.getQueenOfSpades());
    queenOfSpades.getStyleClass().add("info");

    infoName.getChildren().addAll(
      rankName,
      cardValueName,
      winnerName,
      winningHandName,
      cardsOfHeartsName,
      queenOfSpadesName
    );

    infoValue.getChildren().addAll(
      rank,
      cardValue,
      winner,
      winningHand,
      heartCards,
      queenOfSpades
    );

    panel.getChildren().addAll(
      infoName,
      infoValue
    );
    return panel;
  }
}
