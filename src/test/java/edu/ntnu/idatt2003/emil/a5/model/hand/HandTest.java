package edu.ntnu.idatt2003.emil.a5.model.hand;

import edu.ntnu.idatt2003.emil.a5.model.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

  Hand hand;

  @BeforeEach
  void setUp() {
    hand  = new Hand();
  }

  @Test
  void calculateCardTotal_ReturnsTheHandsTotalCardValue() {
  }

  @Test
  void checkHand() {
  }

  @Test
  void hasRoyalFlush_returnsTrueIfHandHasRoyalFlush() {
    List<PlayingCard> royalFlushHand = new ArrayList<>();

    royalFlushHand.add(new PlayingCard('S', 1));
    royalFlushHand.add(new PlayingCard('S', 10));
    royalFlushHand.add(new PlayingCard('S', 11));
    royalFlushHand.add(new PlayingCard('S', 12));
    royalFlushHand.add(new PlayingCard('S', 13));
    royalFlushHand.add(new PlayingCard('S', 2));
    royalFlushHand.add(new PlayingCard('S', 3));

    assertTrue(hand.hasRoyalFlush(royalFlushHand));
  }

  @Test
  void hasRoyalFlush_returnsFalseIfHandDoesNotHaveRoyalFlush() {
    List<PlayingCard> cards = new ArrayList<>();

    cards.add(new PlayingCard('S', 1));
    cards.add(new PlayingCard('S', 5));
    cards.add(new PlayingCard('S', 11));
    cards.add(new PlayingCard('S', 12));
    cards.add(new PlayingCard('S', 13));
    cards.add(new PlayingCard('D', 2));
    cards.add(new PlayingCard('C', 13));

    assertFalse(hand.hasRoyalFlush(cards));
  }

  @Test
  void hasRoyalFlush_returnsFalseIfCardsDontAllHaveTheSameSuit() {
    List<PlayingCard> cards = new ArrayList<>();

    cards.add(new PlayingCard('S', 1));
    cards.add(new PlayingCard('S', 10));
    cards.add(new PlayingCard('H', 11));
    cards.add(new PlayingCard('S', 12));
    cards.add(new PlayingCard('S', 13));
    cards.add(new PlayingCard('H', 13));
    cards.add(new PlayingCard('C', 13));

    assertFalse(hand.hasRoyalFlush(cards));
  }

  @Test
  void hasStraightFlush_returnsTrueIfHandHasStraightFlush() {
    List<PlayingCard> straightFlush = new ArrayList<>();

    straightFlush.add(new PlayingCard('S', 7));
    straightFlush.add(new PlayingCard('S', 8));
    straightFlush.add(new PlayingCard('S', 9));
    straightFlush.add(new PlayingCard('S', 10));
    straightFlush.add(new PlayingCard('S', 11));
    straightFlush.add(new PlayingCard('S', 1));
    straightFlush.add(new PlayingCard('S', 2));

    assertTrue(hand.hasStraightFlush(straightFlush));
  }

  @Test
  void hasStraightFlush_returnsFalseIfHandDoesNotHaveStraightFlush() {
    List<PlayingCard> cards = new ArrayList<>();

    cards.add(new PlayingCard('S', 7));
    cards.add(new PlayingCard('S', 2));
    cards.add(new PlayingCard('S', 9));
    cards.add(new PlayingCard('S', 10));
    cards.add(new PlayingCard('S', 11));
    cards.add(new PlayingCard('S', 5));
    cards.add(new PlayingCard('S', 4));

    assertFalse(hand.hasStraightFlush(cards));
  }

  @Test
  void hasStraightFlush_returnsFalseIfCardsDontAllHaveTheSameSuit() {
    List<PlayingCard> cards = new ArrayList<>();

    cards.add(new PlayingCard('S', 7));
    cards.add(new PlayingCard('S', 8));
    cards.add(new PlayingCard('H', 9));
    cards.add(new PlayingCard('S', 10));
    cards.add(new PlayingCard('S', 11));
    cards.add(new PlayingCard('S', 2));
    cards.add(new PlayingCard('S', 1));

    assertFalse(hand.hasStraightFlush(cards));
  }

  @Test
  void hasFourOfAKind_returnsTrueIfHandHasFourOfAKind() {
    List<PlayingCard> fourOfAKind = new ArrayList<>();

    fourOfAKind.add(new PlayingCard('S', 5));
    fourOfAKind.add(new PlayingCard('H', 5));
    fourOfAKind.add(new PlayingCard('D', 5));
    fourOfAKind.add(new PlayingCard('C', 5));
    fourOfAKind.add(new PlayingCard('C', 10));
    fourOfAKind.add(new PlayingCard('S', 11));
    fourOfAKind.add(new PlayingCard('S', 11));

    assertTrue(hand.hasFourOfAKind(fourOfAKind));
  }

  @Test
  void hasFourOfAKind_returnsFalseIfHandDoesNotHaveFourOfAKind() {
    List<PlayingCard> fourOfAKind = new ArrayList<>();

    fourOfAKind.add(new PlayingCard('S', 5));
    fourOfAKind.add(new PlayingCard('H', 5));
    fourOfAKind.add(new PlayingCard('D', 6));
    fourOfAKind.add(new PlayingCard('C', 5));
    fourOfAKind.add(new PlayingCard('C', 10));
    fourOfAKind.add(new PlayingCard('S', 11));
    fourOfAKind.add(new PlayingCard('S', 11));

    assertFalse(hand.hasFourOfAKind(fourOfAKind));
  }

  @Test
  void hasFullHouse_returnsTrueIfHandHasFullHouse() {}


  @Test
  void hasThreeOfAKind_returnsTrueIfHandHasThreeOfAKind() {
    List<PlayingCard> threeOfAKind = new ArrayList<>();

    threeOfAKind.add(new PlayingCard('S', 5));
    threeOfAKind.add(new PlayingCard('H', 5));
    threeOfAKind.add(new PlayingCard('D', 5));
    threeOfAKind.add(new PlayingCard('C', 9));
    threeOfAKind.add(new PlayingCard('C', 10));
    threeOfAKind.add(new PlayingCard('S', 11));
    threeOfAKind.add(new PlayingCard('S', 11));

    assertTrue(hand.hasThreeOfAKind(threeOfAKind));
  }

  @Test
  void hasThreeOfAKind_returnsFalseIfHandDoesNotHaveThreeOfAKind() {
    List<PlayingCard> threeOfAKind = new ArrayList<>();

    threeOfAKind.add(new PlayingCard('S', 5));
    threeOfAKind.add(new PlayingCard('H', 5));
    threeOfAKind.add(new PlayingCard('D', 6));
    threeOfAKind.add(new PlayingCard('C', 7));
    threeOfAKind.add(new PlayingCard('C', 10));
    threeOfAKind.add(new PlayingCard('S', 11));
    threeOfAKind.add(new PlayingCard('S', 11));

    assertFalse(hand.hasThreeOfAKind(threeOfAKind));
  }
}