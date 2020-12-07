/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.ClienteDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cliente;

/**
 *
 * @author camorenoc
 */
@Stateless
public class ClienteService {

  @EJB

  private ClienteDAO clienteDAO;

  public void create(Cliente cliente) throws ConnectionExcep {
    clienteDAO.create(cliente);
  }

  public Cliente getOne(Integer id) throws ConnectionExcep {
    return clienteDAO.getOne(id);
  }

  public List<Cliente> getAll() throws ConnectionExcep {
    return clienteDAO.getAll();
  }

  public void update(Cliente cliente) throws ConnectionExcep {
    clienteDAO.update(cliente);
  }

  public void delete(Integer id) throws ConnectionExcep {
    clienteDAO.delete(id);
  }
}
