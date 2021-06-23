/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import net.sf.jasperreports.engine.JRException;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosFidelizacion;
import tech.seekback.models.PQRS;
import tech.seekback.models.TipoSolicitud;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.*;
import tech.seekback.tools.ReportService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.ManagedBean;

/**
 *
 * @author camorenoc
 */
@ManagedBean
@Named
@ViewScoped
public class ColsulFidelController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private PQRSService pqrsService;

  @EJB
  private EstadosFidelizacionService estadosFidelizacionService;

  @EJB
  private TipoSolicitudService tipoSolicitudService;

  @EJB
  private ReportService reportService;

  @EJB
  private AdministradorService administradorService;

  @EJB
  private ClienteService clienteService;

  private Integer idUsuario;
  private List<PQRS> pqrses;
  private List<PQRS> pqrsesByClient;
  private Integer idEstado;
  private List<EstadosFidelizacion> estados;
  private String answer;
  private PQRS pqrs;
  private Integer idCategoria;
  private List<TipoSolicitud> tipoSolicitudes;
  private String who;
  private String comment;

  @PostConstruct
  public void Init() {
    this.idUsuario = loginController.getUsuario().getId();
  }

  public ColsulFidelController() {
    pqrs = new PQRS();
  }

  public void genpdf() throws JRException, IOException, ConnectionExcep {

    List<String[]> columnas = new ArrayList<>();
    columnas.add(new String[]{"Solicitud", "tipoSolicitud.nombreSolicitud", String.class.getName(), "100"});
    columnas.add(new String[]{"Cliente", "cliente.primerNombre", String.class.getName(), "70"});
    columnas.add(new String[]{"Dirigido a", "area", String.class.getName(), "100"});
    columnas.add(new String[]{"Comentario", "comentario", String.class.getName(), "210"});
    columnas.add(new String[]{"Respuesta", "respuesta", String.class.getName(), "210"});
    columnas.add(new String[]{"Fecha", "timestamps.created_at", Date.class.getName(), "100"});

    this.reportService.exportPdfOnWeb("Reporte de PQRS", columnas, this.pqrsService.getAll());
  }

  public List<PQRS> getPqrsesByClient() {
    try {
      if (Objects.isNull(pqrsesByClient)) {
        pqrsesByClient = pqrsService.getByidCliente(this.idUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los pqrses.....");
      ex.printStackTrace();
    }
    return pqrsesByClient;
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

  public List<PQRS> getPqrses() {
    try {
      if (Objects.isNull(pqrses)) {
        pqrses = pqrsService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los pqrses.....");
      ex.printStackTrace();
    }
    return pqrses;
  }

  public Integer getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Integer idCategoria) {
    this.idCategoria = idCategoria;
  }

  public void updateAdm(Integer idPQR) throws ConnectionExcep, IOException {

    this.pqrs = pqrsService.getOne(idPQR);

    this.pqrs.setEstado(estadosFidelizacionService.getOne(idEstado));
    this.pqrs.setRespuesta(answer);

    pqrsService.update(pqrs);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro actualizado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/colsulfidel.xhtml");
  }

  public void delete(Integer idpqr) throws IOException {
    try {
      pqrsService.delete(pqrsService.getOne(idpqr));
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

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
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

  public void create() throws ConnectionExcep, IOException {

    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setDeleted(false);
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.pqrs.setTipoSolicitud(tipoSolicitudService.getOne(this.idCategoria));
    this.pqrs.setCliente(clienteService.getOne(this.idUsuario));
    this.pqrs.setAdministrador(administradorService.getOne(1));
    this.pqrs.setArea(this.who);
    this.pqrs.setComentario(this.comment);
    this.pqrs.setEstado(estadosFidelizacionService.getOne(1));
    this.pqrs.setTimestamps(timestamps);

    this.pqrs = pqrsService.create(pqrs);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/colsulfidel.xhtml");

  }
}
