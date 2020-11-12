/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Cliente;

/**
 *
 * @author camorenoc
 */
public interface ClienteDAO {

  /**
   * CRUD Definition
   */
  void create();

  Cliente getOne(Integer id);

  List<Cliente> getAll();

  void update(Cliente obj);

  void delete(Cliente obj);
}
