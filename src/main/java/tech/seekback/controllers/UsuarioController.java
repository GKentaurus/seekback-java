package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.*;
import tech.seekback.services.*;

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

  @EJB
  private CorreoService correoService;

  @EJB
  private RolService rolesService;

  private Correo correo;
  private String email;

  private Usuario usuario;
  private List<Usuario> usuarios;

  private Integer idUsuario;
  private Integer idRolUsuario;
  private List<Rol> roles;

  @PostConstruct
  public void init() {
    this.usuario = loginController.getUsuario();
    try {
      roles = rolesService.getAll();
    } catch (ConnectionExcep ex) {
      System.out.println("Error de la consulta 'ROLES'.");
    }
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

  public String getEmail(int idusu) throws ConnectionExcep {
    email = correoService.getByIdPrincipal(idusu).getCorreoElectronico();
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setUsuario(int usuario) throws ConnectionExcep {
    this.usuario = usuarioService.getOne(usuario);
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Integer getIdRolUsuario() {
    this.idRolUsuario = idRolUsuario;
    return idRolUsuario;
  }

  public void setIdRolUsuario(Integer idRolUsuario) {
    this.idRolUsuario = idRolUsuario;
    System.out.println(this.idRolUsuario);
  }

  public List<Rol> findAll() {
    return roles;
  }

  public void updaterol(Integer idusu) throws ConnectionExcep, IOException {
    this.usuario = usuarioService.getOne(idusu);

//    Date momentum = new Date();
//    this.usuario.getTimestamps().setUpdated_at(momentum);
    this.usuario.setRol(rolesService.getOne(this.idRolUsuario));
    usuarioService.update(usuario);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro actualizado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/admin/users.xhtml");

  }

}
