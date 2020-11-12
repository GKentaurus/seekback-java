/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Felicitacion;

/**
 *
 * @author camorenoc
 */
public interface FelicitacionDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Felicitacion getOne(Integer id) throws ConnectionExcep;

  List<Felicitacion> getAll() throws ConnectionExcep;

  void update(Felicitacion obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
