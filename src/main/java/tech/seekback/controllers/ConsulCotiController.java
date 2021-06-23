/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
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
import tech.seekback.models.Cotizacion;
import tech.seekback.models.EstadosCotizacion;
import tech.seekback.services.ClienteService;
import tech.seekback.services.CotizacionService;
import tech.seekback.services.EstadosCotizacionService;

/**
 *
 * @author camorenoc
 */
@Named
@ViewScoped
public class ConsulCotiController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private ClienteService clienteService;

  @EJB
  private CotizacionService cotizacionService;

  @EJB
  private EstadosCotizacionService estadosCotizacionService;

  private Integer IdUsuario;
  private Cotizacion cotizacion;
  private List<Cotizacion> cotizaciones;
  private List<Cotizacion> cotizacionesByidCliente;
  private List<EstadosCotizacion> estados;
  private Integer IdCliente;
  private String Motivo;
  private Integer IdEstado;

  @PostConstruct
  public void Init() {
    this.IdUsuario = loginController.getUsuario().getId();
  }

  public ConsulCotiController() {
    cotizacion = new Cotizacion();
  }

  public Integer getIdCliente() {
    return IdCliente;
  }

  public void setIdCliente(Integer IdCliente) {
    this.IdCliente = IdCliente;
  }

  public String getMotivo() {
    return Motivo;
  }

  public void setMotivo(String Motivo) {
    this.Motivo = Motivo;
  }

  public Integer getIdEstado() {
    return IdEstado;
  }

  public void setIdEstado(Integer IdEstado) {
    this.IdEstado = IdEstado;
  }

  public CotizacionService getCotizacionService() {
    return cotizacionService;
  }

  public void setCotizacionService(CotizacionService cotizacionService) {
    this.cotizacionService = cotizacionService;
  }

  public EstadosCotizacionService getEstadosCotizacionService() {
    return estadosCotizacionService;
  }

  public void setEstadosCotizacionService(EstadosCotizacionService estadosCotizacionService) {
    this.estadosCotizacionService = estadosCotizacionService;
  }

  public Integer getIdUsuario() {
    return IdUsuario;
  }

  public void setIdUsuario(Integer IdUsuario) {
    this.IdUsuario = IdUsuario;
  }

  public List<EstadosCotizacion> getEstados() {
    return estados;
  }

  public void setEstados(List<EstadosCotizacion> estados) {
    this.estados = estados;
  }

  public List<Cotizacion> getCotizaciones() throws ConnectionExcep {
    try {
      if (Objects.isNull(cotizaciones)) {
        cotizaciones = cotizacionService.getByIdEmpleado(this.IdUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los soporteTecnico.....");
      ex.printStackTrace();
    }
    return cotizaciones;
  }

  public List<EstadosCotizacion> getEstadosCotizacion() {
    try {
      if (Objects.isNull(estados)) {
        estados = this.estadosCotizacionService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los estadosFidelizacion.....");
      ex.printStackTrace();
    }
    return estados;
  }

  public List<Cotizacion> getCotizacionesByidCliente() {
    try {
      if (Objects.isNull(cotizacionesByidCliente)) {
        cotizacionesByidCliente = cotizacionService.getByIdCliente(this.IdUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los soporteTecnico.....");
      ex.printStackTrace();
    }
    return cotizacionesByidCliente;
  }

  public void Update(Integer Idcoti) throws ConnectionExcep, IOException {
    this.cotizacion = this.cotizacionService.getOne(Idcoti);

    this.cotizacion.setEstado(this.estadosCotizacionService.getOne(this.IdEstado));
    this.cotizacion.setRequerimiento(this.Motivo);

    cotizacionService.update(cotizacion);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Actualizando Registro " + Idcoti
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/consulcoti.xhtml");

  }

  public void Delete(Integer Idcoti) throws ConnectionExcep, IOException {
    try {
      cotizacionService.delete(cotizacionService.getOne(Idcoti));
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Eliminando Registro " + Idcoti
              + "\n######################################################################\n");

      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/frames/all/consulcoti.xhtml");

    } catch (ConnectionExcep ex) {
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Error al eliminar el registro " + Idcoti
              + "\n######################################################################\n");
      ex.printStackTrace();

    }
  }

}
