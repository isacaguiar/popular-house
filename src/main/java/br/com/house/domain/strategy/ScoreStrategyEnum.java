package br.com.house.domain.strategy;

import br.com.house.domain.strategy.impl.DependentsStrategy;
import br.com.house.domain.strategy.impl.IncomeStrategy;

public enum ScoreStrategyEnum {

  INCOME(new IncomeStrategy()),
  DEPENDENTS(new DependentsStrategy());

  private ScoreStrategy score;

  public ScoreStrategy getInstance() {
    return score;
  }

  ScoreStrategyEnum(ScoreStrategy score) {
    this.score = score;
  }
}
