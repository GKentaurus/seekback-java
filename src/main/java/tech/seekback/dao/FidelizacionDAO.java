/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Fidelizacion;

/**
 *
 * @author camorenoc
 */
public interface FidelizacionDAO {

  /**
   * CRUD Definition
   */
  void create();

  Fidelizacion getOne(Integer id);

  List<Fidelizacion> getAll();

  void update(Fidelizacion obj);

  void delete(Fidelizacion obj);
}
