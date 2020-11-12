/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cliente;

/**
 *
 * @author camorenoc
 */
public interface ClienteDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Cliente getOne(Integer id) throws ConnectionExcep;

  List<Cliente> getAll() throws ConnectionExcep;

  void update(Cliente obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
