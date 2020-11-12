/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Pais;

/**
 *
 * @author camorenoc
 */
public interface PaisDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Pais getOne(Integer id) throws ConnectionExcep;

  List<Pais> getAll() throws ConnectionExcep;

  void update(Pais obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
