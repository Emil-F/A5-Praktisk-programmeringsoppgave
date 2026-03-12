package edu.ntnu.idatt2003.emil.a5.model.hand;

import edu.ntnu.idatt2003.emil.a5.model.PlayingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Hand {
  private static final Logger logger = Logger.getLogger(Hand.class.getName());
  private List<PlayingCard> cards;
  private final char[] suit = {'S', 'H', 'D', 'C'};

  public Hand() {
    this.cards = new ArrayList<>();
  }

  @Override
  public String toString() {
    StringBuilder handString = new StringBuilder();
    handString.append("Hand: [");
    for (int i = 0; i < this.cards.size(); i++) {
      if (i == this.cards.size() - 1) {
        handString.append(this.cards.get(i).getAsString());
        continue;
      }
      handString.append(this.cards.get(i).getAsString()).append(", ");
    }
    handString.append("]");
    return handString.toString();
  }

  public List<PlayingCard> getCards() {
    return cards;
  }

  public void setCards(List<PlayingCard> cards) {
    this.cards = cards;
  }

  /**
   * <p>Calculates the hand's total card value</p>
   *
   * @param communityCards cards shared by all the players in the game.
   * @return the hand's total card value as an {@link Integer}
   */
  public int calculateCardTotal(List<PlayingCard> communityCards) {
    Objects.requireNonNull(communityCards, "communityCards is null");

    AtomicInteger cardTotal = new AtomicInteger();
    cards.forEach(card -> {
      cardTotal.addAndGet(card.getFace());
    });
    communityCards.forEach(card -> {
      cardTotal.addAndGet(card.getFace());
    });
    return cardTotal.get();
  }

  /**
   * <p>
   * Goes through all possible combinations of a poker hand and
   * determines if the current hand possesses cards with one of
   * the following combinations:
   * </p>
   *
   * <li>Royal Flush</li>
   * <li>Straight Flush</li>
   * <li>Four of a Kind</li>
   * <li>Full House</li>
   * <li>Straight</li>
   * <li>Three of a Kind</li>
   * <li>Two Pairs</li>
   * <li>One Pair</li>
   * <li>High Card</li>
   *
   * @param communityCards cards shared by all the players in the game.
   * @return the hands total card value and its combinations as a {@link HandCheckResult}.
   */
  public HandCheckResult checkHand(List<PlayingCard> communityCards) {
    Objects.requireNonNull(communityCards, "communityCards is null");

    List<HandRank> ranks = new ArrayList<>();
    if (hasRoyalFlush(communityCards)) {
      ranks.add(HandRank.ROYAL_FLUSH);
    }
    if (hasStraightFlush(communityCards)) {
      ranks.add(HandRank.STRAIGHT_FLUSH);
    }
    if (hasFourOfAKind(communityCards)) {
      ranks.add(HandRank.FOUR_OF_A_KIND);
    }
    if (hasFullHouse(communityCards)) {
      ranks.add(HandRank.FULL_HOUSE);
    }
    if (hasFlush(communityCards)) {
      ranks.add(HandRank.FLUSH);
    }
    if (hasStraight(communityCards)) {
      ranks.add(HandRank.STRAIGHT);
    }
    if (hasThreeOfAKind(communityCards)) {
      ranks.add(HandRank.THREE_OF_A_KIND);
    }
    if (hasTwoPairs(communityCards)) {
      ranks.add(HandRank.TWO_PAIRS);
    }
    if (hasOnePair(communityCards)) {
      ranks.add(HandRank.ONE_PAIR);
    }
    if (ranks.isEmpty()) {
      ranks.add(HandRank.HIGH_CARD);
    }

    return new HandCheckResult(calculateCardTotal(communityCards), ranks);
  }

  protected boolean hasRoyalFlush(List<PlayingCard> communityCards) {

    return false;
  }

  protected boolean hasStraightFlush(List<PlayingCard> communityCards) {
    return false;
  }

  protected boolean hasFourOfAKind(List<PlayingCard> communityCards) {
    return false;
  }

  protected boolean hasFullHouse(List<PlayingCard> communityCards) {
    return false;
  }

  protected boolean hasFlush(List<PlayingCard> communityCards) {
    for(char s: suit) {
      long count = cards.stream().filter(card -> card.getSuit() == s).count();
      if (count >= 5) {
        return true;
      }
    }
    return false;
  }

  protected boolean hasStraight(List<PlayingCard> communityCards) {
    return false;
  }

  protected boolean hasThreeOfAKind(List<PlayingCard> communityCards) {
    return false;
  }

  protected boolean hasTwoPairs(List<PlayingCard> communityCards) {
    return false;
  }

  protected boolean hasOnePair(List<PlayingCard> communityCards) {
    return false;
  }
}
