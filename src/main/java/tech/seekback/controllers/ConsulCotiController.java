/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;
import tech.seekback.models.EstadosCotizacion;
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
  private CotizacionService cotizacionService;

  @EJB
  private EstadosCotizacionService estadosCotizacionService;

  private Integer IdUsuario;
  private List<Cotizacion> cotizaciones;
  private List<Cotizacion> cotizacionesByidCliente;
  private List<EstadosCotizacion> estados;

  @PostConstruct
  public void Init() {
    this.IdUsuario = loginController.getUsuario().getId();
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
}
