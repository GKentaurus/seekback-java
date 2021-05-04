package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Bodega;
import tech.seekback.models.BodegaProducto;
import tech.seekback.models.CategoriasProducto;
import tech.seekback.models.Producto;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.BodegaProductoService;
import tech.seekback.services.BodegaService;
import tech.seekback.services.CategoriasProductoService;
import tech.seekback.services.ProductoService;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Named
@ViewScoped
public class RegnRefController extends CustomController {
  @EJB
  private ProductoService productoService;

  @EJB
  private CategoriasProductoService categoriasProductoService;

  @EJB
  private BodegaService bodegaService;

  @EJB
  private BodegaProductoService bodegaProductoService;

  private Producto producto;
  private BodegaProducto bodegaProducto;
  private String modelProduct;
  private String descripcion;
  private Double valor;
  private Integer cant;
  private List<CategoriasProducto> categoriasProductos;
  private Integer idCat;
  private Integer idBod;
  private List<Bodega> bodegas;

  public String getModelProduct() {
    return modelProduct;
  }

  public void setModelProduct(String ModelProduct) {
    this.modelProduct = ModelProduct;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String Descripcion) {
    this.descripcion = Descripcion;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Integer getCant() {
    return cant;
  }

  public void setCant(Integer Cant) {
    this.cant = Cant;
  }

  public Integer getIdCat() {
    return idCat;
  }

  public void setIdCat(Integer idCat) {
    this.idCat = idCat;
  }

  public Integer getIdBod() {
    return idBod;
  }

  public void setIdBod(Integer idBod) {
    this.idBod = idBod;
  }

  public List<CategoriasProducto> getCategoriasProductos() {
    try {
      if (Objects.isNull(categoriasProductos)) {
        categoriasProductos = categoriasProductoService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar las categorías de productos...");
      ex.printStackTrace();
    }
    return categoriasProductos;
  }

  public List<Bodega> getBodegas() {
    try {
      bodegas = bodegaService.getAll();
    } catch (Exception e) {
      System.out.println("error al consultar bodegas");
    }
    return bodegas;
  }

  public void createp() throws ConnectionExcep, IOException {
    // Creación de Timestamp para todos los procesos
    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.producto.setModeloProducto(this.modelProduct);
    this.producto.setDescripcion(this.descripcion);
    this.producto.setPrecioVenta(this.valor);
    this.producto.setCategoria(categoriasProductoService.getOne(this.idCat));
    this.producto.setEstado(true);
    this.producto.setTimestamps(timestamps);
    this.producto = productoService.create(producto);

    this.bodegaProducto.setProducto(producto);
    this.bodegaProducto.setBodega(bodegaService.getOne(this.idBod));
    this.bodegaProducto.setCantidad(this.cant);
    this.bodegaProducto.setTimestamps(timestamps);
    this.bodegaProducto = bodegaProductoService.create(bodegaProducto);

    System.out.println(
        "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/all/regnref.xhtml");

  }
}
