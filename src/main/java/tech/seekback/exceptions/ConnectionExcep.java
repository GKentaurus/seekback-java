
package tech.seekback.exceptions;

import tech.seekback.exceptions.enums.ConnectionExcepEnum;

/**
 * @author gkentaurus
 */
public class ConnectionExcep extends Exception {

  private final ConnectionExcepEnum tipo;

  public ConnectionExcep(ConnectionExcepEnum tipo) {
    super(tipo.getMessage());
    this.tipo = tipo;
  }

  public ConnectionExcep(ConnectionExcepEnum tipo, Throwable thrwbl) {
    super(tipo.getMessage(), thrwbl);
    this.tipo = tipo;
  }

  public ConnectionExcepEnum getTipo() {
    return tipo;
  }
}
