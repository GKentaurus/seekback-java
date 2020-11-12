/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Cotizacion;

/**
 *
 * @author camorenoc
 */
public interface CotizacionDAO {

  /**
   * CRUD Definition
   */
  void create();

  Cotizacion getOne(Integer id);

  List<Cotizacion> getAll();

  void update(Cotizacion obj);

  void delete(Cotizacion obj);
}
