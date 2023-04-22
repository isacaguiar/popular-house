package br.com.house.domain.strategy.impl;

public class DependentsOver3 {

  public int score(int dependentsNumber) {
    return (dependentsNumber > 2) ? 3 : 0;
  }
}
