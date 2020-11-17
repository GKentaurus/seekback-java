/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ClienteDAO;
import tech.seekback.models.Cliente;

/**
 *
 * @author camorenoc
 */
public class ClienteDAOJPA extends GenericDAO<Cliente, Integer> implements ClienteDAO {

  public ClienteDAOJPA() {
    super(Cliente.class);
  }
}
