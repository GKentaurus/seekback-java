/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.Objects;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.models.Telefono;
import tech.seekback.services.TelefonoService;

/**
 *
 * @author danny
 */
@ViewScoped
@Named
public class TelefonoController implements Serializable {

  @EJB
  private TelefonoService telefonoService;
  private Telefono telefono;

  public Telefono getTelefono(Integer idUsuario) {
    try {
      if (Objects.isNull(telefono)) {
        telefono = telefonoService.getByIdUsuario(idUsuario);
      }
    } catch (Exception ex) {
      System.out.println("Error al consultar los telefono.....");
      ex.printStackTrace();
    }
    return telefono;
  }

}
