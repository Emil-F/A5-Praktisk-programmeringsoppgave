package edu.ntnu.idatt2003.emil.a5.view.sub;

import edu.ntnu.idatt2003.emil.a5.controller.PokerController;
import edu.ntnu.idatt2003.emil.a5.view.MainView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Header extends StackPane {
  private final PokerController controller;

  public Header(PokerController pokerController, MainView view) {
    this.controller = pokerController;
    setId("header");
    getStylesheets().add(getClass().getResource("/css/header.css").toExternalForm());
    setAlignment(Pos.CENTER);
    getChildren().add(createButtonRow());
  }

  public HBox createButtonRow() {
    HBox buttonRow = new HBox();
    buttonRow.setAlignment(Pos.CENTER);
    buttonRow.setSpacing(10);
    buttonRow.getChildren().addAll(
      createHomeBtn()
    );
    return buttonRow;
  }

  public Button createHomeBtn() {
    Button homeBtn = new Button("Home");
    homeBtn.setOnAction(e -> controller.addCommunityCard());
    return homeBtn;
  }
}
