package sully.group.avis.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import sully.group.avis.entity.Validation;

@Service
public class NotifacationService {
    private MailSender mailSender;
    public void enoyerMail(Validation validation){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("metatchek@gmail.com");
        simpleMailMessage.setTo(validation.getUtilisateur().getEmail());
        simpleMailMessage.setSubject("votre d'activation est ");

      String text = String.format("bonjour votre code est ",
                validation.getUtilisateur().getName(),
                validation.getCode());
        simpleMailMessage.setText(text);
        mailSender.send(simpleMailMessage);
    }
}
