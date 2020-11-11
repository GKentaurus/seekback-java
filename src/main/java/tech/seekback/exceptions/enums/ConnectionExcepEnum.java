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
public enum ConnectionExcepEnum {
  
  ERROR_CONEXION("10001", "Error al conectarse a la base de datos."),
  ERROR_CONSULTA("100002", "Error al realizar la consulta."),
  ERROR_ACTUALIZA("100003", "Error al realizar la actualización.");
  
  private String code;
  private String message;

  private ConnectionExcepEnum(String codigo, String mensaje) {
    this.code = codigo;
    this.message = mensaje;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
  
}
