package edu.ntnu.idatt2003.emil.a5.model.users;

public class Bot extends User {
  public Bot(String name) {
    super(name);
  }

  @Override
  public String toString() {
    return "Class: " + getClass().getSimpleName() +
        ", Name: " + getName();
  }
}
