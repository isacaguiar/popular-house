package br.com.house.domain.strategy.impl;

import br.com.house.domain.model.Family;
import br.com.house.domain.strategy.PointsEnum;
import br.com.house.domain.strategy.ScoreStrategy;
import br.com.house.domain.strategy.ScoreStrategyEnum;
import org.springframework.stereotype.Component;

@Component
public class DependentsStrategy implements ScoreStrategy {
  @Override
  public long score(Family family) {
    long number = family.getDependentsOver18YearsOld();
    if (isUpTo2(number)) {
      return PointsEnum.TWO.getPoint();
    } else if (isOver3(number)) {
      return PointsEnum.THREE.getPoint();
    }
    return PointsEnum.ZERO.getPoint();
  }

  private boolean isUpTo2(long number) {
    return number > 0 && number <= 2;
  }

  private boolean isOver3(long number) {
    return number > 2;
  }

  @Override
  public ScoreStrategyEnum getStrategyName() {
    return ScoreStrategyEnum.DEPENDENTS;
  }
}
