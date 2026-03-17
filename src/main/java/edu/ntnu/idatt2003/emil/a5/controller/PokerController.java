package edu.ntnu.idatt2003.emil.a5.controller;

import edu.ntnu.idatt2003.emil.a5.model.poker.PlayingCard;
import edu.ntnu.idatt2003.emil.a5.model.PokerService;
import edu.ntnu.idatt2003.emil.a5.model.users.Bot;
import edu.ntnu.idatt2003.emil.a5.model.users.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.logging.Logger;

public class PokerController {
  private static final Logger logger = Logger.getLogger(PokerController.class.getName());

  private final MainController controller;
  private final PokerService service;

  private final ObservableList<PlayingCard> obsCommunityCards = FXCollections.observableArrayList();
  private final ObservableList<PlayingCard> obsPlayerCards = FXCollections.observableArrayList();

  private final StringProperty currentRound = new SimpleStringProperty();
  private final StringProperty potValue = new SimpleStringProperty();
  private final StringProperty currentRank = new SimpleStringProperty();
  private final StringProperty currentCardValue = new SimpleStringProperty();
  private final StringProperty currentWinner = new SimpleStringProperty();
  private final StringProperty currentWinningHand = new SimpleStringProperty();
  private final StringProperty cardsOfHearts = new SimpleStringProperty();
  private final StringProperty queenOfSpades = new SimpleStringProperty();

  public PokerController(MainController mainController, PokerService service) {
    this.controller = mainController;
    this.service = service;
    obsCommunityCards.setAll(service.getCommunityCards());
    obsPlayerCards.setAll(service.getPlayer().getCards());
  }

  public ObservableList<PlayingCard> getObsCommunityCards() {
    return obsCommunityCards;
  }

  public ObservableList<PlayingCard> getObsPlayerCards() {
    return obsPlayerCards;
  }

  public StringProperty getCurrentRound() {
    return currentRound;
  }

  public StringProperty getPotValue() {
    return potValue;
  }

  public StringProperty getCurrentRank() {
    return currentRank;
  }

  public StringProperty getCurrentCardValue() {
    return currentCardValue;
  }

  public StringProperty getCurrentWinner() {
    return currentWinner;
  }

  public StringProperty getCurrentWinningHand() {
    return currentWinningHand;
  }

  public StringProperty getQueenOfSpades() {
    return queenOfSpades;
  }

  public Player getPlayer() {
    return service.getPlayer();
  }

  public List<Bot> getBots() {
    return service.getBots();
  }

  public StringProperty getCardsOfHearts() {
    return cardsOfHearts;
  }

  public void refreshUI() {
    obsCommunityCards.setAll(service.getCommunityCards());
    obsPlayerCards.setAll(service.getPlayer().getCards());

    potValue.setValue(service.getPot().toString());
    currentRank.setValue(service.getPlayerHandCheckResult().rank().toString());
    currentCardValue.setValue(String.valueOf(service.getPlayerHandCheckResult().cardTotal()));
    if (service.getLastWinnerResult() != null) {
      currentWinner.setValue(service.getLastWinnerResult().participant().getName());
      currentWinningHand.setValue("["+ service.getLastWinnerResult().rank().toString() + "], [" + service.getLastWinnerResult().cardTotal() + "]");
    }
    cardsOfHearts.setValue(service.getCardsOfHearts());
    queenOfSpades.setValue(service.hasQueenOfSpades());

    switch (service.getCurrentRoundState()) {
      case PRE_FLOP -> this.currentRound.setValue("Pre Flop");
      case FLOP     -> this.currentRound.setValue("Flop");
      case TURN     -> this.currentRound.setValue("Turn");
      case RIVER    -> this.currentRound.setValue("River");
      case SHOWDOWN -> this.currentRound.setValue("Showdown");
      default       -> this.currentRound.setValue("End");
    }
  }

  public void handleStartGame() {
    service.startGame();
    refreshUI();
  }

  public void handleAdvance() {
    service.advanceRound();
    refreshUI();
  }

  public void handleFlop() {
    refreshUI();
  }

  public void handleCheck() {
    System.out.println("Check");
  }

  public void handleCall() {
    System.out.println("Call");
  }

  public void handleRaise() {
    System.out.println("Raise");
  }

  public void handleFold() {
    System.out.println("Fold");
  }

  public void handleAllIn() {
    System.out.println("All In");
  }

  public void stopGame() {
  }
}
