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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.ClienteService;
import tech.seekback.services.EmpleadoService;
import tech.seekback.services.UsuarioService;

/**
 * @author danny
 */
@Named
@ViewScoped
public class AgendaController extends CustomController implements Serializable {

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private ClienteService clienteService;

  @EJB
  private EmpleadoService empleadoService;

  @EJB
  private EstadosAgendaService estadosAgendaService;

  @EJB
  private TipoServicioService tipoServicioService;

  @EJB
  private AgendaService agendaService;

  private Usuario usuario;
  private Agenda agenda;
  private EstadosAgenda estadosAgenda;
  private TipoServicio tipoServicios;

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
    System.out.println("fecha1 " + fecha);
    String fechaa = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
    System.out.println("fecha2 " + fechaa);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    Date dates = format.parse(fechaa);
    System.out.println("fecha3 " + dates);
    this.fecha = dates;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

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

    System.out.println("cliente " + this.idCliente);
    System.out.println("empleado " + this.idEmpleado);
    System.out.println("servicio " + this.idTipoServicio);
    System.out.println("fecha " + fecha);
    System.out.println("obser " + this.obs);

    // Creación de Timestamp para todos los procesos
    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    System.out.println("timestamp " + momentum);
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.agenda.setFecha(fecha);
    this.agenda.setObservaciones(this.obs);
    this.agenda.setEstado(estadosAgendaService.getOne(1));
    this.agenda.setTipoServicio(tipoServicioService.getOne(this.idTipoServicio));
    this.agenda.setCliente(usuarioService.getOne(this.idCliente));
    this.agenda.setEmpleado(usuarioService.getOne(this.idEmpleado));
    this.agenda.setAdministrador(usuarioService.getOne(1));
    this.agenda.setTimestamps(timestamps);
    this.agenda = agendaService.create(agenda);
  }

}
