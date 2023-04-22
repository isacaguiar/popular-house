package br.com.house.utils;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.adapter.persistence.entity.PersonEntity;
import br.com.house.domain.model.Points;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class BuilderUtils {

  public static Points getPoint(String name, int score) {
    return Points.builder()
        .score(score)
        .responsibleName(name)
        .build();
  }

  public static FamilyEntity loadFamilyEntity() {
    return getFamiliEntity(loadPersonEntity(), new HashSet<>());
  }

  public static FamilyEntity getFamiliEntity(PersonEntity person, Set<PersonEntity> persons) {
    return FamilyEntity.builder()
        .person(person)
        .id(1L)
        .persons(persons)
        .persons(new HashSet<>())
        .build();
  }

  public static PersonEntity loadPersonEntity() {
    return getPersonEntity("Sara", "123", new BigDecimal(100), 10);
  }

  public static PersonEntity getPersonEntity(String name,
                                             String documentNumber,
                                             BigDecimal income,
                                             int age) {
    return PersonEntity.builder()
        .salaryIncome(income)
        .documentNumber(documentNumber)
        .age(age)
        .name(name)
        .id(12L)
        .build();
  }
}
