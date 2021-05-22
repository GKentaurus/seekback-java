
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
  private final String mimeMessageContextParams = "text/html; charset=UTF-8";
  private Session session;

  private void initSession() {
    String user = "gkentaurus@gmail.com";
    String password = "cezybvqlbicssjlr";

    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", 587);
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.starttls.required", "false");
    properties.put("mail.smtp.mail.sender", user);
    properties.put("mail.smtp.user", user);
    properties.put("mail.smtp.password", password);
    properties.put("mail.mime.charset", "UTF-8");

    session = Session.getDefaultInstance(properties);
  }

  private MimeMessage prepareMimeMessage(String recipients, String subject, String message) throws MessagingException {
    MimeMessage mimeMessage = new MimeMessage(session);
    mimeMessage.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
    mimeMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
    mimeMessage.setSubject(subject);
    mimeMessage.setContent(message, mimeMessageContextParams);
    return mimeMessage;
  }

  private MimeMessage prepareMimeMessage(String recipients, String subject, String message, String sender) throws MessagingException {
    MimeMessage mimeMessage = prepareMimeMessage(recipients, subject, message);
    mimeMessage.setFrom(new InternetAddress(sender));
    return mimeMessage;
  }

  public void sendEmail(String recipients, String subject, String message, String sender) throws MessagingException {
    initSession();
    MimeMessage mimeMessage = prepareMimeMessage(recipients, subject, message, sender);
    coreMail(mimeMessage);
  }

  public void sendEmail(String recipients, String subject, String message) throws MessagingException {
    initSession();
    MimeMessage mimeMessage = prepareMimeMessage(recipients, subject, message);
    coreMail(mimeMessage);
  }

  public void sendEmail(List<String> recipients, String subject, String message) throws MessagingException {
    sendEmail(listToString(recipients), subject, message);
  }

  public void sendEmail(List<String> recipients, String subject, String message, String sender) throws MessagingException {
    sendEmail(listToString(recipients), subject, message, sender);
  }

  private String listToString(List<String> recipients) {
    String strRecipients = "";
    for (String recipient : recipients) {
      strRecipients = strRecipients.concat(recipient).concat(", ");
    }
    return strRecipients;
  }

  private void coreMail(MimeMessage mimeMessage) throws MessagingException {
    Transport t = session.getTransport("smtp");
    t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
    t.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
    t.close();
    System.out.println("El correo se envió correctamente.");
  }
}
