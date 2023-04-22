package br.com.house.adapter;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.adapter.persistence.entity.PersonEntity;
import br.com.house.adapter.persistence.repository.FamilyRepository;
import br.com.house.adapter.persistence.repository.PersonRepository;
import br.com.house.domain.exception.BusinessException;
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

  public FamilyEntity addFamily(FamilyEntity familyEntity) throws BusinessException {
    FamilyEntity familyEntityReturn;
    try {
      PersonEntity person = personRepository.save(familyEntity.getPerson());
      familyEntity.setPerson(person);
      familyEntityReturn = familyRepository.save(familyEntity);
    } catch (Exception exception) {
      throw new BusinessException(exception.getMessage(), exception);
    }
    return familyEntityReturn;
  }

  public Optional<FamilyEntity> loadFamilyById(Long id) throws BusinessException {
    Optional<FamilyEntity> familyEntity;
    try {
      familyEntity = familyRepository.findById(id);
    } catch (Exception exception) {
      throw new BusinessException(exception.getMessage(), exception);
    }
    return familyEntity;
  }

  public List<FamilyEntity> loadAllFamilies() throws BusinessException {
    List<FamilyEntity> familyEntityList;
    try {
      familyEntityList = familyRepository.findAll();
    } catch (Exception exception) {
      throw new BusinessException(exception.getMessage(), exception);
    }
    return familyEntityList;
  }

  @Override
  public void deleteFamily(long id) throws BusinessException {
    try {
      familyRepository.deleteById(id);
    } catch (Exception exception) {
      throw new BusinessException(exception.getMessage(), exception);
    }
  }
}
