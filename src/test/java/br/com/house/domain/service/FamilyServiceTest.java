package br.com.house.domain.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.domain.exception.BusinessException;
import br.com.house.domain.model.Family;
import br.com.house.domain.port.PersistencePort;
import br.com.house.domain.service.impl.FamilyServiceImpl;
import br.com.house.utils.BuilderUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
    FamilyService.class,
    FamilyServiceImpl.class
})
class FamilyServiceTest {

  @Autowired
  private FamilyService familyService;

  @MockBean
  PersistencePort persistencePort;

  @MockBean
  ScoreService scoreService;

  @Test
  void add() {
    Long score = 7L;
    FamilyEntity familyEntity = BuilderUtils.loadFamilyEntity();
    Family family = familyEntity.toModel();
    when(persistencePort.addFamily(familyEntity)).thenReturn(familyEntity);
    when(scoreService.score(family)).thenReturn(score);

    familyService.add(familyEntity.toModel());

    verify(persistencePort).addFamily(any());
    verify(scoreService).score(any());
  }

  @Test
  void loadById() {
    Long id = 10L;
    Optional<FamilyEntity> familyEntity = Optional.of(BuilderUtils.loadFamilyEntity());
    when(persistencePort.loadFamilyById(id)).thenReturn(familyEntity);

    familyService.loadById(id);

    verify(persistencePort).loadFamilyById(id);
  }

  @Test
  void loadByIdWhenBusinessException() {
    Long id = 10L;
    Optional<FamilyEntity> familyEntity = Optional.of(BuilderUtils.loadFamilyEntity());
    when(persistencePort.loadFamilyById(id)).thenReturn(familyEntity);

    assertThrows(BusinessException.class, () -> Optional
        .ofNullable(familyService.loadById(null))
        .orElseThrow(BusinessException::new));

  }

  @Test
  void loadAll() {
    Long id = 10L;
    List<FamilyEntity> familyEntityList = BuilderUtils.loadFamiliesEntities();
    when(persistencePort.loadAllFamilies()).thenReturn(familyEntityList);

    familyService.loadAll();

    verify(persistencePort).loadAllFamilies();
  }

  @Test
  void delete() {
    Long id = 10L;
    List<FamilyEntity> familyEntityList = BuilderUtils.loadFamiliesEntities();
    doNothing().when(persistencePort).deleteFamily(id);

    familyService.delete(id);

    verify(persistencePort).deleteFamily(id);
  }

}