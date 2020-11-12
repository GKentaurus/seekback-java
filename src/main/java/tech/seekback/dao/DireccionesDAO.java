/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Direcciones;

/**
 *
 * @author camorenoc
 */
public interface DireccionesDAO {

  /**
   * CRUD Definition
   */
  void create();

  Direcciones getOne(Integer id);

  List<Direcciones> getAll();

  void update(Direcciones obj);

  void delete(Direcciones obj);
}
