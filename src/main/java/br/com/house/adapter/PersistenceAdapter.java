package br.com.house.adapter;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.adapter.persistence.entity.PersonEntity;
import br.com.house.adapter.persistence.repository.FamilyRepository;
import br.com.house.adapter.persistence.repository.PersonRepository;
import br.com.house.domain.port.PersistencePort;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistenceAdapter implements PersistencePort {

  @Autowired
  FamilyRepository familyRepository;

  @Autowired
  PersonRepository personRepository;

  public FamilyEntity addFamily(FamilyEntity familyEntity) {
    PersonEntity person =
        personRepository.save(familyEntity.getPerson());
    familyEntity.setPerson(person);
    return familyRepository.save(familyEntity);
  }

  public Optional<FamilyEntity> loadFamily(Long id) {
    return familyRepository.findById(id);
  }

  public List<FamilyEntity> loadFamilies() {
    return familyRepository.findAll();
  }
}
