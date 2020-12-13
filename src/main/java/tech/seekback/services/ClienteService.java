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

  /**
   *
   * @param cliente
   * @return Un objeto de tipo Cliente
   * @throws ConnectionExcep
   */
  public Cliente create(Cliente cliente) throws ConnectionExcep {
    return clienteDAO.create(cliente);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo Cliente consultado por id
   * @throws ConnectionExcep
   */
  public Cliente getOne(Integer id) throws ConnectionExcep {
    return clienteDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo Cliente (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Cliente> getAll() throws ConnectionExcep {
    return clienteDAO.getAll();
  }

  /**
   *
   * @param id del Usuario
   * @return Un objeto de tipo Cliente
   * @throws ConnectionExcep
   */
  public Cliente getByIdUsuario(Integer id) throws ConnectionExcep {
    return clienteDAO.getByIdUsuario(id);
  }

  /**
   * Actualiza un objeto de tipo Cliente
   *
   * @param cliente
   * @throws ConnectionExcep
   */
  public void update(Cliente cliente) throws ConnectionExcep {
    clienteDAO.update(cliente);
  }

  /**
   * Elimina un objeto de tipo Cliente
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    clienteDAO.delete(id);
  }
}
