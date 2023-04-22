package br.com.house.utils;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.adapter.persistence.entity.PersonEntity;
import br.com.house.domain.model.Family;
import br.com.house.domain.model.Person;
import br.com.house.domain.model.Points;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuilderUtils {

  public static Points getPoint(String name, int score) {
    return Points.builder()
        .score(score)
        .responsibleName(name)
        .build();
  }

  public static Family loadFamily() {
    return getFamily(loadPerson(), loadPersons());
  }

  public static List<Family> loadFamilies() {
    List<Family> familyList = new ArrayList<>();
    familyList.add(loadFamily());
    return familyList;
  }

  public static Set<Person> loadPersons() {
    Set<Person> personSet = new HashSet<>();
    personSet.add(getPerson("Pedro", "123", 15));
    personSet.add(getPerson("Caio", "321", 12));
    return personSet;
  }

  public static Family getFamily(Person person, Set<Person> persons) {
    return Family.builder()
        .person(person)
        .id(1L)
        .persons(persons)
        .build();
  }

  public static Person loadPerson() {
    return getPerson("Sara", "123", new BigDecimal(100), 10);
  }

  public static Person getPerson(String name, String documentNumber, int age) {
    return getPerson(name, documentNumber, null, age);
  }

  public static Person getPerson(String name, String documentNumber, BigDecimal income, int age) {
    return Person.builder()
        .salaryIncome(income)
        .documentNumber(documentNumber)
        .age(age)
        .name(name)
        .id(12L)
        .build();
  }

  public static FamilyEntity loadFamilyEntity() {
    return getFamilyEntity(loadPersonEntity(), new HashSet<>());
  }

  public static FamilyEntity getFamilyEntity(PersonEntity person, Set<PersonEntity> persons) {
    return FamilyEntity.builder()
        .person(person)
        .id(1L)
        .persons(persons)
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
