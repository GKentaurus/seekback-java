/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;
import tech.seekback.services.CorreoService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class CorreoController implements Serializable {

  @EJB
  private CorreoService correoService;

  private Correo correo;
  private String email;

  public String getEmail(int idusu) throws ConnectionExcep {
    email = correoService.getByIdPrincipal(idusu).getCorreoElectronico();
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
