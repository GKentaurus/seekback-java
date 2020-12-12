/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author camorenoc
 */
@Named
@ViewScoped
public class TestController implements Serializable {

  @Inject
  private LoginController loginController;

  public Integer getUsuario() {
    return loginController.getUsuario().getId();
  }
}
