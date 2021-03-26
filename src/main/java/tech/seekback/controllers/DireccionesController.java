
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;
import tech.seekback.models.Direccion;
import tech.seekback.models.Usuario;
import tech.seekback.services.DireccionService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author danny
 */
@ViewScoped
@Named
public class DireccionesController extends CustomController implements Serializable {

  @EJB
  private DireccionService direccionesService;
  private Direccion direccion;
  private List<Direccion> direcciones;

  public DireccionesController() {
    direccion = new Direccion();
    direccion.setCiudad(new Ciudad());
    direccion.setUsuario(new Usuario());
  }

  @PostConstruct
  public void ejec() {

  }

  public Direccion getDireccion() {
    return direccion;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public List<Direccion> getDirecciones() throws ConnectionExcep {
    try {
      if (Objects.isNull(direcciones)) {
        direcciones = direccionesService.getAll();
      }
    } catch (ConnectionExcep ex) {
      System.out.println("Error al consultar los direcciones.....");
      ex.printStackTrace();
    }

    return direcciones;
  }

  public void create() throws ConnectionExcep {
    try {
      direccionesService.create(direccion);
    } catch (ConnectionExcep ex) {
      System.out.println("Error al registrar direccion");
      ex.printStackTrace();
    }
  }
}
