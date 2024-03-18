package sully.group.avis.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sully.group.avis.entity.Role;
import sully.group.avis.entity.Utilisateur;
import sully.group.avis.entity.Validation;
import sully.group.avis.enums.TypeDeRole;
import sully.group.avis.repository.UtilisateurRepository;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UtilisateurService {
    private UtilisateurRepository utilisateurRepository;
   private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ValidationService validationService;

    public void inscription(Utilisateur utilisateur){
        if(!utilisateur.getEmail().contains("@") ){
            throw new RuntimeException("Email invalid");
        }
        if(!utilisateur.getEmail().contains(".") ){
            throw new RuntimeException("Email invalid");
        }
        Optional<Utilisateur>  optionalUtilisateur = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
        if(optionalUtilisateur.isPresent()){
            throw new RuntimeException("Vous avez déja un compte");
        }

        String mdpCrypte = this.bCryptPasswordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(mdpCrypte);
        Role roleUtilisateur = new Role();
        roleUtilisateur.setTypeDeRole(TypeDeRole.USER);
        utilisateur.setRole(roleUtilisateur);
       utilisateur=  this.utilisateurRepository.save(utilisateur);
    this.validationService.validerUtilisateur(utilisateur);
    }

    public void activation(Map<String, String> activation) {
        Validation validation = this.validationService.lireEnfoctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw new RuntimeException("Votre a expiré");
        }

        Utilisateur utilisateurAcitver = this.utilisateurRepository.findById(validation.getUtilisateur().getId()).orElseThrow(() -> new RuntimeException("Utilsateur inconnu"));
     utilisateurAcitver.setActif(true);
     this.utilisateurRepository.save(utilisateurAcitver);
    }
}
