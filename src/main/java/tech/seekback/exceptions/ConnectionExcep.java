/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.exceptions;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;

/**
 *
 * @author camorenoc
 */
public class ConnectionExcep extends Exception{
  
  private ConnectionExcepEnum tipo;

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
