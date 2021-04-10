package tech.seekback.controllers;

import java.io.IOException;
import tech.seekback.dao.interfaces.CotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;
import tech.seekback.models.Usuario;
import tech.seekback.services.CotizacionService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import tech.seekback.dao.interfaces.TRMDAO;
import tech.seekback.models.TRM;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.ClienteService;
import tech.seekback.services.EmpleadoService;
import tech.seekback.services.EstadosCotizacionService;
import tech.seekback.services.TRMService;

/**
 * @author danny
 */
@Named
@ViewScoped
public class CotizacionController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private CotizacionService cotizacionService;

  @EJB
  private TRMService tRMService;

  @EJB
  private ClienteService clienteService;

  @EJB
  private EmpleadoService empleadoService;

  @EJB
  private EstadosCotizacionService estadosCotizacionService;

  @EJB
  private TRMDAO trmdao;

  private Usuario usuario;
  private Cotizacion cotizacion;
  private List<Cotizacion> cotizaciones;
  private List<Cotizacion> cotizacionesByidCliente;
  private List<TRM> trms;
  private List<TRM> trmsSeleccionada;
  private Integer IdDivisaseleccionada;
  private Integer IdUsuario;
  private Integer IdCliente;
  private String motivo;
  private Integer trm;

  public CotizacionController() {
    cotizacion = new Cotizacion();
  }

  @PostConstruct
  public void Init() {
    this.IdUsuario = loginController.getUsuario().getId();
  }

  public Integer getIdDivisaseleccionada() {
    return IdDivisaseleccionada;
  }

  public void setIdDivisaseleccionada(Integer IdDivisaseleccionada) {
    System.out.println("divi sele 2 " + IdDivisaseleccionada);
    try {
      if (Objects.nonNull(IdDivisaseleccionada)) {
        trmsSeleccionada = trmdao
                .getByidDivisa(IdDivisaseleccionada);
      } else {
        trmsSeleccionada = null;
      }
    } catch (ConnectionExcep ex) {
      ex.printStackTrace();
    }
    this.IdDivisaseleccionada = IdDivisaseleccionada;
  }

  public List<TRM> getTrmsSeleccionada() {
    return trmsSeleccionada;
  }

  public Integer getIdCliente() {
    return IdCliente;
  }

  public void setIdCliente(Integer IdCliente) {
    this.IdCliente = IdCliente;
  }

  public String getMotivo() {
    return motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  public Integer getTrm() {
    return trm;
  }

  public void setTrm(Integer trm) {
    this.trm = trm;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Integer getIdUsuario() {
    return IdUsuario;
  }

  public void setIdUsuario(Integer IdUsuario) {
    this.IdUsuario = IdUsuario;
  }

  public List<TRM> getTrms() {
    try {
      if (Objects.isNull(trms)) {
        trms = tRMService.getByidDivisa(IdUsuario);
      }
    } catch (ConnectionExcep ex) {
      System.out.println("Error de la consulta 'paises'.");
      ex.printStackTrace();
    }
    return trms;
  }

  public List<Cotizacion> getCotizaciones() throws ConnectionExcep {
    try {
      if (Objects.isNull(cotizaciones)) {
        cotizaciones = cotizacionService.getByIdEmpleado(this.IdUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los soporteTecnico.....");
      ex.printStackTrace();
    }
    return cotizaciones;
  }

  public List<Cotizacion> getCotizacionesByidCliente() {
    try {
      if (Objects.isNull(cotizacionesByidCliente)) {
        cotizacionesByidCliente = cotizacionService.getByIdCliente(this.IdUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los soporteTecnico.....");
      ex.printStackTrace();
    }
    return cotizacionesByidCliente;
  }

  public void test() {
    System.out.println("\n\n\nPROBANDO PROBANDO \n\n\n");
  }

  public void createe() throws ConnectionExcep, IOException {
    System.out.println("metodo crear emp");

    this.cotizacion = new Cotizacion();

    // Creación de Timestamp para todos los procesos
    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.cotizacion.setRequerimiento(motivo);
    this.cotizacion.setFecha(momentum);
    this.cotizacion.setTrm(tRMService.getOne(trm));
    this.cotizacion.setEstado(estadosCotizacionService.getOne(1));
    this.cotizacion.setCliente(clienteService.getOne(this.IdCliente));
    this.cotizacion.setEmpleado(empleadoService.getOne(this.IdUsuario));
    this.cotizacion = cotizacionService.create(cotizacion);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/gencotiza.xhtml");
  }

  public void createc() throws ConnectionExcep, IOException {
    System.out.println("metodo crear");

    this.cotizacion = new Cotizacion();

    // Creación de Timestamp para todos los procesos
    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.cotizacion.setRequerimiento(motivo);
    this.cotizacion.setFecha(momentum);
    this.cotizacion.setTrm(tRMService.getOne(trm));
    this.cotizacion.setEstado(estadosCotizacionService.getOne(1));
    this.cotizacion.setCliente(clienteService.getOne(this.IdUsuario));
    this.cotizacion.setEmpleado(empleadoService.getOne(2));
    this.cotizacion = cotizacionService.create(cotizacion);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/gencotiza.xhtml");
  }

}
