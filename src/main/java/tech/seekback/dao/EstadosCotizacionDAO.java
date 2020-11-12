/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosCotizacion;

/**
 *
 * @author camorenoc
 */
public interface EstadosCotizacionDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  EstadosCotizacion getOne(Integer id) throws ConnectionExcep;

  List<EstadosCotizacion> getAll() throws ConnectionExcep;

  void update(EstadosCotizacion obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
