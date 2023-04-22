package br.com.house.domain.strategy.impl;

import br.com.house.domain.strategy.ScoreStrategy;
import br.com.house.domain.strategy.ScoreStrategyEnum;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class DependentsStrategy implements ScoreStrategy {
  @Override
  public int score(BigDecimal dependentsNumber) {
    int number = dependentsNumber.intValue();
    if (number > 0 && number <= 2) {
      return 2;
    } else if (number > 2) {
      return 3;
    }
    return 0;
  }

  @Override
  public ScoreStrategyEnum getStrategyName() {
    return ScoreStrategyEnum.DEPENDENTS;
  }
}
