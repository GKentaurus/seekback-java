/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosFidelizacion;

/**
 *
 * @author camorenoc
 */
public interface EstadosFidelizacionDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  EstadosFidelizacion getOne(Integer id) throws ConnectionExcep;

  List<EstadosFidelizacion> getAll() throws ConnectionExcep;

  void update(EstadosFidelizacion obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
