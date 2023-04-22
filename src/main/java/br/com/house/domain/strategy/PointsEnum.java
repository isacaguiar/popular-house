package br.com.house.domain.strategy;

import lombok.Getter;

public enum PointsEnum {
  ZERO(0),
  UM(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5);

  @Getter
  private int point;

  PointsEnum(int point) {
    this.point = point;
  }
}
