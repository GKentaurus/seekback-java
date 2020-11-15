/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.exceptions;

import tech.seekback.exceptions.enums.FactoryExcepEnum;

/**
 *
 * @author camorenoc
 */
public class FactoryExcep extends Exception {

  private FactoryExcepEnum tipo;

  public FactoryExcep(FactoryExcepEnum tipo) {
    super(tipo.getMensaje());
    this.tipo = tipo;
  }

  public FactoryExcep(FactoryExcepEnum tipo, Throwable thrwbl) {
    super(tipo.getMensaje(), thrwbl);
    this.tipo = tipo;
  }

  public FactoryExcepEnum getTipo() {
    return tipo;
  }
}
