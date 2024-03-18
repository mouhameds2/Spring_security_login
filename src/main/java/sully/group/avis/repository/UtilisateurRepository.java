package sully.group.avis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sully.group.avis.entity.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
}
