package br.com.house.domain.strategy;

import java.math.BigDecimal;

public interface ScoreStrategy {

  int score(BigDecimal income);

  ScoreStrategyEnum getStrategyName();
}
