package br.com.house.domain.strategy.impl;

import br.com.house.domain.strategy.ScoreStrategy;
import br.com.house.domain.strategy.ScoreStrategyEnum;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class IncomeStrategy implements ScoreStrategy {
  @Override
  public int score(BigDecimal income) {
    if (income.compareTo(new BigDecimal(900)) <= 0) {
      return 5;
    } else if (income.compareTo(new BigDecimal(90)) > 0
        && income.compareTo(new BigDecimal(150)) <= 0) {
      return 3;
    }
    return 0;
  }

  @Override
  public ScoreStrategyEnum getStrategyName() {
    return ScoreStrategyEnum.INCOME;
  }
}
