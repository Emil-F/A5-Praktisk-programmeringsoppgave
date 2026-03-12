package edu.ntnu.idatt2003.emil.a5.model.users;

import java.util.Objects;

public class Player extends User {
  private int chips;
  private boolean folded;

  public Player(String name, int chips) {
    super(Objects.requireNonNull(name , "name is null"));
    if (chips < 0) {
      throw new IllegalArgumentException("chips is negative");
    }
    this.chips = chips;
    this.folded = false;
  }

  @Override
  public String toString() {
    return "Class: " + getClass().getSimpleName() +
        ", Name: " + getName() +
        ", Chips: " + getChips() +
        ", " + getHand().toString();
  }

  public int getChips() {
    return chips;
  }

  public boolean isFolded() {
    return folded;
  }

  public void addChips(int chips) {
    if (chips < 0) {
      throw new IllegalArgumentException("chips is negative");
    }
    this.chips += chips;
  }

  public void removeChips(int chips) {
    if (chips < 0) {
      throw new IllegalArgumentException("chips is negative");
    }
    this.chips -= chips;
  }

  public void fold() {
    folded = true;
  }
}
