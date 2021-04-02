package tech.seekback.controllers;

import tech.seekback.dao.interfaces.CotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;
import tech.seekback.models.Usuario;
import tech.seekback.services.CotizacionService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author danny
 */
@Named
@ViewScoped
public class CotizacionController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private CotizacionService cotizacionService;

  private Usuario usuario;
  private List<Cotizacion> cotizaciones;
  private Integer Idempleado;
  private String nombre;

  @PostConstruct
  public void Init() {
    this.Idempleado = loginController.getUsuario().getId();
    this.nombre = loginController.getUsuario().getPrimerNombre();
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public List<Cotizacion> getCotizaciones() throws ConnectionExcep {
    System.out.println("nombre " + this.nombre);
    cotizaciones = cotizacionService.getByIdEmpleado(this.Idempleado);
    for (Cotizacion cotizacione : cotizaciones) {
      System.out.println(cotizacione);
    }
    return cotizaciones;
  }

}
