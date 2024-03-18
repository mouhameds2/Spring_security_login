package sully.group.avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sully.group.avis.entity.Validation;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation, Integer> {

    Optional<Validation>  findByCode(String code);
}
