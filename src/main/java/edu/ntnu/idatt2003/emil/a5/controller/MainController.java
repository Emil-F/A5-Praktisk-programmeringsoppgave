package edu.ntnu.idatt2003.emil.a5.controller;

import edu.ntnu.idatt2003.emil.a5.model.PlayingCard;
import edu.ntnu.idatt2003.emil.a5.model.PokerGame;
import edu.ntnu.idatt2003.emil.a5.view.MainView;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

public class MainController {
  private final MainView mainView;
  private final PokerGame game;
  private final PokerController pokerController;

  private ObservableList<PlayingCard> communityCards;

  public MainController() {
    this.game = new PokerGame();
    this.pokerController = new PokerController(this, game);
    this.mainView = new MainView(pokerController);
  }

  public BorderPane getMainView() {
    return this.mainView;
  }
}
