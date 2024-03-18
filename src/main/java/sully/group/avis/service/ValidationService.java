package sully.group.avis.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sully.group.avis.entity.Utilisateur;
import sully.group.avis.entity.Validation;
import sully.group.avis.repository.ValidationRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class ValidationService {
    private ValidationRepository validationRepository;
    private NotifacationService notifacationService;


    public void validerUtilisateur(Utilisateur utilisateur){
        Validation validation = new Validation();
        validation.setUtilisateur(utilisateur);
        Instant instantCreation = Instant.now();
        validation.setDateCreation(instantCreation);
        Instant instantExpiration = instantCreation.plus(10, ChronoUnit.MINUTES);
        validation.setExpiration(instantExpiration);

        Random random = new Random();
       int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);
        validation.setCode(code);

        this.validationRepository.save(validation);
        this.notifacationService.enoyerMail(validation);

    }
    public  Validation lireEnfoctionDuCode(String code){
         return this.validationRepository.findByCode(code).orElseThrow(() -> new RuntimeException("code invalide"));


    }

}
