package br.com.house.house.adapter.persistence.repository;

import br.com.house.house.adapter.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
