package br.com.house.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.house.domain.model.Family;
import br.com.house.domain.strategy.ScoreStrategyFactory;
import br.com.house.domain.strategy.impl.DependentsStrategy;
import br.com.house.domain.strategy.impl.IncomeStrategy;
import br.com.house.utils.BuilderUtils;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
    ScoreService.class,
    ScoreStrategyFactory.class,
    DependentsStrategy.class,
    IncomeStrategy.class
})
class ScoreServiceTest {

  @Autowired
  private ScoreService scoreService;

  @ParameterizedTest
  @MethodSource("loadFamilies")
  void score(Family family, long scoreExpected) {
    long score = scoreService.score(family);

    assertNotNull(score);
    assertEquals(scoreExpected, score);
  }

  private static Stream<Arguments> loadFamilies() {
    return Stream.of(
        Arguments.of(BuilderUtils.loadFamily(), 7L),
        Arguments.of(BuilderUtils.loadFamily2(), 5L),
        Arguments.of(BuilderUtils.loadFamily3(), 6L),
        Arguments.of(BuilderUtils.loadFamily4(), 3L)
    );
  }

}