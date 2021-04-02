package tech.seekback.controllers;

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
  private Integer idUsuario;
  private Integer idRolUsuario;

//  public RolesController() {
//    usuario = new Usuario();
//  }
  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
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
    System.out.println("rol usuario seter: " + this.idRolUsuario);
  }

  @PostConstruct
  public void init() {
    try {
      roles = rolesService.getAll();
    } catch (ConnectionExcep ex) {
      System.out.println("Error de la consulta 'ROLES'.");
    }
  }

  public List<Rol> getAll() {
    return roles;
  }

  public void updaterol() {

    System.out.println(" olololo ");

    // Creación de Timestamp para todos los procesos
//    Timestamps timestamps = new Timestamps();
//    Date momentum = new Date();
//    timestamps.setUpdated_at(momentum);
//
//    this.usuario.setRol(rolesService.getOne(this.idRolUsuario));
//    this.usuario.setTimestamps(timestamps);
//    usuarioService.update(usuario);
    System.out.println("rol usuario metodo: " + this.idRolUsuario);

  }

}
