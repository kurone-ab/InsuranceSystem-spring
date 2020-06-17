package system.insurance.backend.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import java.util.Date;


@Service
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMail() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        message.setSubject("hi");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("mju.pheonix@gmail.com"));
        message.setText("hi");
        message.setSentDate(new Date());
        javaMailSender.send(message);
    }
}