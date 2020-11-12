/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correos;

/**
 *
 * @author camorenoc
 */
public interface CorreosDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Correos getOne(Integer id) throws ConnectionExcep;

  List<Correos> getAll() throws ConnectionExcep;

  void update(Correos obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
