package br.com.house.adapter.controller.payload.response;

import java.math.BigDecimal;
import java.util.Set;
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
public class FamilyResponse {
  private long id;
  private Set<PersonResponse> persons;
  private PersonResponse person;
  private BigDecimal income;
  private long dependentsOver18YearsOld;
  private long dependents;
}
