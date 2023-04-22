package br.com.house.domain.port;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.house.adapter.PersistenceAdapter;
import br.com.house.adapter.persistence.entity.FamilyEntity;
import br.com.house.adapter.persistence.entity.PersonEntity;
import br.com.house.adapter.persistence.repository.FamilyRepository;
import br.com.house.adapter.persistence.repository.PersonRepository;
import br.com.house.domain.exception.BusinessException;
import br.com.house.utils.BuilderUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PersistencePort.class, PersistenceAdapter.class})
class PersistencePortTest {

  @Autowired
  PersistencePort persistencePort;

  @MockBean
  FamilyRepository familyRepository;

  @MockBean
  PersonRepository personRepository;

  @Test
  void addWithSuccess() {

    FamilyEntity familyEntity = BuilderUtils.loadFamilyEntity();

    PersonEntity personEntity = BuilderUtils.loadPersonEntity();

    when(personRepository.save(any())).thenReturn(personEntity);
    when(familyRepository.save(any())).thenReturn(familyEntity);

    FamilyEntity retorno = persistencePort.addFamily(familyEntity);

    assertNotNull(retorno);
    assertNotNull(retorno.getPerson().getName());

    verify(personRepository).save(any());
    verify(familyRepository).save(any());
  }

  @Test
  void addWithThrowsBusinessException() throws Exception {
    FamilyEntity familyEntity = BuilderUtils.loadFamilyEntity();

    doThrow(new BusinessException("Error")).when(personRepository).save(any());

    assertThrows(BusinessException.class, () -> persistencePort.addFamily(familyEntity));

    verify(personRepository).save(any());
    verify(familyRepository, times(0)).save(any());
  }

}