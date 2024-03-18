package sully.group.avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sully.group.avis.entity.Avis;

public interface AvisRepository extends JpaRepository<Avis, Integer> {
}
