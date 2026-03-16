package edu.ntnu.idatt2003.emil.a5.model.poker.round;

import edu.ntnu.idatt2003.emil.a5.model.PlayerAction;
import edu.ntnu.idatt2003.emil.a5.model.PlayingCard;
import edu.ntnu.idatt2003.emil.a5.model.users.User;
import edu.ntnu.idatt2003.emil.a5.model.poker.hand.HandChecker;

import java.util.ArrayList;
import java.util.List;

public class PokerRound {
  private final RoundState roundState;
  private final List<PlayingCard> communityCards;
  private final DeckOfCards deck;
  private final Pot pot;
  private final BettingRound bettingRound;
  private final HandChecker handChecker;
  private List<User> players;
  private User currentPlayer;

  public PokerRound(List<User> players) {
    this.roundState = new RoundState();
    this.communityCards = new ArrayList<>();
    this.deck = new DeckOfCards();
    this.pot = new Pot();
    this.bettingRound = new BettingRound();
    this.handChecker = new HandChecker();
    this.players = players;
  }

  public RoundState getRoundState() {
    return roundState;
  }

  public List<PlayingCard> getCommunityCards() {
    return communityCards;
  }

  public DeckOfCards getDeck() {
    return deck;
  }

  public Pot getPot() {
    return pot;
  }

  public BettingRound getBettingRound() {
    return bettingRound;
  }

  public HandChecker getHandChecker() {
    return handChecker;
  }

  public void advanceRoundState() {
    roundState.advanceRound();
  }

  public void resetCards() {
    communityCards.clear();
    for (User player : players) {
      player.clearCards();
    }
  }

  public void dealPreFlop() {
    resetCards();
    dealHoleCards(this.players);
  }

  public void dealFlop() {
    advanceRoundState();
    communityCards.addAll(deck.dealHand(3));
  }

  public void dealTurn() {
    advanceRoundState();
    communityCards.addAll(deck.dealHand(1));
  }

  public void dealRiver() {
    advanceRoundState();
    communityCards.addAll(deck.dealHand(1));
  }

  public void handleAction(User user, PlayerAction action) {
    bettingRound.handleAction(user, action);
  }

  public void resolveShowdown() {
    advanceRoundState();
  }

  public void dealHoleCards(List<User> participants) {
    this.deck.restockCards();
    for (User participant : participants) {
      participant.setCards(deck.dealHand(2));
    }
  }
}
