package tech.seekback.controllers;

import java.io.IOException;

import net.sf.jasperreports.engine.JRException;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Felicitacion;
import tech.seekback.services.FelicitacionService;

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
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.ClienteService;
import tech.seekback.services.tools.ReportService;

/**
 * @author danny
 */
@Named
@ViewScoped
public class FelicitacionController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private FelicitacionService felicitacionService;

  @EJB
  private ClienteService clienteService;

  @EJB
  private ReportService reportService;

  private List<Felicitacion> felicitaciones;
  private List<Felicitacion> felicitacionesByidCliente;
  private Felicitacion felicitacion;
  private Integer count;
  private Integer idCliente;
  private String para;
  private String comment;

  @PostConstruct
  public void Init() {
    this.idCliente = loginController.getUsuario().getId();
  }

  public FelicitacionController() {
    felicitacion = new Felicitacion();
  }

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }

  public String getPara() {
    return para;
  }

  public void setPara(String para) {
    this.para = para;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Integer getCount() {
    try {
      if (count == null) {
        count = felicitacionService.getAllCount();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return count;
  }

  public List<Felicitacion> getFelicitaciones() {
    try {
      if (Objects.isNull(felicitaciones)) {
        felicitaciones = felicitacionService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los felicitaciones.....");
      ex.printStackTrace();
    }
    return felicitaciones;
  }

  public List<Felicitacion> getFelicitacionesByidCliente() {
    try {
      if (Objects.isNull(felicitacionesByidCliente)) {
        felicitacionesByidCliente = felicitacionService.getByidCliente(this.idCliente);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los felicitaciones.....");
      ex.printStackTrace();
    }
    return felicitacionesByidCliente;
  }

  public void delete(Felicitacion felicitacion) throws ConnectionExcep {
    felicitacionService.delete(felicitacion);
  }

  public void create() throws IOException, ConnectionExcep {
    // Creación de Timestamp para todos los procesos
    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.felicitacion.setCliente(clienteService.getOne(this.idCliente));
    this.felicitacion.setDirigidoA(para);
    this.felicitacion.setComentario(comment);
    this.felicitacion.setTimestamps(timestamps);

    this.felicitacion = felicitacionService.create(felicitacion);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/colsulfeli.xhtml");

  }

  public void genpdf() throws JRException, IOException, ConnectionExcep {

    List<String[]> columnas = new ArrayList<>();
    columnas.add(new String[]{"Cliente", "cliente.primerNombre", String.class.getName(), "70"});
    columnas.add(new String[]{"Dirigido a", "dirigidoA", String.class.getName(), "100"});
    columnas.add(new String[]{"Comentario", "comentario", String.class.getName(), "530"});
    columnas.add(new String[]{"Fecha", "timestamps.created_at", Date.class.getName(), "100"});

    this.reportService.exportPdfOnWeb("Reporte de Felicitaciones", columnas, this.felicitacionService.getAll());

  }


}
