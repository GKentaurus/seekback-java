/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tech.seekback.models.Cotizacion;
import tech.seekback.models.Usuario;
import tech.seekback.services.CotizacionService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class CotizacionController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private Usuario usuario;
  private CotizacionService cotizacionService;
  private List<Cotizacion> cotizaciones;

  @PostConstruct
  public void init() {
    this.usuario = loginController.getUsuario();
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public List<Cotizacion> getCotizaciones() {
    try {
      if (Objects.isNull(cotizaciones)) {
        cotizaciones = cotizacionService.getAll();
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los clientes.....");
      ex.printStackTrace();
    }
    return cotizaciones;
  }

}
