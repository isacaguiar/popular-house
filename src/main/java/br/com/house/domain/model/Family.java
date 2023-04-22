package br.com.house.domain.model;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import java.math.BigDecimal;
import java.util.HashSet;
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

  Set<Person> persons;

  Person person;

  public BigDecimal getIncome() {
    BigDecimal income = person.getSalaryIncome();
    for (Person person : persons) {
      if (person.getSalaryIncome() != null) {
        income = income.add(person.getSalaryIncome());
      }
    }

    /*persons.forEach(
        person -> person.getSalaryIncome()
    );*/
    return income;
  }

  public long getDependents() {
    long temp = persons.stream().filter(
        person -> person.getAge() < 18
    ).count();
    return temp;
  }

  public FamilyEntity toEntity() {
    FamilyEntity family = FamilyEntity.builder()
        .person(person.toEntity())
        .build();
    if (family.getPersons() == null) {
      family.setPersons(new HashSet<>());
    }
    for (Person person : persons) {
      family.getPersons().add(person.toEntity(family));
    }
    return family;
  }
}
