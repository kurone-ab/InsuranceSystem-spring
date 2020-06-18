package system.insurance.backend.resource.service;

import javax.mail.MessagingException;

public interface MailService {
    void sendMail() throws MessagingException;
}
