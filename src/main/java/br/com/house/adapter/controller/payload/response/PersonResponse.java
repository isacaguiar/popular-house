package br.com.house.adapter.controller.payload.response;

import java.math.BigDecimal;
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
public class PersonResponse {
  private long id;
  private int age;
  private String name;
  private String documentNumber;
  private BigDecimal salaryIncome;
}
