/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.CategoriasProducto;
import tech.seekback.services.CalificacionService;
import tech.seekback.services.CategoriasProductoService;
import tech.seekback.services.FelicitacionService;
import tech.seekback.services.PQRSService;
import tech.seekback.services.ProductoService;
import tech.seekback.services.SoporteTecnicoService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class DashboardController extends CustomController implements Serializable {

  @EJB
  private SoporteTecnicoService soporteTecnicoService;

  @EJB
  private FelicitacionService felicitacionService;

  @EJB
  private PQRSService pQRSService;

  @EJB
  private CalificacionService calificacionService;

  @EJB
  private ProductoService productoService;

  @EJB
  private CategoriasProductoService categoriasProductoService;

  private Integer countpqr;
  private Integer countfelicitaciones;
  private Integer countsoportes;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public List<CategoriasProducto> categoryList() throws ConnectionExcep {
    return this.categoriasProductoService.getAll();
  }

  public Integer getCalCount(Integer calificacion) throws ConnectionExcep {
    return this.calificacionService.getCalCount(calificacion);
  }

  public Integer getCountpqr() {
    try {
      if (countpqr == null) {
        countpqr = pQRSService.getAllCount();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countpqr;
  }

  public Integer getCountfelicitaciones() {
    try {
      if (countfelicitaciones == null) {
        countfelicitaciones = felicitacionService.getAllCount();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countfelicitaciones;
  }

  public Integer getCountsoportes() {
    try {
      if (countsoportes == null) {
        countsoportes = soporteTecnicoService.getAllCount();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los getAllCount.....");
      ex.printStackTrace();
    }
    return countsoportes;
  }

  public void setPart(Part part) {
    this.productoService.setPart(part);
  }

  public Part getPart() {
    return this.productoService.getPart();
  }

  public void uploadFile() throws IOException, ConnectionExcep, ParseException {
    this.productoService.uploadData();
  }
  //</editor-fold>

  public Integer categoryProductCount(Integer idCategoria) throws ConnectionExcep {
    return this.productoService.getCategoryCount(idCategoria);
  }
}
