package edu.ntnu.idatt2003.emil.a5.model;

import edu.ntnu.idatt2003.emil.a5.model.poker.PlayingCard;
import edu.ntnu.idatt2003.emil.a5.model.poker.hand.HandCheckResult;
import edu.ntnu.idatt2003.emil.a5.model.poker.round.PlayerAction;
import edu.ntnu.idatt2003.emil.a5.model.poker.round.PokerRound;
import edu.ntnu.idatt2003.emil.a5.model.poker.round.Pot;
import edu.ntnu.idatt2003.emil.a5.model.poker.round.Round;
import edu.ntnu.idatt2003.emil.a5.model.users.Bot;
import edu.ntnu.idatt2003.emil.a5.model.users.Participant;
import edu.ntnu.idatt2003.emil.a5.model.users.Player;

import java.util.ArrayList;
import java.util.List;

public class PokerService {

  private final PokerGame game;

  public PokerService(PokerGame game) {
    this.game = game;
  }

  public Player getPlayer() {
    return game.getPlayer();
  }

  public List<Bot> getBots() {
    return game.getBots();
  }

  public List<Participant> getParticipants() {
    return game.getParticipants();
  }

  public List<PlayingCard> getCommunityCards() {
    return game.getCurrentRound().getCommunityCards();
  }

  public Pot getPot() {
    return game.getCurrentRound().getPot();
  }

  public PokerRound getCurrentRound() {
    return game.getCurrentRound();
  }

  public Round getCurrentRoundState() {
    return game.getCurrentRound().getRoundState().getCurrentState();
  }

  public HandCheckResult getPlayerHandCheckResult() {
    return game.getCurrentRound().getHandChecker().checkHand(getPlayer(), getCommunityCards());
  }

  public HandCheckResult getLastWinnerResult() {
    return game.getCurrentRound().getLastWinner();
  }

  public String getCardsOfHearts() {
    List<PlayingCard> cards = new ArrayList<>(getPlayer().getCards());
    cards.addAll(getCommunityCards());

    List<PlayingCard> filtered = cards.stream().filter(c -> c.getSuit() == 'H').toList();

    StringBuilder cardsString = new StringBuilder();
    for (PlayingCard card : filtered) {
      cardsString.append(card.getAsString()).append(" ");
    }
    return cardsString.toString();
  }

  public String hasQueenOfSpades() {
    List<PlayingCard> cards = new ArrayList<>(getPlayer().getCards());
    cards.addAll(getCommunityCards());

    return cards.stream().anyMatch(c -> c.getSuit() == 'S' && c.getFace() == 12) ? "Yes" : "No";
  }

  public void advanceRound() {
    game.advanceRound();
  }

  public void startGame() {
    game.startGame();
  }

  public void handleAction(Participant participant, PlayerAction action) {
    game.getCurrentRound().getBettingRound().handleAction(participant, action);
  }
}
