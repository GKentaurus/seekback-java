/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services.tools;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author camorenoc
 */
@Stateless
public class MailService {

  private final Properties properties = new Properties();

  private final String user = "gkentaurus@gmail.com";
  private final String password = "jbhfcwizhmezkafp";

  private Session session;

  private void init() {

    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", 25);
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.starttls.required", "false");
    properties.put("mail.smtp.mail.sender", user);
    properties.put("mail.smtp.user", user);

    session = Session.getDefaultInstance(properties);
  }

  public void sendEmail(String recipient, String subject, String message) {
    init();
    try {
      MimeMessage mimeMessage = new MimeMessage(session);
      mimeMessage.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
      mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
      mimeMessage.setSubject(subject);
      mimeMessage.setText(message);

      Transport t = session.getTransport("smtp");
      t.connect((String) properties.get("mail.smtp.user"), password);
      t.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
      t.close();
    } catch (MessagingException exp) {
      throw new RuntimeException(exp);
    }
  }

}
