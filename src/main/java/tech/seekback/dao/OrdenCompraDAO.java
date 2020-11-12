/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.OrdenCompra;
// FIXME: Crear modelo OrdenCompra

/**
 *
 * @author camorenoc
 */
public interface OrdenCompraDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  OrdenCompra getOne(Integer id) throws ConnectionExcep;

  List<OrdenCompra> getAll() throws ConnectionExcep;

  void update(OrdenCompra obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
