package sully.group.avis.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sully.group.avis.entity.Utilisateur;
import sully.group.avis.service.UtilisateurService;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(consumes = APPLICATION_JSON_VALUE,path = "inscription")
public class UtilisateurController {
    private UtilisateurService utilisateurService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void inscription(@RequestBody Utilisateur utilisateur){
        this.utilisateurService.inscription(utilisateur);

        log.info("====inscription==== ");
    }
    @PostMapping(path = "activation")
    public void activation(@RequestBody Map<String, String> activation){

        this.utilisateurService.activation(activation);

        log.info("====activation==== ");
    }
}
