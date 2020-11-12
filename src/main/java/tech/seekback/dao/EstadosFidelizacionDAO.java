/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.EstadosFidelizacion;

/**
 *
 * @author camorenoc
 */
public interface EstadosFidelizacionDAO {

  /**
   * CRUD Definition
   */
  void create();

  EstadosFidelizacion getOne(Integer id);

  List<EstadosFidelizacion> getAll();

  void update(EstadosFidelizacion obj);

  void delete(EstadosFidelizacion obj);
}
