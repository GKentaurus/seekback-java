/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Correos;

/**
 *
 * @author camorenoc
 */
public interface CorreosDAO {

  /**
   * CRUD Definition
   */
  void create();

  Correos getOne(Integer id);

  List<Correos> getAll();

  void update(Correos obj);

  void delete(Correos obj);
}
