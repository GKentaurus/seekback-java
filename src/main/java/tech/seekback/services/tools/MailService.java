
package tech.seekback.services.tools;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * @author gkentaurus
 */
@Stateless
public class MailService {

  private final Properties properties = new Properties();
  private Session session;

  private void initSession() {
    String user = "gkentaurus@gmail.com";
    String password = "jbhfcwizhmezkafp";

    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", 25);
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.starttls.required", "false");
    properties.put("mail.smtp.mail.sender", user);
    properties.put("mail.smtp.user", user);
    properties.put("mail.smtp.password", password);

    session = Session.getDefaultInstance(properties);
  }

  public void sendEmail(String recipient, String subject, String message) throws MessagingException {
    initSession();
    MimeMessage mimeMessage = new MimeMessage(session);
    mimeMessage.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
    mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
    mimeMessage.setSubject(subject);
    mimeMessage.setText(message);
    coreMail(mimeMessage);
  }

  public void sendEmail(String sender, String recipient, String subject, String message) throws MessagingException {
    initSession();
    MimeMessage mimeMessage = new MimeMessage(session);
    mimeMessage.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
    mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
    mimeMessage.setFrom(new InternetAddress(sender));
    mimeMessage.setSubject(subject);
    mimeMessage.setText(message);
    coreMail(mimeMessage);
  }

  public void sendMail(List<String> recipients, String subject, String message) throws MessagingException {
    initSession();
    MimeMessage mimeMessage = new MimeMessage(session);
    mimeMessage.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
    mimeMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(String.join(",", (String[]) recipients.toArray())));
    mimeMessage.setSubject(subject);
    mimeMessage.setText(message);
    coreMail(mimeMessage);
  }

  public void sendMail(String sender, List<String> recipients, String subject, String message) throws MessagingException {
    initSession();
    MimeMessage mimeMessage = new MimeMessage(session);
    mimeMessage.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
    mimeMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(String.join(",", (String[]) recipients.toArray())));
    mimeMessage.setFrom(new InternetAddress(sender));
    mimeMessage.setSubject(subject);
    mimeMessage.setText(message);
    coreMail(mimeMessage);
  }

  private void coreMail(MimeMessage mimeMessage) throws MessagingException {
    Transport t = session.getTransport("smtp");
    t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
    t.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
    t.close();
  }
}
