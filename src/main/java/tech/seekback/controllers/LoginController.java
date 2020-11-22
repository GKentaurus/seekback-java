/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author danny
 */
@RequestScoped
@Named
public class LoginController {

  private String email;
  private String password;

  public LoginController() {
    email = "";
    password = "";
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void show() {
    System.out.println(email + " / " + password);
  }

}
