package tech.seekback.controllers;

import java.io.IOException;

import net.sf.jasperreports.engine.JRException;
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
import java.util.ArrayList;
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
import tech.seekback.services.EstadosCotizacionService;
import tech.seekback.services.tools.ReportService;

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

  @EJB
  private ReportService reportService;

  private List<PQRS> pqrses;
  private List<EstadosFidelizacion> estados;
  private List<TipoSolicitud> tipoSolicitudes;
  private PQRS pqrs;
  private Integer count;
  private Integer idCategoria;
  private Integer idUsuario;
  private Integer idPQR;
  private Integer idEstado;
  private String who;
  private String comment;
  private String answer;

  @PostConstruct
  public void Init() {
    this.idUsuario = loginController.getUsuario().getId();
  }

  public PqrController() {
    pqrs = new PQRS();
  }

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
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

  public Integer getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(Integer idEstado) {
    this.idEstado = idEstado;
  }

  public String getWho() {
    return who;
  }

  public void setWho(String who) {
    this.who = who;
  }

  public Integer getIdPQR() {
    return idPQR;
  }

  public void setIdPQR(Integer idPQR) {
    this.idPQR = idPQR;
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

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
  //</editor-fold>

  public void updateAdm(Integer idPQR) throws ConnectionExcep, IOException {

    this.pqrs = pQRSService.getOne(idPQR);

    this.pqrs.setEstado(estadosFidelizacionService.getOne(idEstado));
    this.pqrs.setRespuesta(answer);

    pQRSService.update(pqrs);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro actualizado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/colsulfidel.xhtml");

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

  public void genpdf() throws JRException, IOException, ConnectionExcep {

    List<String[]> columnas = new ArrayList<>();
    columnas.add(new String[]{"Solicitud", "tipoSolicitud.nombreSolicitud", String.class.getName(), "100"});
    columnas.add(new String[]{"Cliente", "cliente.primerNombre", String.class.getName(), "70"});
    columnas.add(new String[]{"Dirigido a", "area", String.class.getName(), "100"});
    columnas.add(new String[]{"Comentario", "comentario", String.class.getName(), "210"});
    columnas.add(new String[]{"Respuesta", "respuesta", String.class.getName(), "210"});
    columnas.add(new String[]{"Fecha", "timestamps.created_at", Date.class.getName(), "100"});

    this.reportService.exportPdfOnWeb("Reporte de PQRS", columnas, this.pQRSService.getAll());

  }

  public void delete(Integer idpqr) throws IOException {
    try {
      pQRSService.delete(pQRSService.getOne(idpqr));
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Eliminando Registro " + idpqr
              + "\n######################################################################\n");

      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/frames/all/colsulfidel.xhtml");

    } catch (ConnectionExcep ex) {
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Error al eliminar el registro " + idpqr
              + "\n######################################################################\n");
      ex.printStackTrace();

    }

  }

}
