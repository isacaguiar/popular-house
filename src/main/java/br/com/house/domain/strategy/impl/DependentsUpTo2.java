package br.com.house.domain.strategy.impl;

public class DependentsUpTo2 {

  public int score(int dependentsNumber) {
    return (dependentsNumber > 0 && dependentsNumber <= 2) ? 2 : 0;
  }
}
