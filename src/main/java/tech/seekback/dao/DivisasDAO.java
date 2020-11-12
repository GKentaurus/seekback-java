/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Divisas;

/**
 *
 * @author camorenoc
 */
public interface DivisasDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Divisas getOne(Integer id) throws ConnectionExcep;

  List<Divisas> getAll() throws ConnectionExcep;

  void update(Divisas obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
