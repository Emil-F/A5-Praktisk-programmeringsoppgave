package edu.ntnu.idatt2003.emil.a5.model;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
  private final char[] suit = {'S', 'H', 'D', 'C'};
  private final List<PlayingCard> cards;

  public DeckOfCards() {
    cards = new ArrayList<>();
    int face = 1;
    int index = 0;

    for(int n = 0; n < 52; n++) {
      if (face > 13) {
        face = 1;
        index++;
      }
      cards.add(new PlayingCard(suit[index], face));
      face++;
    }

    if (cards.size() > 52) {
      throw new IllegalArgumentException("Deck of Cards can't have more than 52 suits");
    }

    if (cards.size() < 52) {
      throw new IllegalArgumentException("Deck of Cards can't have less than 52 suits");
    }
  }

  public char[] getSuit() {
    return suit;
  }

  public List<PlayingCard> getCards() {
    return cards;
  }
}
