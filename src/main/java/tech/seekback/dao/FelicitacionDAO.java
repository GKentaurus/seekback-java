/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Felicitacion;

/**
 *
 * @author camorenoc
 */
public interface FelicitacionDAO {

  /**
   * CRUD Definition
   */
  void create();

  Felicitacion getOne(Integer id);

  List<Felicitacion> getAll();

  void update(Felicitacion obj);

  void delete(Felicitacion obj);
}
