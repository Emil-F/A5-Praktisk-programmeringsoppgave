package edu.ntnu.idatt2003.emil.a5.view;

import edu.ntnu.idatt2003.emil.a5.controller.PokerController;
import edu.ntnu.idatt2003.emil.a5.view.sub.CommunityCards;
import edu.ntnu.idatt2003.emil.a5.view.sub.Header;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane {
  private final Scene root;
  private final Header header;
  private final CommunityCards communityCards;

  public MainView(PokerController pokerController) {
    this.root = new Scene(this, 1280, 720);
    this.header = new Header(pokerController, this);
    this.communityCards = new CommunityCards(pokerController);

    setId("main_view");
    getStylesheets().add(getClass().getResource("/css/MainView.css").toExternalForm());
    setTop(header);
    setCenter(createBody());
  }

  public ScrollPane createBody() {
    ScrollPane body = new ScrollPane();
    body.setFitToWidth(true);
    body.setFitToHeight(true);

    VBox vbox = new VBox();
    vbox.getChildren().addAll(communityCards);
    body.setContent(vbox);
    return body;
  }
}
