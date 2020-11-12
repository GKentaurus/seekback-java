/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.EstadosCotizacion;

/**
 *
 * @author camorenoc
 */
public interface EstadosCotizacionDAO {

  /**
   * CRUD Definition
   */
  void create();

  EstadosCotizacion getOne(Integer id);

  List<EstadosCotizacion> getAll();

  void update(EstadosCotizacion obj);

  void delete(EstadosCotizacion obj);
}
