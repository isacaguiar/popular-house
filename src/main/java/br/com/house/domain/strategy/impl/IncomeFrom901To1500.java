package br.com.house.domain.strategy.impl;

import br.com.house.domain.strategy.ScoreStrategy;
import br.com.house.domain.strategy.ScoreStrategyEnum;
import java.math.BigDecimal;

public class IncomeFrom901To1500 implements ScoreStrategy {

  public int score(BigDecimal income) {
    return income.compareTo(new BigDecimal(90)) > 0
        && income.compareTo(new BigDecimal(150)) <= 0 ? 3 : 0;
  }

  @Override
  public ScoreStrategyEnum getStrategyName() {
    return null;
  }

}
