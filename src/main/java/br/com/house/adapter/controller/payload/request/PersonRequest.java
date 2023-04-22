package br.com.house.adapter.controller.payload.request;

import br.com.house.domain.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonRequest {
  private long id;
  private int age;
  private String name;
  private String documentNumber;
  private BigDecimal salaryIncome;

  public Person toModel() {
    return Person.builder()
        .id(id)
        .age(age)
        .name(name)
        .documentNumber(documentNumber)
        .salaryIncome(salaryIncome)
        .build();
  }
}
