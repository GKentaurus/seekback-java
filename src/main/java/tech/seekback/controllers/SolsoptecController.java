/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.BodegaProducto;
import tech.seekback.models.EstadosFidelizacion;
import tech.seekback.models.Producto;
import tech.seekback.models.SoporteTecnico;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.BodegaProductoService;
import tech.seekback.services.ClienteService;
import tech.seekback.services.EmpleadoService;
import tech.seekback.services.EstadosFidelizacionService;
import tech.seekback.services.ProductoService;
import tech.seekback.services.SoporteTecnicoService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class SolsoptecController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private SoporteTecnicoService soporteTecnicoService;

  @EJB
  private EmpleadoService empleadoService;

  @EJB
  private ClienteService clienteService;

  @EJB
  private BodegaProductoService bodegaProductoService;

  @EJB
  private ProductoService productoService;

  @EJB
  private EstadosFidelizacionService estadosFidelizacionService;

  private SoporteTecnico soporteTecnico;
  private Integer idCliente;
  private Integer idEmpleado;
  private Integer idProducto;
  private String obs;
  private Integer idEstado;
  private Integer idUsuario;
  private List<SoporteTecnico> soportes;
  private List<Usuario> clientes;
  private List<Usuario> empleados;
  private List<BodegaProducto> bodegaProductos;
  private List<EstadosFidelizacion> estados;
  private List<SoporteTecnico> soportesByidempleado;
  private List<SoporteTecnico> soportesByidCliente;

  @PostConstruct
  public void init() {
    this.idUsuario = loginController.getUsuario().getId();
  }

  public SolsoptecController() {
    soporteTecnico = new SoporteTecnico();
  }

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idEmpleado) {
    this.idUsuario = idEmpleado;
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

  public Integer getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Integer idProducto) {
    this.idProducto = idProducto;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public Integer getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(Integer idEstado) {
    this.idEstado = idEstado;
  }

  public List<Usuario> getClientes() {
    try {
      if (Objects.isNull(clientes)) {
        clientes = clienteService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los clientes.....");
      ex.printStackTrace();
    }
    return clientes;
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

  public List<BodegaProducto> getBodegaProductos() {
    try {
      if (Objects.isNull(bodegaProductos)) {
        bodegaProductos = bodegaProductoService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los bodegaProductos.....");
      ex.printStackTrace();
    }
    return bodegaProductos;
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

  public List<SoporteTecnico> getSoportesByidempleado() {
    try {
      if (Objects.isNull(soportesByidempleado)) {
        soportesByidempleado = soporteTecnicoService.getByidEmpleado(this.idUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los soporteTecnico.....");
      ex.printStackTrace();
    }
    return soportesByidempleado;
  }

  public List<SoporteTecnico> getSoportesByidCliente() {
    try {
      if (Objects.isNull(soportesByidCliente)) {
        soportesByidCliente = soporteTecnicoService.getByidCliente(this.idUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los soporteTecnico.....");
      ex.printStackTrace();
    }
    return soportesByidCliente;
  }
  //</editor-fold>

  public void createdByAdmin() throws ConnectionExcep, IOException {

    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setDeleted(false);
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.soporteTecnico.setProducto(productoService.getOne(this.idProducto));
    this.soporteTecnico.setCliente(clienteService.getOne(this.idCliente));
    this.soporteTecnico.setEmpleado(empleadoService.getOne(this.idEmpleado));
    this.soporteTecnico.setEstado(estadosFidelizacionService.getOne(1));
    this.soporteTecnico.setComentario(this.obs);
    this.soporteTecnico.setTimestamps(timestamps);

    this.soporteTecnico = soporteTecnicoService.create(soporteTecnico);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/solsoptec.xhtml");

  }

  public void updatedByAdmin(Integer idsopo) throws ConnectionExcep, IOException {

    this.soporteTecnico = soporteTecnicoService.getOne(idsopo);

    this.soporteTecnico.setEmpleado(empleadoService.getOne(this.idEmpleado));
    this.soporteTecnico.setEstado(estadosFidelizacionService.getOne(this.idEstado));

    soporteTecnicoService.update(soporteTecnico);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/solsoptec.xhtml");

  }

  public void deletedByAdmin(Integer idsopor) throws IOException {
    try {
      soporteTecnicoService.delete(soporteTecnicoService.getOne(idsopor));
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Eliminando Registro " + idsopor
              + "\n######################################################################\n");

      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/frames/all/solsoptec.xhtml");

    } catch (ConnectionExcep ex) {
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Error al eliminar el registro " + idsopor
              + "\n######################################################################\n");
      ex.printStackTrace();

    }
  }

  public void createByEmpleado() throws ConnectionExcep, IOException {

    System.out.println("producto " + this.idProducto);
    System.out.println("setCliente " + this.idCliente);
    System.out.println("setEmpleado " + loginController.getUsuario().getId());

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

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/solsoptec.xhtml");

  }

  public void createdByCliente() throws ConnectionExcep, IOException {

    System.out.println("producto " + this.idProducto);

    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setDeleted(false);
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.soporteTecnico.setProducto(productoService.getOne(this.idProducto));
    this.soporteTecnico.setCliente(clienteService.getOne(this.idUsuario));
    this.soporteTecnico.setEmpleado(empleadoService.getOne(2));
    this.soporteTecnico.setEstado(estadosFidelizacionService.getOne(1));
    this.soporteTecnico.setComentario(this.obs);
    this.soporteTecnico.setTimestamps(timestamps);

    this.soporteTecnico = soporteTecnicoService.create(soporteTecnico);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/solsoptec.xhtml");

  }
}
