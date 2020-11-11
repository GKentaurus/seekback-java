/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.exceptions.enums;

/**
 *
 * @author camorenoc
 */
public enum FactoryExcepEnum {
  ERROR_FABRICA_DAO("20001", "Error al instanciar la fabrica DAO.");

  private String code;
  private String message;

  private FactoryExcepEnum(String codigo, String mensaje) {
    this.code = codigo;
    this.message = mensaje;
  }

  public String getCodigo() {
    return code;
  }

  public String getMensaje() {
    return message;
  }
}
