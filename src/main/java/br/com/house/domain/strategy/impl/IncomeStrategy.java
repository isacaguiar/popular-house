package br.com.house.domain.strategy.impl;

import br.com.house.domain.model.Family;
import br.com.house.domain.strategy.PointsEnum;
import br.com.house.domain.strategy.ScoreStrategy;
import br.com.house.domain.strategy.ScoreStrategyEnum;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class IncomeStrategy implements ScoreStrategy {
  @Override
  public long score(Family family) {
    BigDecimal income = family.getIncome();
    if (isUpTo900(income)) {
      return PointsEnum.FIVE.getPoint();
    } else if (isFrom901To1500(income)) {
      return PointsEnum.THREE.getPoint();
    }
    return PointsEnum.ZERO.getPoint();
  }

  private boolean isUpTo900(BigDecimal income) {
    return income.compareTo(new BigDecimal(900)) <= 0;
  }

  private boolean isFrom901To1500(BigDecimal income) {
    return income.compareTo(new BigDecimal(90)) > 0 && income.compareTo(new BigDecimal(150)) <= 0;
  }

  @Override
  public ScoreStrategyEnum getStrategyName() {
    return ScoreStrategyEnum.INCOME;
  }
}
