/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import tech.seekback.dao.interfaces.CotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;
import tech.seekback.models.Usuario;
import tech.seekback.services.CotizacionService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class CotizacionController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private Usuario usuario;
  private CotizacionService cotizacionService;
  private List<Cotizacion> cotizaciones;
  private CotizacionDAO CotizacionDAO;

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
      if (Objects.nonNull(usuario.getId())) {
        cotizaciones = CotizacionDAO.getByIdEmpleado(usuario.getId());
      } else {
        System.out.println("error al realizar la consulta");
      }
    } catch (ConnectionExcep ex) {
      ex.printStackTrace();
    }
    return cotizaciones;
  }

}
