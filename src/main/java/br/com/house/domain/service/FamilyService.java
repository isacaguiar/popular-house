package br.com.house.domain.service;

import br.com.house.domain.exception.BusinessException;
import br.com.house.domain.model.Family;
import br.com.house.domain.model.Points;
import java.util.List;

public interface FamilyService {

  Points add(Family familyModel) throws BusinessException;

  Family loadById(Long id) throws BusinessException;

  List<Family> loadAll() throws BusinessException;

  void delete(Long id) throws BusinessException;
}
