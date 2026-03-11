package edu.ntnu.idatt2003.emil.a5.view.sub;

import edu.ntnu.idatt2003.emil.a5.view.PokerView;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Header extends StackPane {
  public Header(PokerView view) {
    getChildren().add(getHomeBtn());
  }

  public Button getHomeBtn() {
    return new Button("Home");
  }
}
