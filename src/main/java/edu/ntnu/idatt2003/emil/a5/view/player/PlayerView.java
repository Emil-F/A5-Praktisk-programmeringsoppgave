package edu.ntnu.idatt2003.emil.a5.view.player;

import edu.ntnu.idatt2003.emil.a5.controller.PokerController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PlayerView extends StackPane {
  private final PokerController controller;
  private final PlayerInfo playerInfo;
  private final PlayerHand playerHand;

  public PlayerView(PokerController controller) {
    this.controller = controller;
    this.playerHand = new PlayerHand(controller);
    this.playerInfo = new PlayerInfo(controller);
    getStylesheets().add(getClass().getResource("/css/PlayerView.css").toExternalForm());
    getChildren().addAll(
      playerInfo,
      createBody()
    );
  }

  private VBox createBody() {
    VBox body = new VBox();
    body.getChildren().addAll(
      playerInfo,
      playerHand,
      createButtonRow()
    );
    return body;
  }

  private HBox createButtonRow() {
    HBox buttonRow = new HBox();
    buttonRow.setId("buttonRow");
    buttonRow.setSpacing(10);
    buttonRow.setAlignment(Pos.CENTER);

    buttonRow.getChildren().addAll(
      createStartButton(),
      createAdvanceButton()
    );
    return buttonRow;
  }

    private Button createStartButton() {
    Button startButton = new Button("Start Game");
    startButton.setOnAction(e -> {
      controller.handleStartGame();
    });
    return startButton;
  }

  private Button createAdvanceButton() {
    Button advanceButton = new Button("Advance");
    advanceButton.setOnAction(e -> {
      controller.handleAdvance();
    });
    return advanceButton;
  }

  private Button createCheckButton() {
    Button checkButton = new Button("Check");
    checkButton.setOnAction(e -> {
      controller.handleCheck();
    });
    return checkButton;
  }

  private Button createCallButton() {
    Button callButton = new Button("Call");
    callButton.setOnAction(e -> {
      controller.handleCall();
    });
    return callButton;
  }

  private Button createRaiseButton() {
    Button raiseButton = new Button("Raise");
    raiseButton.setOnAction(e -> {
      controller.handleRaise();
    });
    return raiseButton;
  }

  private Button createFoldButton() {
    Button foldButton = new Button("Fold");
    foldButton.setOnAction(e -> {
      controller.handleFold();
    });
    return foldButton;
  }

  private Button createAllInButton() {
    Button allInButton = new Button("All In");
    allInButton.setOnAction(e -> {
      controller.handleAllIn();
    });
    return allInButton;
  }
}
