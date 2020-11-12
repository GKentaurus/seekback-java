/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Administrador;

/**
 *
 * @author camorenoc
 */
public interface AdministradorDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Administrador getOne(Integer id) throws ConnectionExcep;

  List<Administrador> getAll() throws ConnectionExcep;

  void update(Administrador obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
