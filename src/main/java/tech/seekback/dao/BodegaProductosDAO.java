/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.BodegaProductos;

/**
 *
 * @author camorenoc
 */
public interface BodegaProductosDAO {

  /**
   * CRUD Definition
   */
  void create();

  BodegaProductos getOne(Integer id);

  List<BodegaProductos> getAll();

  void update(BodegaProductos obj);

  void delete(BodegaProductos obj);
}
