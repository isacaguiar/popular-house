package br.com.house.domain.model;

import br.com.house.adapter.controller.payload.response.PersonResponse;
import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.adapter.persistence.entity.PersonEntity;
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
public class Person {
  private Long id;
  private int age;
  private String name;
  private String documentNumber;
  private BigDecimal salaryIncome;

  public PersonEntity toEntity(FamilyEntity family) {
    return PersonEntity.builder()
        .id(id)
        .name(name)
        .age(age)
        .documentNumber(documentNumber)
        .salaryIncome(salaryIncome)
        .family(family)
        .build();
  }

  public PersonEntity toEntity() {
    return PersonEntity.builder()
        .id(id)
        .name(name)
        .age(age)
        .documentNumber(documentNumber)
        .salaryIncome(salaryIncome)
        .build();
  }

  public PersonResponse toResponse() {
    return PersonResponse.builder()
        .id(id)
        .name(name)
        .age(age)
        .documentNumber(documentNumber)
        .salaryIncome(salaryIncome)
        .build();
  }
}
