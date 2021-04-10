package tech.seekback.controllers;

import java.io.IOException;
import tech.seekback.models.Calificacion;
import tech.seekback.services.CalificacionService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import tech.seekback.services.ClienteService;
import tech.seekback.services.ProductoService;
import tech.seekback.models.templates.Timestamps;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.Date;
import net.sf.jasperreports.engine.JRException;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.services.tools.ReportService;

/**
 * @author danny
 */
@Named
@ViewScoped
public class CalificacionController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private CalificacionService calificacionService;

  @EJB
  private ClienteService clienteService;

  @EJB
  private ProductoService productoService;

  @EJB
  private ReportService reportService;

  private List<Calificacion> calificaciones;
  private List<Calificacion> calificaciondelproducto;
  private List<Calificacion> calificacionByidCliente;
  private Calificacion calificacion;
  private Integer idCliente;
  private Integer idProducto;
  private Integer calif;
  private String comment;

  @PostConstruct
  public void Init() {
    this.idCliente = loginController.getUsuario().getId();
  }

  public CalificacionController() {
    calificacion = new Calificacion();
  }

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }

  public Integer getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Integer idProducto) {
    this.idProducto = idProducto;
  }

  public Integer getCalif() {
    return calif;
  }

  public void setCalif(Integer calif) {
    this.calif = calif;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public List<Calificacion> getCalificacionByidCliente() {
    try {
      if (Objects.isNull(calificacionByidCliente)) {
        calificacionByidCliente = calificacionService.getByidCliente(this.idCliente);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los calificaciones.....");
      ex.printStackTrace();
    }
    return calificacionByidCliente;
  }

  public List<Calificacion> getCalificaciones() {
    try {
      if (Objects.isNull(calificaciones)) {
        calificaciones = calificacionService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los calificaciones.....");
      ex.printStackTrace();
    }
    return calificaciones;
  }

  public List<Calificacion> getCalificaciondelproducto(int idProducto) {
    try {
      if (Objects.isNull(calificaciondelproducto)) {
        calificaciondelproducto = calificacionService.getByIdProducto(idProducto);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los calificaciones.....");
      ex.printStackTrace();
    }
    return calificaciondelproducto;
  }

  public Integer getCalCount(Integer calificacion) throws ConnectionExcep {
    return this.calificacionService.getCalCount(calificacion);
  }

  public void create() throws IOException, ConnectionExcep {
    // Creación de Timestamp para todos los procesos
    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.calificacion.setCliente(clienteService.getOne(this.idCliente));
    this.calificacion.setProducto(productoService.getOne(this.idProducto));
    this.calificacion.setCalificacion(calif);
    this.calificacion.setComentario(comment);
    this.calificacion.setEsAprobado(true);
    this.calificacion.setTimestamps(timestamps);

    this.calificacion = calificacionService.create(calificacion);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/colsulcalif.xhtml");

  }

  public void genpdf() throws JRException, IOException, ConnectionExcep {

    List<String[]> columnas = new ArrayList<>();
    columnas.add(new String[]{"Cliente", "cliente.primerNombre", String.class.getName(), "70"});
    columnas.add(new String[]{"Producto", "producto.modeloProducto", String.class.getName(), "100"});
    columnas.add(new String[]{"Calificacion", "calificacion", Integer.class.getName(), "100"});
    columnas.add(new String[]{"Comentario", "comentario", String.class.getName(), "420"});
    columnas.add(new String[]{"Fecha", "timestamps.created_at", Date.class.getName(), "100"});

    this.reportService.exportPdfOnWeb("Reporte de calificaciones", columnas, this.calificacionService.getAll());

  }

  public void delete(Integer idcalif) throws IOException {
    try {
      calificacionService.delete(calificacionService.getOne(idcalif));
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Eliminando Registro " + idcalif
              + "\n######################################################################\n");

      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/frames/all/colsulcalif.xhtml");

    } catch (ConnectionExcep ex) {
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Error al eliminar el registro " + idcalif
              + "\n######################################################################\n");
      ex.printStackTrace();

    }
  }

}
