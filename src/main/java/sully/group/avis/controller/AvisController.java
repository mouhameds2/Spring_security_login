package sully.group.avis.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sully.group.avis.entity.Avis;
import sully.group.avis.service.AvisService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "avis")
@RestController
@AllArgsConstructor
public class AvisController {
    private final AvisService avisService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createAvis(@RequestBody Avis avis){
        this.avisService.createAvis(avis);
            }
}
