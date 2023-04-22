package br.com.house.domain.utils;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.adapter.persistence.entity.PersonEntity;
import br.com.house.domain.model.Family;
import br.com.house.domain.model.Person;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuilderUtils {

  public static List<Family> toFamily(List<FamilyEntity> familyEntityList) {
    List<Family> familyList = new ArrayList<>();
    familyEntityList.forEach(
        familyEntity -> {
          familyList.add(familyEntity.toModel());
        }
    );
    return familyList;
  }

  public static Set<Person> toPerson(Set<PersonEntity> personEntitySet) {
    Set<Person> personList = new HashSet<>();
    personEntitySet.forEach(
        personEntity -> {
          personList.add(personEntity.toModel());
        }
    );
    return personList;
  }
}
