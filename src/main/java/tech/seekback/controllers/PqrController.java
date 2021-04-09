package tech.seekback.controllers;

import java.io.IOException;
import tech.seekback.models.EstadosFidelizacion;
import tech.seekback.models.PQRS;
import tech.seekback.models.TipoSolicitud;
import tech.seekback.services.EstadosFidelizacionService;
import tech.seekback.services.PQRSService;
import tech.seekback.services.TipoSolicitudService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.AdministradorService;
import tech.seekback.services.ClienteService;

/**
 * @author danny
 */
@Named
@ViewScoped
public class PqrController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private PQRSService pQRSService;

  @EJB
  private AdministradorService administradorService;

  @EJB
  private EstadosFidelizacionService estadosFidelizacionService;

  @EJB
  private TipoSolicitudService tipoSolicitudService;

  @EJB
  private ClienteService clienteService;

  private List<PQRS> pqrses;
  private List<EstadosFidelizacion> estados;
  private List<TipoSolicitud> tipoSolicitudes;
  private PQRS pqrs;
  private Integer count;
  private Integer idCategoria;
  private Integer idUsuario;
  private String who;
  private String comment;

  @PostConstruct
  public void Init() {
    this.idUsuario = loginController.getUsuario().getId();
  }

  public PqrController() {
    pqrs = new PQRS();
  }

  public Integer getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Integer idCategoria) {
    this.idCategoria = idCategoria;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getWho() {
    return who;
  }

  public void setWho(String who) {
    this.who = who;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public PQRS getPqrs() {
    return pqrs;
  }

  public void setPqrs(PQRS pqrs) {
    this.pqrs = pqrs;
  }

  public Integer getCount() {
    try {
      if (count == null) {
        count = pQRSService.getAllCount();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return count;
  }

  public List<PQRS> getPqrses() {
    try {
      if (Objects.isNull(pqrses)) {
        pqrses = pQRSService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los pqrses.....");
      ex.printStackTrace();
    }
    return pqrses;
  }

  public List<EstadosFidelizacion> getEstadosFidelizacion() {
    try {
      if (Objects.isNull(estados)) {
        estados = estadosFidelizacionService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los estadosFidelizacion.....");
      ex.printStackTrace();
    }
    return estados;
  }

  public List<TipoSolicitud> getTipoSolicitudes() {
    try {
      if (Objects.isNull(tipoSolicitudes)) {
        tipoSolicitudes = tipoSolicitudService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los tipoSolicitudes.....");
      ex.printStackTrace();
    }
    return tipoSolicitudes;
  }

  public void create() throws ConnectionExcep, IOException {
    // Creación de Timestamp para todos los procesos
    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.pqrs.setAdministrador(administradorService.getOne(1));
    this.pqrs.setCliente(clienteService.getOne(this.idUsuario));
    this.pqrs.setTipoSolicitud(tipoSolicitudService.getOne(this.idCategoria));
    this.pqrs.setEstado(estadosFidelizacionService.getOne(1));
    this.pqrs.setArea(who);
    this.pqrs.setComentario(comment);
    this.pqrs.setTimestamps(timestamps);

    this.pqrs = pQRSService.create(pqrs);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/colsulfidel.xhtml");

  }

}
