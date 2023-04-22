package br.com.house.adapter.persistence.repository;

import br.com.house.adapter.persistence.entity.FamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyEntity, Long> {
}
