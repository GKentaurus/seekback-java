/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Proveedor;

/**
 *
 * @author camorenoc
 */
public interface ProveedorDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Proveedor getOne(Integer id) throws ConnectionExcep;

  List<Proveedor> getAll() throws ConnectionExcep;

  void update(Proveedor obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
