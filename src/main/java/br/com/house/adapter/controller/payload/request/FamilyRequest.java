package br.com.house.adapter.controller.payload.request;

import br.com.house.domain.model.Family;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class FamilyRequest {

  private long id;
  PersonRequest person;
  private List<PersonRequest> dependents;

  public Family toModel() {
    Family family = Family.builder()
        .id(id)
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
