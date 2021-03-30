/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
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
  private Integer categoria;

  public Integer getCategoria() {
    return categoria;
  }

  public void setCategoria(Integer categoria) {
    this.categoria = categoria;
    System.out.println("categoria: " + this.categoria);
  }

  public boolean checkCat(Integer cat) {
    return cat == this.categoria;
  }
}
