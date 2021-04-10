package tech.seekback.controllers;

import java.io.IOException;
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
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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

  @Inject
  private LoginController loginController;

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
  private Integer idEstado;
  private Integer idCliente;
  private Integer idEmpleado;
  private Integer idUsuario;
  private Integer idAgenda;
  private Date fecha;
  private String obs;

  private List<Agenda> agendas;
  private List<Agenda> agendasByidEmpleado;
  private List<Agenda> agendasByidCliente;
  private List<EstadosAgenda> estadosAgendas;
  private List<TipoServicio> tipoServicio;

  @PostConstruct
  public void Init() {
    this.idUsuario = loginController.getUsuario().getId();
  }

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

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Integer getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(Integer idEstado) {
    this.idEstado = idEstado;
  }

  public Integer getIdAgenda() {
    return idAgenda;
  }

  public void setIdAgenda(Integer idAgenda) {
    this.idAgenda = idAgenda;
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

  public List<Agenda> getAgendasByidEmpleado() {
    try {
      if (Objects.isNull(agendasByidEmpleado)) {
        agendasByidEmpleado = agendaService.getByidEmpleado(this.idUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los Agenda.....");
      ex.printStackTrace();
    }
    return agendasByidEmpleado;
  }

  public List<Agenda> getAgendasByidCliente() {
    try {
      if (Objects.isNull(agendasByidCliente)) {
        agendasByidCliente = agendaService.getByidCliente(this.idUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los Agenda.....");
      ex.printStackTrace();
    }
    return agendasByidCliente;
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

  public void update(Integer idagenda) throws ConnectionExcep, IOException {
    this.agenda = this.agendaService.getOne(idagenda);

    this.agenda.setEmpleado(this.empleadoService.getOne(this.idEmpleado));
    this.agenda.setTipoServicio(this.tipoServicioService.getOne(this.idTipoServicio));
    this.agenda.setEstado(this.estadosAgendaService.getOne(this.idEstado));
    this.agenda.setObservaciones(this.obs);

    agendaService.update(agenda);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Actualizando Registro " + idagenda
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/soliservi.xhtml");

  }

  public void delete(Integer idagen) throws ConnectionExcep, IOException {
    try {
      agendaService.delete(agendaService.getOne(idagen));
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Eliminando Registro " + idagen
              + "\n######################################################################\n");

      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/frames/all/soliservi.xhtml");

    } catch (ConnectionExcep ex) {
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Error al eliminar el registro " + idagen
              + "\n######################################################################\n");
      ex.printStackTrace();

    }

  }

  public void create() throws ConnectionExcep, IOException {

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
            + "\n#\t  Registro actualizado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/soliservi.xhtml");
  }

  public void createc() throws ConnectionExcep, IOException {

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
            + "\n#\t  Registro actualizado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/soliservi.xhtml");
  }

  public void createe() throws ConnectionExcep, IOException {

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
            + "\n#\t  Registro actualizado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/soliservi.xhtml");
  }

}
