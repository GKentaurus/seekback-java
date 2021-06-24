/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import tech.seekback.models.Cotizacion;
import tech.seekback.models.Divisa;
import tech.seekback.models.TRM;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.ClienteService;
import tech.seekback.services.CotizacionService;
import tech.seekback.services.DivisaService;
import tech.seekback.services.EmpleadoService;
import tech.seekback.services.EstadosCotizacionService;
import tech.seekback.services.TRMService;

/**
 *
 * @author camorenoc
 */
@Named
@ViewScoped
public class GenCotizaController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private EmpleadoService empleadoService;

  @EJB
  private ClienteService clienteService;

  @EJB
  private TRMService trmService;

  @EJB
  private DivisaService divisaService;

  @EJB
  private EstadosCotizacionService estadosCotizacionService;

  @EJB
  private CotizacionService cotizacionService;

  private List<Divisa> divisas;
  private Integer IdCliente;
  private Integer IdUsuario;
  private List<Usuario> clientes;
  private List<TRM> trmsSeleccionada;
  private Integer IdDivisaseleccionada;
  private String motivo;
  private Cotizacion cotizacion;
  private Integer trm;

  @PostConstruct
  public void init() {
    this.IdUsuario = loginController.getUsuario().getId();
  }

  public GenCotizaController() {
    cotizacion = new Cotizacion();
  }

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public List<TRM> getTrmsSeleccionada() {
    return trmsSeleccionada;
  }

  public String getMotivo() {
    return motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  public Integer getIdCliente() {
    return IdCliente;
  }

  public void setIdCliente(Integer IdCliente) {
    this.IdCliente = IdCliente;
  }

  public Integer getIdDivisaseleccionada() {
    return IdDivisaseleccionada;
  }

  public Integer getIdUsuario() {
    return IdUsuario;
  }

  public void setIdUsuario(Integer IdUsuario) {
    this.IdUsuario = IdUsuario;
  }

  public Cotizacion getCotizacion() {
    return cotizacion;
  }

  public void setCotizacion(Cotizacion cotizacion) {
    this.cotizacion = cotizacion;
  }

  public Integer getTrm() {
    return trm;
  }

  public void setTrm(Integer trm) {
    this.trm = trm;
  }

  public List<Usuario> getClientes() {
    try {
      if (Objects.isNull(clientes)) {
        clientes = clienteService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los clientes.....");
      ex.printStackTrace();
    }
    return clientes;
  }

  public List<Divisa> getDivisas() {
    try {
      if (Objects.isNull(divisas)) {
        divisas = divisaService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los clientes.....");
      ex.printStackTrace();
    }
    return divisas;
  }

  public void setIdDivisaseleccionada(Integer IdDivisaseleccionada) {
    try {
      if (Objects.nonNull(IdDivisaseleccionada)) {
        trmsSeleccionada = trmService.getByidDivisa(IdDivisaseleccionada);
      } else {
        trmsSeleccionada = null;
      }
    } catch (ConnectionExcep ex) {
      ex.printStackTrace();
    }
    this.IdDivisaseleccionada = IdDivisaseleccionada;
  }
  //</editor-fold>

  public void createdByEmpleado() throws ConnectionExcep, IOException {

    // Creación de Timestamp para todos los procesos
    Date momentum = new Date();
    momentum.setTime((new Date()).getTime() + 691200000);

    this.cotizacion.setRequerimiento(this.motivo);
    this.cotizacion.setFecha(new Date());
    this.cotizacion.setTrm(trmService.getOne(1));
    this.cotizacion.setVencimiento(momentum);
    this.cotizacion.setEstado(estadosCotizacionService.getOne(1));
    this.cotizacion.setEmpleado(empleadoService.getOne(this.IdUsuario));
    this.cotizacion.setCliente(clienteService.getOne(this.IdCliente));
    this.cotizacion.setEmpleado(empleadoService.getOne(this.IdUsuario));
    this.cotizacion.setTimestamps(new Timestamps());
    this.cotizacion = cotizacionService.create(cotizacion);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/gencotiza.xhtml");
  }

  public void createdByCliente() throws ConnectionExcep, IOException {

    //this.cotizacion = new Cotizacion();
    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setDeleted(false);
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.cotizacion.setRequerimiento(motivo);
    this.cotizacion.setFecha(momentum);
    this.cotizacion.setVencimiento(momentum);
    this.cotizacion.setTrm(trmService.getOne(trm));
    this.cotizacion.setEstado(estadosCotizacionService.getOne(1));
    this.cotizacion.setCliente(clienteService.getOne(this.IdUsuario));
    this.cotizacion.setEmpleado(empleadoService.getOne(2));
    this.cotizacion.setTimestamps(timestamps);

    this.cotizacion = cotizacionService.create(cotizacion);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/gencotiza.xhtml");
  }
}
