package br.com.house.domain.service;

import br.com.house.domain.strategy.ScoreStrategy;
import br.com.house.domain.strategy.ScoreStrategyEnum;
import br.com.house.domain.strategy.ScoreStrategyFactory;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

  @Autowired
  private ScoreStrategyFactory scoreStrategyFactory;

  public int score(BigDecimal amount, long dependentsNumber) {
    int pontuacao = 0;

    ScoreStrategy income =
        scoreStrategyFactory.findStrategy(ScoreStrategyEnum.INCOME);
    pontuacao +=  income.score(amount);

    ScoreStrategy dependents =
        scoreStrategyFactory.findStrategy(ScoreStrategyEnum.DEPENDENTS);
    pontuacao += dependents.score(BigDecimal.valueOf(dependentsNumber));

    return pontuacao;
  }

}
