package edu.ntnu.idatt2003.emil.a5.model;

import edu.ntnu.idatt2003.emil.a5.model.poker.round.PlayerAction;
import edu.ntnu.idatt2003.emil.a5.model.poker.round.PlayerActionType;
import org.junit.jupiter.api.Test;

class PokerServiceTest {

  @Test
  void handleAction_goesThrough() {
    PokerGame pokerGame = new PokerGame();
    PokerService service = new PokerService(pokerGame);
    service.handleAction(pokerGame.getPlayer(), new PlayerAction(PlayerActionType.CALL, 0));
  }

  @Test
  void handleAction_checkDoesNotGoThroughWhenSomeoneHasRaised() {
    PokerGame pokerGame = new PokerGame();
    PokerService service = new PokerService(pokerGame);
    service.handleAction(pokerGame.getPlayer(), new PlayerAction(PlayerActionType.RAISE, 50));
    service.handleAction(pokerGame.getPlayer(), new PlayerAction(PlayerActionType.CHECK, 0));
  }
}