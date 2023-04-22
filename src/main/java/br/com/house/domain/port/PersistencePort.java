package br.com.house.domain.port;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.domain.exception.BusinessException;
import java.util.List;
import java.util.Optional;

public interface PersistencePort {

  FamilyEntity addFamily(FamilyEntity familyEntity) throws BusinessException;

  Optional<FamilyEntity> loadFamilyById(Long id) throws BusinessException;

  List<FamilyEntity> loadAllFamilies() throws BusinessException;

  void deleteFamily(long id) throws BusinessException;
}
