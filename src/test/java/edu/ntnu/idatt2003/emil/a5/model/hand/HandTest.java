package edu.ntnu.idatt2003.emil.a5.model.hand;

import edu.ntnu.idatt2003.emil.a5.model.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

  private Hand hand;
  private List<PlayingCard> highCardHand;

  private PlayingCard card(char suit, int face) {
    return new PlayingCard(suit, face);
  }

  @BeforeEach
  void setUp() {
    hand  = new Hand();
    highCardHand = List.of(
        card('S', 2),
        card('H', 5),
        card('D', 7),
        card('C', 9),
        card('S', 11),
        card('H', 13),
        card('D', 3)
    );
  }

  @Test
  void calculateCardTotal_ReturnsTheHandsTotalCardValue() {
  }

  @Test
  void checkHand_returnsRoyalFlushIfHandHasRoyalFlush() {
    hand.setCards(List.of(card('S', 1), card('S', 10)));
    List<PlayingCard> royalFlush = List.of(
      card('S', 11),
      card('S', 12),
      card('S', 13),
      card('S', 2),
      card('S', 3)
    );
    int cardTotal = 52;

    HandCheckResult result = new HandCheckResult(cardTotal, HandRank.ROYAL_FLUSH);

    assertEquals(result, hand.checkHand(royalFlush));
  }

  @Test
  void checkHand_returnsStraightFlushIfHandHasStraightFlush() {
    hand.setCards(List.of(card('S', 1), card('S', 3)));
    List<PlayingCard> straightFlush = List.of(
      card('S', 4),
      card('S', 5),
      card('S', 6),
      card('S', 7),
      card('H', 3)
    );
    int cardTotal = 29;

    HandCheckResult result = new HandCheckResult(cardTotal, HandRank.STRAIGHT_FLUSH);

    assertEquals(result, hand.checkHand(straightFlush));
  }

  @Test
  void checkHand_returnsFourOfAKindIfHandHasFourOfAKind() {
    hand.setCards(List.of(card('S', 1), card('S', 3)));
    List<PlayingCard> fourOfAKind = List.of(
      card('H', 3),
      card('D', 3),
      card('H', 6),
      card('S', 7),
      card('C', 3)
    );
    int cardTotal = 26;

    HandCheckResult result = new HandCheckResult(cardTotal, HandRank.FOUR_OF_A_KIND);

    assertEquals(result, hand.checkHand(fourOfAKind));
  }

  @Test
  void checkHand_returnsFullHouseIfHandHasFullHouse() {
    hand.setCards(List.of(card('S', 1), card('S', 3)));
    List<PlayingCard> fullHouse = List.of(
      card('H', 3),
      card('D', 3),
      card('H', 6),
      card('S', 2),
      card('C', 2)
    );
    int cardTotal = 20;

    HandCheckResult result = new HandCheckResult(cardTotal, HandRank.FULL_HOUSE);

    assertEquals(result, hand.checkHand(fullHouse));
  }

  @Test
  void checkHand_returnsFlushIfHandHasFlush() {
    hand.setCards(List.of(card('S', 1), card('H', 4)));
    List<PlayingCard> flush = List.of(
      card('H', 6),
      card('H', 10),
      card('H', 13),
      card('S', 8),
      card('H', 2)
    );
    int cardTotal = 44;

    HandCheckResult result = new HandCheckResult(cardTotal, HandRank.FLUSH);

    assertEquals(result, hand.checkHand(flush));
  }

  @Test
  void checkHand_returnsStraightIfHandHasStraight() {
    hand.setCards(List.of(card('S', 1), card('D', 3)));
    List<PlayingCard> straight = List.of(
      card('H', 4),
      card('C', 5),
      card('H', 6),
      card('S', 7),
      card('H', 2)
    );
    int cardTotal = 28;

    HandCheckResult result = new HandCheckResult(cardTotal, HandRank.STRAIGHT);

    assertEquals(result, hand.checkHand(straight));
  }

  @Test
  void checkHand_returnsThreeOfAKindIfHandHasThreeOfAKind() {
    hand.setCards(List.of(card('S', 1), card('D', 3)));
    List<PlayingCard> threeOfAKind = List.of(
      card('H', 3),
      card('C', 5),
      card('H', 6),
      card('S', 3),
      card('H', 2)
    );
    int cardTotal = 23;

    HandCheckResult result = new HandCheckResult(cardTotal, HandRank.THREE_OF_A_KIND);

    assertEquals(result, hand.checkHand(threeOfAKind));
  }

  @Test
  void checkHand_returnsTwoPairsIfHandHasTwoPairs() {
    hand.setCards(List.of(card('S', 1), card('D', 3)));
    List<PlayingCard> twoPairs = List.of(
      card('H', 3),
      card('C', 5),
      card('H', 6),
      card('S', 5),
      card('H', 2)
    );
    int cardTotal = 25;

    HandCheckResult result = new HandCheckResult(cardTotal, HandRank.TWO_PAIRS);

    assertEquals(result, hand.checkHand(twoPairs));
  }

  @Test
  void checkHand_returnsOnePairIfHandHasOnePair() {
    hand.setCards(List.of(card('S', 1), card('D', 3)));
    List<PlayingCard> onePair = List.of(
      card('H', 3),
      card('C', 5),
      card('H', 6),
      card('S', 7),
      card('H', 2)
    );
    int cardTotal = 27;

    HandCheckResult result = new HandCheckResult(cardTotal, HandRank.ONE_PAIR);

    assertEquals(result, hand.checkHand(onePair));
  }

  @Test
  void checkHand_returnsHighCardIfHandHasHighCard() {
    hand.setCards(List.of(card('S', 2), card('H', 5)));
    List<PlayingCard> highCard = List.of(
      card('D', 7),
      card('C', 9),
      card('S', 11),
      card('H', 13),
      card('D', 3)
    );
    int cardTotal = 50;

    HandCheckResult result = new HandCheckResult(cardTotal, HandRank.HIGH_CARD);

    assertEquals(result, hand.checkHand(highCard));
  }

  @Test
  void hasRoyalFlush_returnsTrueIfHandHasRoyalFlush() {
    List<PlayingCard> royalFlush = List.of(
      card('S', 1),
      card('S', 10),
      card('S', 11),
      card('S', 12),
      card('S', 13),
      card('S', 2),
      card('S', 3)
    );

    assertTrue(hand.hasRoyalFlush(royalFlush));
  }

  @Test
  void hasRoyalFlush_returnsFalseIfHandDoesNotHaveRoyalFlush() {
    assertFalse(hand.hasRoyalFlush(highCardHand));
  }

  @Test
  void hasRoyalFlush_returnsFalseIfCardsDontAllHaveTheSameSuit() {
    List<PlayingCard> cards = List.of(
      card('S', 1),
      card('S', 10),
      card('H', 11),
      card('S', 12),
      card('S', 13),
      card('H', 13),
      card('C', 13)
    );

    assertFalse(hand.hasRoyalFlush(cards));
  }

  @Test
  void hasStraightFlush_returnsTrueIfHandHasStraightFlush() {
    List<PlayingCard> straightFlush = List.of(
      card('S', 7),
      card('S', 8),
      card('S', 9),
      card('S', 10),
      card('S', 11),
      card('S', 1),
      card('S', 2)
    );

    assertTrue(hand.hasStraightFlush(straightFlush));
  }

  @Test
  void hasStraightFlush_returnsFalseIfHandDoesNotHaveStraightFlush() {
    assertFalse(hand.hasStraightFlush(highCardHand));
  }

  @Test
  void hasStraightFlush_returnsFalseIfCardsDontAllHaveTheSameSuit() {
    List<PlayingCard> cards = List.of(
      card('D', 7),
      card('S', 8),
      card('H', 9),
      card('S', 10),
      card('S', 11),
      card('S', 2),
      card('S', 1)
    );

    assertFalse(hand.hasStraightFlush(cards));
  }

  @Test
  void hasFourOfAKind_returnsTrueIfHandHasFourOfAKind() {
    List<PlayingCard> fourOfAKind = List.of(
      card('S', 5),
      card('H', 5),
      card('D', 5),
      card('C', 5),
      card('C', 10),
      card('S', 11),
      card('H', 11)
    );

    assertTrue(hand.hasFourOfAKind(fourOfAKind));
  }

  @Test
  void hasFourOfAKind_returnsFalseIfHandDoesNotHaveFourOfAKind() {
    List<PlayingCard> threeOfAKind = List.of(
      card('S', 5),
      card('H', 5),
      card('D', 5),
      card('C', 2),
      card('C', 10),
      card('S', 11),
      card('H', 11)
    );

    assertAll(
      () -> assertFalse(hand.hasFourOfAKind(highCardHand)),
      () -> assertFalse(hand.hasFourOfAKind(threeOfAKind))
    );
  }

  @Test
  void hasFullHouse_returnsTrueIfHandHasFullHouse() {
    List<PlayingCard> fullHouseV1 = List.of(
      card('S', 6),
      card('H', 6),
      card('D', 6),
      card('C', 12),
      card('H', 12),
      card('S', 1),
      card('H', 2)
    );

    List<PlayingCard> fullHouseV2 = List.of(
      card('S', 6),
      card('H', 5),
      card('D', 5),
      card('C', 5),
      card('H', 12),
      card('S', 1),
      card('H', 6)
    );

    assertAll(
      () -> assertTrue(hand.hasFullHouse(fullHouseV1)),
      () -> assertTrue(hand.hasFullHouse(fullHouseV2))
    );
  }

  @Test
  void hasFullHouse_returnsFalseIfHandDoesNotHaveFullHouse() {
    assertFalse(hand.hasFullHouse(highCardHand));
  }

  @Test
  void hasFlush_returnsTrueIfHandHasFlush() {
    List<PlayingCard> flushV1 = List.of(
        card('S', 1),
        card('S', 3),
        card('S', 4),
        card('S', 6),
        card('H', 8),
        card('S', 10),
        card('H', 11)
    );

    List<PlayingCard> flushV2= List.of(
        card('H', 1),
        card('H', 3),
        card('H', 4),
        card('H', 6),
        card('H', 8),
        card('H', 10),
        card('H', 11)
    );

    assertAll(
        () -> assertTrue(hand.hasFlush(flushV1)),
        () -> assertTrue(hand.hasFlush(flushV2))
    );
  }

  @Test
  void hasFlush_returnsFalseIfHandDoesNotHaveFlush() {
    assertFalse(hand.hasFlush(highCardHand));
  }

  @Test
  void hasStraight_returnsTrueIfHandHasStraight() {
    List<PlayingCard> straightV1 = List.of(
        card('S', 3),
        card('H', 1),
        card('D', 6),
        card('C', 7),
        card('C', 8),
        card('S', 9),
        card('S', 10)
    );

    List<PlayingCard> straightV2 = List.of(
        card('S', 13),
        card('H', 3),
        card('D', 4),
        card('C', 5),
        card('C', 6),
        card('S', 7),
        card('S', 10)
    );

    List<PlayingCard> straightV3 = List.of(
        card('S', 13),
        card('H', 4),
        card('D', 5),
        card('C', 6),
        card('C', 7),
        card('S', 8),
        card('S', 1)
    );

    List<PlayingCard> straightV4 = List.of(
        card('S', 13),
        card('H', 4),
        card('D', 11),
        card('C', 7),
        card('C', 8),
        card('S', 9),
        card('S', 10)
    );

    List<PlayingCard> straightV5 = List.of(
        card('S', 7),
        card('S', 8),
        card('S', 9),
        card('S', 10),
        card('S', 11),
        card('S', 1),
        card('S', 2)
    );

    assertAll(
        () -> assertTrue(hand.hasStraight(straightV1)),
        () -> assertTrue(hand.hasStraight(straightV2)),
        () -> assertTrue(hand.hasStraight(straightV3)),
        () -> assertTrue(hand.hasStraight(straightV4)),
        () -> assertTrue(hand.hasStraight(straightV5))
    );
  }

  @Test
  void hasStraight_returnsFalseIfHandDoesNotHaveStraight() {
    assertFalse(hand.hasStraight(highCardHand));
  }

  @Test
  void hasThreeOfAKind_returnsTrueIfHandHasThreeOfAKind() {
    List<PlayingCard> threeOfAKind = List.of(
      card('S', 5),
      card('H', 5),
      card('D', 5),
      card('C', 9),
      card('C', 10),
      card('S', 11),
      card('S', 11)
    );

    assertTrue(hand.hasThreeOfAKind(threeOfAKind));
  }

  @Test
  void hasThreeOfAKind_returnsFalseIfHandDoesNotHaveThreeOfAKind() {
    List<PlayingCard> fourOfAKind = List.of(
        card('S', 5),
        card('H', 5),
        card('D', 5),
        card('C', 5),
        card('C', 10),
        card('S', 11),
        card('S', 11)
    );

    assertAll(
        () -> assertFalse(hand.hasThreeOfAKind(highCardHand)),
        () -> assertFalse(hand.hasThreeOfAKind(fourOfAKind))
    );
  }

  @Test
  void hasTwoPairs_returnsTrueIfHandHasTwoPairs() {
    List<PlayingCard> twoPairs = List.of(
        card('S', 5),
        card('H', 5),
        card('D', 1),
        card('C', 2),
        card('C', 10),
        card('S', 10),
        card('S', 12)
    );

    assertTrue(hand.hasTwoPairs(twoPairs));
  }

  @Test
  void hasTwoPairs_returnsFalseIfHandHasOnePair() {
    List<PlayingCard> onePair = List.of(
        card('S', 5),
        card('H', 5),
        card('D', 1),
        card('C', 2),
        card('C', 10),
        card('S', 11),
        card('S', 12)
    );

    assertFalse(hand.hasTwoPairs(onePair));
  }

  @Test
  void hasTwoPairs_returnsFalseIfHandDoesNotHaveTwoPairs() {
    assertFalse(hand.hasTwoPairs(highCardHand));
  }

  @Test
  void hasOnePair_returnsTrueIfHandHasOnePair() {
    List<PlayingCard> onePair = List.of(
        card('S', 5),
        card('H', 5),
        card('D', 1),
        card('C', 2),
        card('C', 10),
        card('S', 11),
        card('S', 12)
    );

    assertTrue(hand.hasOnePair(onePair));
  }

  @Test
  void hasOnePair_returnsFalseIfHandHasTwoPairs() {
    List<PlayingCard> twoPairs = List.of(
        card('S', 5),
        card('H', 5),
        card('D', 1),
        card('C', 2),
        card('C', 10),
        card('S', 10),
        card('S', 12)
    );

    assertFalse(hand.hasOnePair(twoPairs));
  }

  @Test
  void hasOnePair_returnsFalseIfHandDoesNotHaveOnePair() {
    assertFalse(hand.hasOnePair(highCardHand));
  }
}