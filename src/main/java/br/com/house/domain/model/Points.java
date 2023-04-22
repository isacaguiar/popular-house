package br.com.house.domain.model;

import br.com.house.adapter.controller.payload.response.PointsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Points {

  private String responsibleName;

  private int score;

  public PointsResponse toResponse() {
    return PointsResponse.builder()
        .responsibleName(responsibleName)
        .score(score)
        .build();
  }

}
