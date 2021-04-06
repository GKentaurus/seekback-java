package tech.seekback.controllers;

import java.io.IOException;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Rol;
import tech.seekback.services.RolService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.UsuarioService;

/**
 * @author gkentaurus
 */
@Named
@ViewScoped
public class RolesController extends CustomController implements Serializable {

  @EJB
  private RolService rolesService;

  @EJB
  private UsuarioService usuarioService;

  private List<Rol> roles;
  private Usuario usuario;
  private List<Usuario> listaUsuarios;
  private Integer idUsuario;
  private Integer idRolUsuario;

  private RolesController() {
    usuario = new Usuario();
  }

  @PostConstruct
  public void init() {
    try {
      roles = rolesService.getAll();
    } catch (ConnectionExcep ex) {
      System.out.println("Error de la consulta 'ROLES'.");
    }
  }

  public Usuario getUsuario() {
    return usuario;
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
    return idRolUsuario;
  }

  public void setIdRolUsuario(Integer idRolUsuario) {
    this.idRolUsuario = idRolUsuario;
  }

  public List<Rol> getAll() {
    return roles;
  }

  public void updaterol() throws ConnectionExcep, IOException {
    this.usuario = usuarioService.getOne(this.idUsuario);

    Date momentum = new Date();
    this.usuario.getTimestamps().setUpdated_at(momentum);

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
