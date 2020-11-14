/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Bodega;

/**
 *
 * @author camorenoc
 */
public interface BodegaDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Bodega getOne(Integer id) throws ConnectionExcep;

  List<Bodega> getAll() throws ConnectionExcep;

  void update(Bodega obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
