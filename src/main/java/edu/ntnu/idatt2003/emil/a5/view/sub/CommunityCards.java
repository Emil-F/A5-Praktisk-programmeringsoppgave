package edu.ntnu.idatt2003.emil.a5.view.sub;

import edu.ntnu.idatt2003.emil.a5.controller.PokerController;
import edu.ntnu.idatt2003.emil.a5.model.PlayingCard;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CommunityCards extends StackPane {
  private final PokerController controller;
  private final ListView<PlayingCard> communityCards = new ListView<>();
  private final HBox cards = new HBox();

  public CommunityCards(PokerController pokerController) {
    this.controller = pokerController;
    communityCards.setItems(controller.getCommunityCards());

    getStylesheets().add(getClass().getResource("/css/CommunityCards.css").toExternalForm());

    cards.setId("cards");
    cards.setSpacing(15);
    cards.setAlignment(Pos.CENTER);

    refreshCards();

    controller.getCommunityCards().addListener((javafx.collections.ListChangeListener<PlayingCard>) c -> {
      refreshCards();
    });

    getChildren().add(cards);

    setId("community_cards");
    setAlignment(Pos.CENTER);
  }

  public ListView<PlayingCard> getListView() {
    return communityCards;
  }

  public void refreshCards() {
    cards.getChildren().clear();
    for (PlayingCard card : controller.getCommunityCards()) {
      cards.getChildren().add(createCard(card.getAsString()));
    }
  }

  public StackPane createCard(String text) {
    StackPane frame = new StackPane();
    Rectangle card = new Rectangle();
    Text txt = new Text(text);
    card.setId("card");
    card.setWidth(50);
    card.setHeight(50);
    frame.getChildren().addAll(card, txt);
    return frame;
  }
}
