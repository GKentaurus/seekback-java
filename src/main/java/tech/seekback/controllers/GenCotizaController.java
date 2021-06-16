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

  public void setIdDivisaseleccionada(Integer IdDivisaseleccionada) {
    System.out.println("divi sele 2 " + IdDivisaseleccionada);
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

  public void createe() throws ConnectionExcep, IOException {

    this.cotizacion = new Cotizacion();

    // Creación de Timestamp para todos los procesos
    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.cotizacion.setRequerimiento(motivo);
    this.cotizacion.setFecha(momentum);
    this.cotizacion.setTrm(trmService.getOne(trm));
    this.cotizacion.setEstado(estadosCotizacionService.getOne(1));
    this.cotizacion.setCliente(clienteService.getOne(this.IdCliente));
    this.cotizacion.setEmpleado(empleadoService.getOne(this.IdUsuario));
    this.cotizacion = cotizacionService.create(cotizacion);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/gencotiza.xhtml");
  }

  public void test() {
    System.out.println("\n\n\nPROBANDO PROBANDO \n\n\n");
  }

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
}
