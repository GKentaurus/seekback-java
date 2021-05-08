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
import tech.seekback.models.EstadosAgenda;
import tech.seekback.models.TipoServicio;
import tech.seekback.models.Usuario;
import tech.seekback.services.AgendaService;
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
public class ColsulserviController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private AgendaService agendaService;

  @EJB
  private EmpleadoService empleadoService;

  @EJB
  private TipoServicioService tipoServicioService;

  @EJB
  private EstadosAgendaService estadosAgendaService;

  private List<Usuario> empleados;
  private Agenda agenda;
  private Integer idEmpleado;
  private Integer idUsuario;
  private Integer idTipoServicio;
  private Integer idEstado;
  private String obs;
  private List<Agenda> agendas;
  private List<TipoServicio> tipoServicio;
  private List<EstadosAgenda> estadosAgendas;
  private List<Agenda> agendasByidEmpleado;
  private List<Agenda> agendasByidCliente;

  @PostConstruct
  public void Init() {
    this.idUsuario = loginController.getUsuario().getId();
  }

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Integer idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Integer getIdTipoServicio() {
    return idTipoServicio;
  }

  public void setIdTipoServicio(Integer idTipoServicio) {
    this.idTipoServicio = idTipoServicio;
  }

  public Integer getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(Integer idEstado) {
    this.idEstado = idEstado;
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
  //</editor-fold>

  public void updatedByAdmin(Integer idagenda) throws ConnectionExcep, IOException {
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
    ec.redirect(ec.getRequestContextPath() + "/frames/all/colsulservi.xhtml");

  }

  public void deletedByAdmin(Integer idagen) throws ConnectionExcep, IOException {
    try {
      agendaService.delete(agendaService.getOne(idagen));
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Eliminando Registro " + idagen
              + "\n######################################################################\n");

      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/frames/all/colsulservi.xhtml");

    } catch (ConnectionExcep ex) {
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Error al eliminar el registro " + idagen
              + "\n######################################################################\n");
      ex.printStackTrace();

    }

  }
}
