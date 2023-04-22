package br.com.house.domain.port;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import java.util.List;
import java.util.Optional;

public interface PersistencePort {

  FamilyEntity addFamily(FamilyEntity familyEntity);

  Optional<FamilyEntity> loadFamily(Long id);

  List<FamilyEntity> loadFamilies();
}
