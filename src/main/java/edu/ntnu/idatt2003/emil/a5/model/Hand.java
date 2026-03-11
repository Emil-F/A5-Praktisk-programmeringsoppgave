package edu.ntnu.idatt2003.emil.a5.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
  private List<PlayingCard> cards;
  private final char[] suit = {'S', 'H', 'D', 'C'};

  public Hand() {
    this.cards = new ArrayList<>();
  }

  public List<PlayingCard> getCards() {
    return cards;
  }

  public void setCards(List<PlayingCard> cards) {
    this.cards = cards;
  }

  public String checkHand(List<PlayingCard> communityCards) {
    if (hasFlush(communityCards)) {
      return "Flush";
    }
    return "No combination found";
  }

  private boolean hasRoyalFlush(List<PlayingCard> communityCards) {
    return false;
  }

  private boolean hasStraightFlush(List<PlayingCard> communityCards) {
    return false;
  }

  private boolean hasFourOfAKind(List<PlayingCard> communityCards) {
    return false;
  }

  private boolean hasFullHouse(List<PlayingCard> communityCards) {
    return false;
  }

  private boolean hasFlush(List<PlayingCard> communityCards) {
    for(char s: suit) {
      long count = cards.stream().filter(card -> card.getSuit() == s).count();
      if (count >= 5) {
        return true;
      }
    }
    return false;
  }

  private boolean hasStraight(List<PlayingCard> communityCards) {
    return false;
  }

  private boolean hasThreeOfAKind(List<PlayingCard> communityCards) {
    return false;
  }

  private boolean hasTwoPairs(List<PlayingCard> communityCards) {
    return false;
  }

  private boolean hasOnePair(List<PlayingCard> communityCards) {
    return false;
  }
}
