/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Divisas;

/**
 *
 * @author camorenoc
 */
public interface DivisasDAO {

  /**
   * CRUD Definition
   */
  void create();

  Divisas getOne(Integer id);

  List<Divisas> getAll();

  void update(Divisas obj);

  void delete(Divisas obj);
}
