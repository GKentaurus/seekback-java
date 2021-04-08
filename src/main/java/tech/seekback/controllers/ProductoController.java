/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.BodegaProducto;
import tech.seekback.models.CategoriasProducto;
import tech.seekback.models.Producto;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.BodegaProductoService;
import tech.seekback.services.BodegaService;
import tech.seekback.services.CategoriasProductoService;
import tech.seekback.services.ProductoService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author danny
 */
@Named
@ViewScoped
public class ProductoController implements Serializable {

  @EJB
  private ProductoService productoService;

  @EJB
  private CategoriasProductoService categoriasProductoService;

  @EJB
  private BodegaProductoService bodegaProductoService;

  @EJB
  private BodegaService bodegaService;

  private Producto producto;
  private BodegaProducto bodegaProducto;
  private String ModelProduct;
  private String Descripcion;
  private Double valor;
  private Integer idCat;
  private Integer idBod;
  private Integer Cant;

  private List<Producto> categoryProductList;
  private CategoriasProducto categoria;

  public ProductoController() throws ConnectionExcep {
    producto = new Producto();
    bodegaProducto = new BodegaProducto();
  }

  @PostConstruct
  public void init(){
    //
  }

  public List<Producto> getCategoryProductList() {
    return categoryProductList;
  }
  public void setCategoryProductList(Integer id) throws ConnectionExcep {
    this.categoria = categoriasProductoService.getOne(id);
    this.categoryProductList = productoService.getCategoryProducts(this.categoria.getId());
  }

  public CategoriasProducto getCategoria() {
    return categoria;
  }
  public void setCategoria(CategoriasProducto categoria) {
    this.categoria = categoria;
  }

  public Integer getIdBod() {
    return idBod;
  }

  public void setIdBod(Integer idBod) {
    this.idBod = idBod;
  }

  public Integer getCant() {
    return Cant;
  }

  public void setCant(Integer Cant) {
    this.Cant = Cant;
  }

  public Integer getIdCat() {
    return idCat;
  }

  public void setIdCat(Integer idCat) {
    this.idCat = idCat;
  }

  public String getModelProduct() {
    return ModelProduct;
  }

  public void setModelProduct(String ModelProduct) {
    this.ModelProduct = ModelProduct;
  }

  public String getDescripcion() {
    return Descripcion;
  }

  public void setDescripcion(String Descripcion) {
    this.Descripcion = Descripcion;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public void createp() throws ConnectionExcep, IOException {
    // Creación de Timestamp para todos los procesos
    Timestamps timestamps = new Timestamps();
    Date momentum = new Date();
    timestamps.setCreated_at(momentum);
    timestamps.setUpdated_at(momentum);

    this.producto.setModeloProducto(this.ModelProduct);
    this.producto.setDescripcion(this.Descripcion);
    this.producto.setPrecioVenta(this.valor);
    this.producto.setCategoria(categoriasProductoService.getOne(this.idCat));
    this.producto.setEstado(true);
    this.producto.setTimestamps(timestamps);
    this.producto = productoService.create(producto);

    this.bodegaProducto.setProducto(producto);
    this.bodegaProducto.setBodega(bodegaService.getOne(this.idBod));
    this.bodegaProducto.setCantidad(this.Cant);
    this.bodegaProducto.setTimestamps(timestamps);
    this.bodegaProducto = bodegaProductoService.create(bodegaProducto);

    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t  Registro creado "
        + "\n######################################################################\n");

    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/frames/admin/regnref.xhtml");

  }

}
