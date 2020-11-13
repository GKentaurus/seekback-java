/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.PQRS;

/**
 *
 * @author camorenoc
 */
public interface PQRSDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  PQRS getOne(Integer id) throws ConnectionExcep;

  List<PQRS> getAll() throws ConnectionExcep;

  void update(PQRS obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
