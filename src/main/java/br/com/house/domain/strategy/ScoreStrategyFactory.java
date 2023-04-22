package br.com.house.domain.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScoreStrategyFactory {
  private Map<ScoreStrategyEnum, ScoreStrategy> scoreStrategyMap;

  @Autowired
  public ScoreStrategyFactory(Set<ScoreStrategy> scoreStrategySet) {
    createStrategy(scoreStrategySet);
  }

  public ScoreStrategy findStrategy(ScoreStrategyEnum scoreStrategyEnum) {
    return scoreStrategyMap.get(scoreStrategyEnum);
  }

  private void createStrategy(Set<ScoreStrategy> scoreStrategySet) {
    scoreStrategyMap = new HashMap<>();
    scoreStrategySet.forEach(
        scoreStrategy -> scoreStrategyMap.put(scoreStrategy.getStrategyName(), scoreStrategy)
    );
  }
}