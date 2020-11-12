/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Pais;

/**
 *
 * @author camorenoc
 */
public interface PaisDAO {

  /**
   * CRUD Definition
   */
  void create();

  Pais getOne(Integer id);

  List<Pais> getAll();

  void update(Pais obj);

  void delete(Pais obj);
}
