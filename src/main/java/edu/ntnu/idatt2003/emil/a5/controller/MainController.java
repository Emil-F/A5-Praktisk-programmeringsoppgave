package edu.ntnu.idatt2003.emil.a5.controller;

import edu.ntnu.idatt2003.emil.a5.model.PokerService;
import edu.ntnu.idatt2003.emil.a5.model.PokerGame;
import edu.ntnu.idatt2003.emil.a5.view.MainView;
import javafx.scene.layout.BorderPane;

public class MainController {
  private final MainView mainView;
  private final PokerGame game;
  private final PokerService pokerService;
  private final PokerController pokerController;

  public MainController() {
    this.game = new PokerGame();
    this.pokerService = new PokerService(game);
    this.pokerController = new PokerController(this, pokerService);
    this.mainView = new MainView(pokerController);
  }

  public BorderPane getMainView() {
    return this.mainView;
  }
}
