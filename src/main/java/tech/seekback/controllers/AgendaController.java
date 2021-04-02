package tech.seekback.controllers;

import tech.seekback.models.Agenda;
import tech.seekback.models.EstadosAgenda;
import tech.seekback.models.TipoServicio;
import tech.seekback.services.AgendaService;
import tech.seekback.services.EstadosAgendaService;
import tech.seekback.services.TipoServicioService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.ManagedBean;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.AdministradorService;
import tech.seekback.services.ClienteService;
import tech.seekback.services.EmpleadoService;

/**
 * @author danny
 */
@ManagedBean
@Named
@ViewScoped
public class AgendaController extends CustomController implements Serializable {

  @EJB
  private AdministradorService administradorService;

  @EJB
  private EmpleadoService empleadoService;

  @EJB
  private ClienteService clienteService;

  @EJB
  private EstadosAgendaService estadosAgendaService;

  @EJB
  private TipoServicioService tipoServicioService;

  @EJB
  private AgendaService agendaService;

  private Agenda agenda;

  private Integer idTipoServicio;
  private Integer idCliente;
  private Integer idEmpleado;
  private Date fecha;
  private String obs;

  private List<Agenda> agendas;
  private List<EstadosAgenda> estadosAgendas;
  private List<TipoServicio> tipoServicio;

  public AgendaController() {
    agenda = new Agenda();
  }

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Agenda getAgenda() {
    return agenda;
  }

  public void setAgenda(Agenda agenda) {
    this.agenda = agenda;
  }

  public Integer getIdTipoServicio() {
    return idTipoServicio;
  }

  public void setIdTipoServicio(Integer idTipoServicio) {
    this.idTipoServicio = idTipoServicio;
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
  //</editor-fold>

  public List<Agenda> getAgendas() {
    try {
      if (Objects.isNull(agendas)) {
        agendas = agendaService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los Agenda.....");
      ex.printStackTrace();
    }
    return agendas;
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

  public List<EstadosAgenda> getEstadosAgendas() {
    try {
      if (Objects.isNull(estadosAgendas)) {
        estadosAgendas = estadosAgendaService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los EstadosAgenda.....");
      ex.printStackTrace();
    }
    return estadosAgendas;
  }

  public void create() throws ConnectionExcep {

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
  }

}
