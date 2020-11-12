/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;

/**
 *
 * @author camorenoc
 */
public interface CotizacionDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Cotizacion getOne(Integer id) throws ConnectionExcep;

  List<Cotizacion> getAll() throws ConnectionExcep;

  void update(Cotizacion obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
