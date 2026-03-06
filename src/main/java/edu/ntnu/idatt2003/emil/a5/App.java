package edu.ntnu.idatt2003.emil.a5;

import edu.ntnu.idatt2003.emil.a5.model.DeckOfCards;
import edu.ntnu.idatt2003.emil.a5.model.PlayingCard;

import java.util.List;

public class App {
  static void main(String[] args) {
    DeckOfCards deck = new DeckOfCards();
    List<PlayingCard> cards = deck.getCards();

    cards.forEach(card -> System.out.println(card.getAsString()));
  }
}
