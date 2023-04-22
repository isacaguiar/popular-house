package br.com.house.domain.utils;

import br.com.house.adapter.controller.payload.response.FamilyResponse;
import br.com.house.adapter.controller.payload.response.PersonResponse;
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

  public static List<FamilyResponse> toResponse(List<Family> familyList) {
    List<FamilyResponse> familyResponseList = new ArrayList<>();
    familyList.forEach(
        familyEntity -> {
          familyResponseList.add(familyEntity.toReponse());
        }
    );
    return familyResponseList;
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

  public static Set<PersonResponse> toResponse(Set<Person> personSet) {
    Set<PersonResponse> personResponseSet = new HashSet<>();
    personSet.forEach(
        person -> {
          personResponseSet.add(person.toResponse());
        }
    );
    return personResponseSet;
  }
}
