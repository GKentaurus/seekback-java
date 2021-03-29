
package tech.seekback.exceptions;

import tech.seekback.enums.FactoryExcepEnum;

/**
 * @author gkentaurus
 */
public class FactoryExcep extends Exception {

  private final FactoryExcepEnum tipo;

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
