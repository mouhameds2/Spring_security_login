package sully.group.avis.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sully.group.avis.entity.Avis;
import sully.group.avis.repository.AvisRepository;
@AllArgsConstructor
@Service
public class AvisService {
    private final AvisRepository avisRepository;

    public  void createAvis(Avis avis){
        this.avisRepository.save(avis);
    }
}
