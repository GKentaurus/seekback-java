/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Rol;
import tech.seekback.services.RolService;

/**
 *
 * @author camorenoc
 */
@Named
@ViewScoped
public class RolesController implements Serializable {

  @EJB
  private RolService rolesService;
  private List<Rol> roles;

  public RolesController() {

  }

  @PostConstruct
  public void init() {
    try {
      roles = rolesService.getAll();
    } catch (ConnectionExcep ex) {
      System.out.println("Error de la consulta 'ROLES'.");
    }
  }

  public List<Rol> getAll() {
    return roles;
  }
}
