
package tech.seekback.controllers;

import net.sf.jasperreports.engine.JRException;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;
import tech.seekback.services.UsuarioService;
import tech.seekback.services.tools.MailService;
import tech.seekback.services.tools.ReportService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gkentaurus
 */
@Named
@ViewScoped
public class TestController extends CustomController implements Serializable {

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private MailService mailService;

  @EJB
  private ReportService reportService;

  private List<String[]> list() {
    List<String[]> columnValues = new ArrayList<>();
    columnValues.add(new String[]{"ID", "id", Integer.class.getName(), "40"});
    columnValues.add(new String[]{"Nombre", "primerNombre", String.class.getName(), "100"});
    columnValues.add(new String[]{"Apellido", "primerApellido", String.class.getName(), "100"});
    columnValues.add(new String[]{"Tipo Doc", "tipoDoc.sigla", String.class.getName(), "50"});
    columnValues.add(new String[]{"Documento", "numeroDoc", String.class.getName(), "100"});
    return columnValues;
  }

  public void exportOnline() throws JRException, ConnectionExcep, IOException {
    reportService.JasperReportMaker(list(), "Lista de usuarios");
    reportService.generateReport(this.usuarioService.getAll());
    reportService.exportPdfOnWeb();
  }

  public void exportLocal() throws JRException, ConnectionExcep {
    reportService.JasperReportMaker(list(), "Lista de usuarios");
    reportService.generateReport(this.usuarioService.getAll());
    reportService.exportPdfOnLocalDisk();
  }

  public void encrypt() throws ConnectionExcep {
    List<Usuario> users = usuarioService.getAll();

    for (Usuario user : users) {
      if (user.getContrasena().length() < 20) {
        String pass = user.getContrasena();
        user.setContrasena(pass);
        usuarioService.update(user);
      }
    }
  }

  public void newEmail() throws MessagingException {
    String recipient = "camorenoc@outlook.com";
    String subject = "Mensaje de prueba desde JavaMail";
    String message = "<h1>Hola</h1>";
    mailService.sendEmail(recipient, subject, message);
  }
}
