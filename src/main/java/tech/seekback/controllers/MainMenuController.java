
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.CategoriasProducto;
import tech.seekback.services.CategoriasProductoService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author gkentaurus
 */
@Named
@ViewScoped
public class MainMenuController extends CustomController implements Serializable {

  @EJB
  private CategoriasProductoService categoriasProductoService;

  private List<CategoriasProducto> categoriasProductoList;

  // <editor-fold desc="Getters y Setters" defaultstate="collapsed">
  public void updateCategoryList() throws ConnectionExcep {
    this.categoriasProductoList = this.categoriasProductoService.getAll();
  }
  public List<CategoriasProducto> getCategoryList(){
    return this.categoriasProductoList;
  }

  public String link(Integer id) {
    return "product?id=" + id + " faces-redirect=true";
  }

  // </editor-fold>
}
