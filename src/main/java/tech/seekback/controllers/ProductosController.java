/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.BodegaProducto;
import tech.seekback.models.Calificacion;
import tech.seekback.models.CategoriasProducto;
import tech.seekback.models.Producto;
import tech.seekback.services.BodegaProductoService;
import tech.seekback.services.CalificacionService;
import tech.seekback.services.CategoriasProductoService;
import tech.seekback.services.ProductoService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class ProductosController extends CustomController implements Serializable {

  @EJB
  private CalificacionService calificacionService;

  @EJB
  private ProductoService productoService;

  @EJB
  private BodegaProductoService bodegaProductoService;

  @EJB
  private CategoriasProductoService categoriasProductoService;

  private List<CategoriasProducto> categoriasProductoList;
  private List<Calificacion> calificaciondelproducto;
  private List<Producto> categoryProductList;
  private List<BodegaProducto> pornombre;
  private Producto producto;
  private Integer idProd;

  // <editor-fold desc="Getters y Setters" defaultstate="collapsed">
  public Integer getIdProd() {
    return idProd;
  }

  public void setIdProd(Integer idProd) {
    this.idProd = idProd;
  }

  public Producto getProducto() {
    try {
      if (Objects.isNull(producto)) {
        System.out.println("vacio esto");
      }
    } catch (Exception e) {
    }
    return producto;
  }

  // </editor-fold>
  public void updateCategoryList() throws ConnectionExcep {
    this.categoriasProductoList = this.categoriasProductoService.getAll();
  }

  public List<CategoriasProducto> getCategoryList() {
    return this.categoriasProductoList;
  }

  public String link(Integer id) {
    return "product?id=" + id + " faces-redirect=true";
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

  public List<Producto> getCategoryProductList(Integer id) throws ConnectionExcep {
    CategoriasProducto categoria = categoriasProductoService.getOne(id);
    if (Objects.nonNull(categoria)) {
      this.categoryProductList = productoService.getCategoryProducts(categoria.getId());
    }
    return this.categoryProductList;
  }

  public boolean listHasData() {

    return Objects.nonNull(this.categoryProductList) && this.categoryProductList.size() > 0;
  }

  public List<BodegaProducto> getPornombre(String parteNombre) {
    try {
      if (Objects.isNull(pornombre)) {
        pornombre = bodegaProductoService.getLikeName(parteNombre);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los bodegaProductos.....");
      ex.printStackTrace();
    }
    return pornombre;
  }

  public void getOne() {
    try {
      this.producto = productoService.getOne(this.idProd);
    } catch (ConnectionExcep ex) {
      System.out.println("Error al consultar.....");
      ex.printStackTrace();
    }
  }
}
