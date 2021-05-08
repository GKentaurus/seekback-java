/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Agenda;
import tech.seekback.models.TipoServicio;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.AdministradorService;
import tech.seekback.services.AgendaService;
import tech.seekback.services.ClienteService;
import tech.seekback.services.EmpleadoService;
import tech.seekback.services.EstadosAgendaService;
import tech.seekback.services.TipoServicioService;

/**
 *
 * @author danny
 */
@ManagedBean
@Named
@ViewScoped
public class SoliserviController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private AgendaService agendaService;

  @EJB
  private EstadosAgendaService estadosAgendaService;

  @EJB
  private ClienteService clienteService;

  @EJB
  private EmpleadoService empleadoService;

  @EJB
  private AdministradorService administradorService;

  @EJB
  private TipoServicioService tipoServicioService;

  private Agenda agenda;
  private Integer idCliente;
  private Integer idEmpleado;
  private Integer idTipoServicio;
  private Integer idUsuario;
  private Date fecha;
  private String obs;
  private List<Usuario> clientes;
  private List<Usuario> empleados;
  private List<TipoServicio> tipoServicio;

  @PostConstruct
  public void Init() {
    this.idUsuario = loginController.getUsuario().getId();
  }

  public SoliserviController() {
    agenda = new Agenda();
  }

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Agenda getAgenda() {
    return agenda;
  }

  public void setAgenda(Agenda agenda) {
    this.agenda = agenda;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }

  public Integer getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Integer idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public Integer getIdTipoServicio() {
    return idTipoServicio;
  }

  public void setIdTipoServicio(Integer idTipoServicio) {
    this.idTipoServicio = idTipoServicio;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) throws ParseException {
    this.fecha = fecha;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
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

  public List<Usuario> getEmpleados() {
    try {
      if (Objects.isNull(empleados)) {
        empleados = empleadoService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los clientes.....");
      ex.printStackTrace();
    }
    return empleados;
  }

  public List<TipoServicio> getTipoServicio() {
    try {
      if (Objects.isNull(tipoServicio)) {
        tipoServicio = tipoServicioService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los TipoServicio.....");
      ex.printStackTrace();
    }
    return tipoServicio;
  }
  //</editor-fold>

  public void createdByAdmin() throws ConnectionExcep, IOException {

    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setDeleted(false);
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.agenda.setFecha(this.fecha);
    this.agenda.setObservaciones(this.obs);
    this.agenda.setEstado(estadosAgendaService.getOne(1));
    this.agenda.setTipoServicio(tipoServicioService.getOne(this.idTipoServicio));
    this.agenda.setCliente(clienteService.getOne(this.idCliente));
    this.agenda.setEmpleado(empleadoService.getOne(this.idEmpleado));
    this.agenda.setAdministrador(administradorService.getOne(1));
    this.agenda.setTimestamps(timestamps);

    this.agenda = agendaService.create(agenda);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro Creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/soliservi.xhtml");
  }

  public void createdByEmpleado() throws ConnectionExcep, IOException {

    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setDeleted(false);
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.agenda.setFecha(this.fecha);
    this.agenda.setObservaciones(this.obs);
    this.agenda.setEstado(estadosAgendaService.getOne(1));
    this.agenda.setTipoServicio(tipoServicioService.getOne(this.idTipoServicio));
    this.agenda.setCliente(clienteService.getOne(this.idCliente));
    this.agenda.setEmpleado(empleadoService.getOne(this.idUsuario));
    this.agenda.setAdministrador(administradorService.getOne(1));
    this.agenda.setTimestamps(timestamps);

    this.agenda = agendaService.create(agenda);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro Creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/soliservi.xhtml");
  }

  public void createdByCliente() throws ConnectionExcep, IOException {

    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setDeleted(false);
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.agenda.setFecha(this.fecha);
    this.agenda.setObservaciones(this.obs);
    this.agenda.setEstado(estadosAgendaService.getOne(1));
    this.agenda.setTipoServicio(tipoServicioService.getOne(this.idTipoServicio));
    this.agenda.setCliente(clienteService.getOne(this.idUsuario));
    this.agenda.setEmpleado(empleadoService.getOne(2));
    this.agenda.setAdministrador(administradorService.getOne(1));
    this.agenda.setTimestamps(timestamps);

    this.agenda = agendaService.create(agenda);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro Creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/soliservi.xhtml");
  }
}
