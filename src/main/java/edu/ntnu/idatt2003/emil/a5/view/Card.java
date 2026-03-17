package edu.ntnu.idatt2003.emil.a5.view;

import edu.ntnu.idatt2003.emil.a5.model.poker.PlayingCard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public class Card extends StackPane {
  public Card(PlayingCard card) {
    ImageView cardPNG = new ImageView(
        new Image(Objects.requireNonNull(getClass().getResourceAsStream(
            "/PNG-cards/" + card.getAsString() + ".png"
        )))
    );

    cardPNG.setSmooth(true);
    cardPNG.setFitHeight(200);
    cardPNG.setPreserveRatio(true);

    getChildren().add(cardPNG);
  }
}
