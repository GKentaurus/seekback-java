/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.CategoriasProducto;

/**
 *
 * @author camorenoc
 */
public interface CategoriasProductoDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  CategoriasProducto getOne(Integer id) throws ConnectionExcep;

  List<CategoriasProducto> getAll() throws ConnectionExcep;

  void update(CategoriasProducto obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
