/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Telefonos;

/**
 *
 * @author camorenoc
 */
public interface TelefonosDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Telefonos getOne(Integer id) throws ConnectionExcep;

  List<Telefonos> getAll() throws ConnectionExcep;

  void update(Telefonos obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
