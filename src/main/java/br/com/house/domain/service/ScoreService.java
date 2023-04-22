package br.com.house.domain.service;

import br.com.house.domain.model.Family;
import br.com.house.domain.strategy.ScoreStrategy;
import br.com.house.domain.strategy.ScoreStrategyEnum;
import br.com.house.domain.strategy.ScoreStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

  @Autowired
  private ScoreStrategyFactory scoreStrategyFactory;

  public long score(Family family) {
    long pontuacao = 0;
    pontuacao += getIncome(family);
    pontuacao += getDependentsPoint(family);
    return pontuacao;
  }

  private long getDependentsPoint(Family family) {
    ScoreStrategy dependents =
        scoreStrategyFactory.findStrategy(ScoreStrategyEnum.DEPENDENTS);
    return dependents.score(family);
  }

  private long getIncome(Family family) {
    ScoreStrategy income =
        scoreStrategyFactory.findStrategy(ScoreStrategyEnum.INCOME);
    return income.score(family);
  }

}
