package br.com.house.adapter.controller.payload.request;

import br.com.house.domain.model.Family;
import java.util.HashSet;
import java.util.List;
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
public class FamilyRequest {

  PersonRequest person;

  private List<PersonRequest> dependents;

  public Family toModel() {
    Family family = Family.builder()
        .person(person.toModel())
        .build();
    if (family.getPersons() == null) {
      family.setPersons(new HashSet<>());
    }
    for (PersonRequest personRequest : dependents) {
      family.getPersons().add(personRequest.toModel());
    }
    return family;
  }

}
