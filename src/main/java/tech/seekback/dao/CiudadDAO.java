/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;

/**
 *
 * @author camorenoc
 */
public interface CiudadDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Ciudad getOne(Integer id) throws ConnectionExcep;

  List<Ciudad> getAll() throws ConnectionExcep;

  void update(Ciudad obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
