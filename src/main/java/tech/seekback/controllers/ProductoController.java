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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Bodega;
import tech.seekback.models.BodegaProducto;
import tech.seekback.models.Producto;
import tech.seekback.models.templates.Timestamps;
import tech.seekback.services.BodegaProductoService;
import tech.seekback.services.BodegaService;
import tech.seekback.services.CategoriasProductoService;
import tech.seekback.services.ProductoService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class ProductoController implements Serializable {

  @EJB
  private ProductoService productoService;

  @EJB
  private CategoriasProductoService categoriasprods;

  @EJB
  private BodegaProductoService bodegaProductoService;

  @EJB
  private BodegaService bodegaService;

  private Producto producto;
  private BodegaProducto bodegaProducto;
  private List<Bodega> bodegas;
  private String ModelProduct;
  private String Descripcion;
  private Double valor;
  private Integer idCat;
  private Integer idBod;
  private Integer Cant;
  private Integer countcat1;
  private Integer countcat2;
  private Integer countcat3;
  private Integer countcat4;
  private Integer countcat5;
  private Integer countcat6;

  public ProductoController() {
    producto = new Producto();
    bodegaProducto = new BodegaProducto();
  }

  @PostConstruct
  public void init() {
    try {
      bodegas = bodegaService.getAll();
    } catch (ConnectionExcep ex) {
      Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public Integer getCountcat1() {
    try {
      if (countcat1 == null) {
        countcat1 = productoService.getCatCount1();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcat1;
  }

  public Integer getCountcat2() {
    try {
      if (countcat2 == null) {
        countcat2 = productoService.getCatCount2();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcat2;
  }

  public Integer getCountcat3() {
    try {
      if (countcat3 == null) {
        countcat3 = productoService.getCatCount3();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcat3;
  }

  public Integer getCountcat4() {
    try {
      if (countcat4 == null) {
        countcat4 = productoService.getCatCount4();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcat4;
  }

  public Integer getCountcat5() {
    try {
      if (countcat5 == null) {
        countcat5 = productoService.getCatCount5();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcat5;
  }

  public Integer getCountcat6() {
    try {
      if (countcat6 == null) {
        countcat6 = productoService.getCatCount6();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countcat6;
  }

  public List<Bodega> getBodegas() {
    return bodegas;
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
    this.producto.setCategoria(categoriasprods.getOne(this.idCat));
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
