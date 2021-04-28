package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.*;
import tech.seekback.services.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author gkentaurus
 */
@Named
@ViewScoped
public class UsuarioController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private UsuarioService usuarioService;

  private Usuario usuario;
  private List<Usuario> usuarios;

  @PostConstruct
  public void init() {
    this.usuario = loginController.getUsuario();
  }

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public List<Usuario> getUsuarios() throws ConnectionExcep {
    try {
      if (Objects.isNull(usuarios)) {
        usuarios = usuarioService.getAll();
      }
    } catch (ConnectionExcep ex) {
      System.out.println("Error al consultar los usuarios.....");
      ex.printStackTrace();
    }
    return usuarios;
  }

  //</editor-fold>
  public void deleteu(Integer idusu) throws ConnectionExcep, IOException {
    try {
      usuarioService.delete(usuarioService.getOne(idusu));
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Eliminando Registro " + idusu
              + "\n######################################################################\n");

      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/frames/admin/users.xhtml");

    } catch (ConnectionExcep ex) {
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Error al eliminar el registro " + idusu
              + "\n######################################################################\n");
      ex.printStackTrace();
    }
  }

  public boolean confirmRole(String rolName) {
    return usuario.getRol().getNombreRol().equals(rolName);
  }

}
