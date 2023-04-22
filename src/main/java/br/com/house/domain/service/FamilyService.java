package br.com.house.domain.service;

import br.com.house.domain.model.Family;
import br.com.house.domain.model.Points;
import java.util.List;

public interface FamilyService {

  Points add(Family familyModel);

  Family loadFamily(Long id);

  List<Family> loadFamilies();
}
