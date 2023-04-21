package br.com.house.adapter.controller.payload.request;

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
public class PersonRequest {

  private int age;

  private String name;

  private String documentNumber;

  private BigDecimal salaryIncome;
}
