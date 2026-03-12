package edu.ntnu.idatt2003.emil.a5.model.users;

import java.util.Objects;

public class Bot extends User {
  public Bot(String name) {
    super(Objects.requireNonNull(name, "name is null"));
  }

  @Override
  public String toString() {
    return "Class: " + getClass().getSimpleName() +
        ", Name: " + getName() +
        ", " + getHand().toString();
  }
}
