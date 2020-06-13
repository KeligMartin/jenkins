package esgi.todolist.services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailService {

    public static void main(String[] args) {
        sendMail("j", "s", "s");
    }

    public static void sendMail(String mail, String object, String content){
        final String username = "test.unitaire.tp@gmail.com";
        final String password = "TestUnitaire1234!";

        System.out.println(mail);

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(mail));
            message.setSubject(object);
            message.setText(content);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}