package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;
import tech.seekback.services.UsuarioService;
import tech.seekback.services.tools.UploadFileService;

/**
 * @author gkentaurus
 */
@Named
@ViewScoped
public class TestController extends CustomController implements Serializable {

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private UploadFileService uploadService;

  private Part part;

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

  public void setPart(Part part) {
    this.uploadService.setPart(part);
  }

  public Part getPart() {
    return this.uploadService.getPart();
  }

  public void uploadFile() throws IOException, ConnectionExcep, ParseException {
    this.uploadService.uploadFile();
  }
}
