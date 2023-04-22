package br.com.house.domain.strategy;

import br.com.house.domain.model.Family;

public interface ScoreStrategy {

  long score(Family family);

  ScoreStrategyEnum getStrategyName();
}
