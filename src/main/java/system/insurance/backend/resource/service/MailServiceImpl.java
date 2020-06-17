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
    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        message.setSubject("[한화손해보험] 보험 가입 필요 서류 제출");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("mju.pheonix@gmail.com"));
        message.setText("안녕하세요, 고객님.\n한화손해보험을 찾아 주셔서 진심으로 감사드립니다.\n\n보험 가입에 필요한 정보를 편하게 제출하실 수 있는 사이트를 안내 드립니다.\n하단의 " +
                "링크에 접속하셔서 정보를 빠짐 없이 작성 후 제출해 주시기 바랍니다.\n\n[링크]\nhttp://localhost:3000/customer/register\n\n 감사합니다.");
        message.setSentDate(new Date());
        javaMailSender.send(message);
    }
}