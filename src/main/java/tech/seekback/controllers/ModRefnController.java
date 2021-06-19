/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import net.sf.jasperreports.engine.JRException;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Bodega;
import tech.seekback.models.BodegaProducto;
import tech.seekback.models.CategoriasProducto;
import tech.seekback.models.Producto;
import tech.seekback.services.BodegaProductoService;
import tech.seekback.services.BodegaService;
import tech.seekback.services.CategoriasProductoService;
import tech.seekback.services.ProductoService;
import tech.seekback.tools.ReportService;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author camorenoc
 */
@Named
@ViewScoped
public class ModRefnController extends CustomController implements Serializable {

  @EJB
  private ReportService reportService;

  @EJB
  private ProductoService productoService;

  @EJB
  private BodegaProductoService bodegaProductoService;

  @EJB
  private CategoriasProductoService categoriasProductoService;

  @EJB
  private BodegaService bodegaService;

  private List<BodegaProducto> bodegaProductos;
  private List<CategoriasProducto> categoriasProductos;
  private List<Bodega> bodegas;
  private String modelProduct;
  private Integer cant;
  private Double valor;
  private Integer idCat;
  private Integer idBod;
  private String estado;
  private String descripcion;
  private BodegaProducto bodegaProducto;
  private Producto producto;
  private boolean estate;

  public void genpdf() throws JRException, IOException, ConnectionExcep {

    List<String[]> columnas = new ArrayList<>();
    columnas.add(new String[]{"Modelo", "modeloProducto", String.class.getName(), "100"});
    columnas.add(new String[]{"Descripción", "descripcion", String.class.getName(), "420"});
    columnas.add(new String[]{"Categoria", "categoria.nombreCategoria", String.class.getName(), "100"});
    columnas.add(new String[]{"precioVenta", "precioVenta", Double.class.getName(), "70"});
    columnas.add(new String[]{"Fecha", "timestamps.created_at", Date.class.getName(), "100"});

    this.reportService.exportPdfOnWeb("Reporte de Productos", columnas, this.productoService.getAll());
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

  public List<CategoriasProducto> getCategoriasProductos() {
    try {
      if (Objects.isNull(categoriasProductos)) {
        categoriasProductos = categoriasProductoService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los Agenda.....");
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

  public Integer getCant() {
    return cant;
  }

  public void setCant(Integer cant) {
    this.cant = cant;
  }

  public String getModelProduct() {
    return modelProduct;
  }

  public void setModelProduct(String modelProduct) {
    this.modelProduct = modelProduct;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
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

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public boolean isEstate() {
    return estate;
  }

  public void setEstate(boolean estate) {
    this.estate = estate;
  }

  public void updateadm(Integer idprodB, Integer idprod) throws ConnectionExcep, IOException {
    this.bodegaProducto = bodegaProductoService.getOne(idprodB);
    this.producto = productoService.getOne(idprod);

    if (this.estado == "true") {
      this.estate = true;
    } else {
      this.estate = false;
    }

    this.producto.setModeloProducto(modelProduct);
    this.producto.setDescripcion(descripcion);
    this.producto.setPrecioVenta(valor);
    this.producto.setEstado(estate);
    this.producto.setCategoria(categoriasProductoService.getOne(idCat));

    this.bodegaProducto.setProducto(producto);
    this.bodegaProducto.setBodega(bodegaService.getOne(idBod));
    this.bodegaProducto.setCantidad(cant);

    bodegaProductoService.update(bodegaProducto);
    productoService.update(producto);

    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t  Registro creado "
            + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/admin/modrefn.xhtml");
  }

  public void delete(Integer idprod) throws IOException {
    try {
      productoService.delete(productoService.getOne(idprod));
      bodegaProductoService.delete(bodegaProductoService.getByIdProducto(idprod));
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Eliminando Registro " + idprod
              + "\n######################################################################\n");

      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(ec.getRequestContextPath() + "/frames/admin/modrefn.xhtml");

    } catch (ConnectionExcep ex) {
      System.out.println(
              "\n\n\n\n\n######################################################################"
              + "\n#\t  Error al eliminar el registro " + idprod
              + "\n######################################################################\n");
      ex.printStackTrace();

    }
  }
}
