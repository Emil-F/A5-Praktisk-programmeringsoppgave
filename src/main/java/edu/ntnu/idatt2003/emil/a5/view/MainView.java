package edu.ntnu.idatt2003.emil.a5.view;

import edu.ntnu.idatt2003.emil.a5.controller.PokerController;
import edu.ntnu.idatt2003.emil.a5.view.sub.CommunityCards;
import edu.ntnu.idatt2003.emil.a5.view.sub.Header;
import javafx.scene.layout.BorderPane;

public class PokerView extends BorderPane {
  private Header header;

  public PokerView(PokerController pokerController) {
    setId("main_view");
    getStylesheets().add(getClass().getResource("/css/MainView.css").toExternalForm());
    setTop(new Header(pokerController, this));
    setCenter(new CommunityCards(pokerController));
  }
}
