package br.com.house.domain.service.impl;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.domain.exception.BusinessException;
import br.com.house.domain.model.Family;
import br.com.house.domain.model.Points;
import br.com.house.domain.port.PersistencePort;
import br.com.house.domain.service.FamilyService;
import br.com.house.domain.service.ScoreService;
import br.com.house.domain.utils.BuilderUtils;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl implements FamilyService {

  @Autowired
  ScoreService calculatorService;

  @Autowired
  PersistencePort persistencePort;

  public Points add(Family familyModel) throws BusinessException {

    persistencePort.addFamily(familyModel.toEntity());
    long score = calculatorService.score(familyModel);
    return Points.builder()
        .responsibleName(familyModel.getPerson().getName())
        .score(score)
        .build();
  }

  @Override
  public Family loadById(Long id) throws BusinessException {
    Optional<FamilyEntity> familyEntity = persistencePort.loadFamilyById(id);
    AtomicReference<Family> family = new AtomicReference<>();
    familyEntity.ifPresentOrElse(
        (value) -> family.set(value.toModel()),
        () -> {
          throw new BusinessException("Family not found");
        });
    return family.get();
  }

  @Override
  public List<Family> loadAll() throws BusinessException {
    List<FamilyEntity> familyEntityList = persistencePort.loadAllFamilies();
    List<Family> familyList = BuilderUtils.toFamily(familyEntityList);
    for (Family family : familyList) {
      family.setScore(calculatorService.score(family));
    }

    Collections.sort(familyList, (f1, f2) -> f2.getScore().compareTo(f1.getScore()));

    return familyList;
  }

  @Override
  public void delete(Long id) throws BusinessException {
    persistencePort.deleteFamily(id);
  }
}
