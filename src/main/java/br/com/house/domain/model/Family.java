package br.com.house.domain.model;

import br.com.house.adapter.controller.payload.response.FamilyResponse;
import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.domain.utils.BuilderUtils;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
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
public class Family {

  private Long id;
  private Set<Person> persons;
  private Person person;
  private Long score;

  public BigDecimal getIncome() {
    BigDecimal income = person.getSalaryIncome();

    income = income.add(persons.stream()
        .map(Person::getSalaryIncome)
        .filter(Objects::nonNull)
        .reduce(BigDecimal.ZERO, BigDecimal::add));
    return income;
  }

  public long getDependentsOver18YearsOld() {
    return persons.stream().filter(
        person -> person.getAge() < 18
    ).count();
  }

  public long getDependents() {
    return persons.size();
  }

  public FamilyEntity toEntity() {
    FamilyEntity family = FamilyEntity.builder()
        .person(person.toEntity())
        .persons(new HashSet<>())
        .build();
    persons.forEach(person1 -> {
      family.getPersons().add(person1.toEntity(family));
    });
    return family;
  }

  public FamilyResponse toReponse() {
    return FamilyResponse.builder()
        .id(id)
        .totalIncome(getIncome())
        .dependents(getDependents())
        .dependentsOver18YearsOld(getDependentsOver18YearsOld())
        .score(score)
        .person(person.toResponse())
        .persons(BuilderUtils.toResponse(persons))
        .build();
  }
}
