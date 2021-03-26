
package tech.seekback.exceptions.enums;

/**
 * @author gkentaurus
 */
public enum FactoryExcepEnum {
  ERROR_FABRICA_DAO("20001", "Error al instanciar la fabrica DAO.");

  private final String code;
  private final String message;

  FactoryExcepEnum(String codigo, String mensaje) {
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
