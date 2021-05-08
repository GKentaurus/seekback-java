
package tech.seekback.enums;

/**
 * @author gkentaurus
 */
public enum ConnectionExcepEnum {

  ERROR_CONEXION("10001", "Error al conectarse a la base de datos."),
  ERROR_CONSULTA("100002", "Error al realizar la consulta."),
  ERROR_ACTUALIZA("100003", "Error al realizar la actualización."),
  ERROR_DUPLICADO("100004", "Error al guardar el elemento, ya existe en la base de datos.");

  private final String code;
  private final String message;

  ConnectionExcepEnum(String codigo, String mensaje) {
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
