package tech.seekback.controllers;

import tech.seekback.models.EstadosFidelizacion;
import tech.seekback.models.SoporteTecnico;
import tech.seekback.services.EstadosFidelizacionService;
import tech.seekback.services.SoporteTecnicoService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.ClienteService;
import tech.seekback.services.EmpleadoService;
import tech.seekback.services.ProductoService;

/**
 * @author danny
 */
@Named
@ViewScoped
public class SoporteTecnicoController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private SoporteTecnicoService soporteTecnicoService;

  @EJB
  private ProductoService productoService;

  @EJB
  private ClienteService clienteService;

  @EJB
  private EmpleadoService empleadoService;

  @EJB
  private EstadosFidelizacionService estadosFidelizacionService;

  private SoporteTecnico soporteTecnico;
  private List<SoporteTecnico> soportes;
  private List<SoporteTecnico> soportesByidempleado;
  private List<EstadosFidelizacion> estados;
  private Integer count;
  private Integer idCliente;
  private Integer idProducto;
  private Integer idEmpleado;
  private Date fecha;
  private String obs;

  @PostConstruct
  public void init() {
    this.idEmpleado = loginController.getUsuario().getId();
  }

  public SoporteTecnicoController() {
    soporteTecnico = new SoporteTecnico();
  }

  public SoporteTecnico getSoporteTecnico() {
    return soporteTecnico;
  }

  public void setSoporteTecnico(SoporteTecnico soporteTecnico) {
    this.soporteTecnico = soporteTecnico;
  }

  public Integer getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(Integer idEmpleado) {
    this.idEmpleado = idEmpleado;
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

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public Integer getCount() {
    try {
      if (count == null) {
        count = soporteTecnicoService.getAllCount();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return count;
  }

  public List<SoporteTecnico> getSoportes() {
    try {
      if (Objects.isNull(soportes)) {
        soportes = soporteTecnicoService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los soporteTecnico.....");
      ex.printStackTrace();
    }
    return soportes;
  }

  public List<SoporteTecnico> getSoportesByidempleado() {
    try {
      if (Objects.isNull(soportesByidempleado)) {
        soportesByidempleado = soporteTecnicoService.getByidEmpleado(this.idEmpleado);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los soporteTecnico.....");
      ex.printStackTrace();
    }
    return soportesByidempleado;
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

  public void create() throws ConnectionExcep {

    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setDeleted(false);
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.soporteTecnico.setProducto(productoService.getOne(this.idProducto));
    this.soporteTecnico.setCliente(clienteService.getOne(this.idCliente));
    this.soporteTecnico.setEmpleado(empleadoService.getOne(loginController.getUsuario().getId()));
    this.soporteTecnico.setEstado(estadosFidelizacionService.getOne(1));
    this.soporteTecnico.setComentario(this.obs);
    this.soporteTecnico.setTimestamps(timestamps);

    this.soporteTecnico = soporteTecnicoService.create(soporteTecnico);

  }

}
