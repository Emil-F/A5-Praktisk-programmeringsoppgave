package edu.ntnu.idatt2003.emil.a5.model.poker.round;

import edu.ntnu.idatt2003.emil.a5.model.users.Bot;
import edu.ntnu.idatt2003.emil.a5.model.users.Participant;
import edu.ntnu.idatt2003.emil.a5.model.users.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BettingRound {
  Logger logger = Logger.getLogger(BettingRound.class.getName());

  private int currentBet;
  private int minRaise;
  private int pot;
  private boolean isComplete;

  private Player player;
  private List<Bot> bots;

  private boolean hasRaised;
  private List<Participant> nonActedParticipants;
  private List<Participant> actedParticipants;
  private Participant currentParticipant;

  public BettingRound(Player player, List<Bot> bots) {
    this.currentBet = 0;
    this.minRaise = 0;
    this.pot = 0;
    this.isComplete = false;

    this.player = player;
    this.bots = bots;
    this.nonActedParticipants = new ArrayList<>();
    this.actedParticipants = new ArrayList<>();
    this.currentParticipant = player;
  }

  public int getCurrentBet() {
    return currentBet;
  }

  public int getMinRaise() {
    return minRaise;
  }

  public int getBettingPot() {
    return pot;
  }

  public void start(List<Participant> participants) {
    this.currentBet = 0;
    this.minRaise = 0;
    this.pot = 0;
    this.isComplete = false;
    this.currentParticipant = player;
  }

  public void handleAction(Participant participant, PlayerAction action) {
    switch (action.type()) {
      case CHECK -> check(participant);
      case CALL -> call(participant);
      case RAISE -> raise(participant, action.amount());
      case FOLD -> fold(participant);
    }
  }

  public void check(Participant participant) {
    if (hasRaised) {
      throw new IllegalStateException("Can't check when someone has raised");
    }
    System.out.println("Checking within betting round: " + participant.getName());
  }

  public void call(Participant participant) {

    System.out.println("Calling within betting round: " + participant.getName());
  }

  public void raise(Participant participant, int amount) {
    if (amount < minRaise) {
      throw new IllegalArgumentException("Amount needs to be equal or higher to the current bet.");
    }
    this.currentBet += amount;
    this.minRaise = currentBet;
    this.pot += amount;
    participant.removeChips(amount);
    logger.info(participant.getName() + " raised current bet by " + amount);
    logger.info(String.valueOf(participant.getChips()));
    logBettingRoundInfo();
    hasRaised = true;
  }

  public void fold(Participant participant) {
    System.out.println("Folding within betting round: " + participant.getName());
  }

  public boolean isComplete() {
    return isComplete;
  }

  public void logBettingRoundInfo() {
    String bettingRoundString = "Current bet: " + this.currentBet +
      "\nMinRaise: " + this.minRaise +
      "\nPot: " + this.pot;

    logger.info(bettingRoundString);
  }
}
