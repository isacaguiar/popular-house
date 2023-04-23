package br.com.house.adapter.persistence.entity;

import br.com.house.domain.model.Family;
import br.com.house.domain.utils.BuilderUtils;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "house_family")
public class FamilyEntity {

  @Id
  @GeneratedValue(generator = "seq_family", strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<PersonEntity> persons;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "person_id", referencedColumnName = "id")
  private PersonEntity person;

  public Family toModel() {
    return Family.builder()
        .id(id)
        .person(person.toModel())
        .persons(BuilderUtils.toPerson(persons))
        .build();
  }

}
