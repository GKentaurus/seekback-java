/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Calificacion;

/**
 *
 * @author camorenoc
 */
public interface CalificacionDAO {

  /**
   * CRUD Definition
   */
  void create();

  Calificacion getOne(Integer id);

  List<Calificacion> getAll();

  void update(Calificacion obj);

  void delete(Calificacion obj);
}
