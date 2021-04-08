/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.CategoriasProducto;
import tech.seekback.services.CategoriasProductoService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class CategoriaController extends CustomController implements Serializable {

  @EJB
  private CategoriasProductoService categoriasProductoService;

  private CategoriasProducto categoriasProducto;
  private List<CategoriasProducto> categoriasProductos;
  private Integer categoria;

  @PostConstruct
  public void init() {
    //
  }

  public CategoriasProducto getCategoriasProducto(Integer id) throws ConnectionExcep {
    return categoriasProductoService.getOne(id);
  }

  public void setCategoriasProducto(CategoriasProducto categoriasProducto) {
    this.categoriasProducto = categoriasProducto;
  }
  public Integer getCategoria() {
    return categoria;
  }

  public void setCategoria(Integer categoria) {
    this.categoria = categoria;
    System.out.println("categoria: " + this.categoria);
  }


  public List<CategoriasProducto> getCategoriasProductos() {
    return categoriasProductos;
  }

  public boolean checkCat(Integer cat) {
    return cat == this.categoria;
  }
}
