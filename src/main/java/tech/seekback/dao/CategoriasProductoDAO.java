/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.CategoriasProducto;

/**
 *
 * @author camorenoc
 */
public interface CategoriasProductoDAO {

  /**
   * CRUD Definition
   */
  void create();

  CategoriasProducto getOne(Integer id);

  List<CategoriasProducto> getAll();

  void update(CategoriasProducto obj);

  void delete(CategoriasProducto obj);
}
