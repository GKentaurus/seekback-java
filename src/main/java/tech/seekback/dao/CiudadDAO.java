/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Ciudad;

/**
 *
 * @author camorenoc
 */
public interface CiudadDAO {

  /**
   * CRUD Definition
   */
  void create();

  Ciudad getOne(Integer id);

  List<Ciudad> getAll();

  void update(Ciudad obj);

  void delete(Ciudad obj);
}
