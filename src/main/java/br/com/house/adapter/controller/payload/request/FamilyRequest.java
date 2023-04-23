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

  PersonRequest person;
  private List<PersonRequest> dependents;

  public Family toModel() {
    Family family = Family.builder()
        .person(person.toModel())
        .persons(new HashSet<>())
        .build();
    if (dependents != null) {
      dependents.forEach(personRequest -> {
        family.getPersons().add(personRequest.toModel());
      });
    }
    return family;
  }

}
