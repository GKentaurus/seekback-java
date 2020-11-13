/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;
// FIXME: Crear el modelo Producto

/**
 *
 * @author camorenoc
 */
public interface ProductoDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Producto getOne(Integer id) throws ConnectionExcep;

  List<Producto> getAll() throws ConnectionExcep;

  void update(Producto obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
