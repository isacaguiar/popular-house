package br.com.house.domain.strategy.impl;

import br.com.house.domain.strategy.ScoreStrategyEnum;
import java.math.BigDecimal;

public class IncomeUpTo900 {

  public int score(BigDecimal income) {
    return income.compareTo(new BigDecimal(900)) <= 0 ? 5 : 0;
  }

  public ScoreStrategyEnum getStrategyName() {
    return null;
  }

}
