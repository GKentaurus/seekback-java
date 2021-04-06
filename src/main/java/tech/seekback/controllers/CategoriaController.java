/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.CategoriasProducto;
import tech.seekback.services.CategoriasProductoService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class CategoriaController extends CustomController implements Serializable {

  @EJB
  private CategoriasProductoService categoriasprods;

  private CategoriasProducto categoriasp;
  private List<CategoriasProducto> categoriasProductos;
  private Integer categoria;

  public Integer getCategoria() {
    return categoria;
  }

  public void setCategoria(Integer categoria) {
    this.categoria = categoria;
    System.out.println("categoria: " + this.categoria);
  }

  @PostConstruct
  public void init() {
    try {
      categoriasProductos = categoriasprods.getAll();
    } catch (ConnectionExcep ex) {
      Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public List<CategoriasProducto> getCategoriasProductos() {
    return categoriasProductos;
  }

  public boolean checkCat(Integer cat) {
    return cat == this.categoria;
  }
}
