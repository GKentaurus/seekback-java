/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoSolicitud;
// FIXME: Crear modelo TipoSolicitud

/**
 *
 * @author camorenoc
 */
public interface TipoSolicitudDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  TipoSolicitud getOne(Integer id) throws ConnectionExcep;

  List<TipoSolicitud> getAll() throws ConnectionExcep;

  void update(TipoSolicitud obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
