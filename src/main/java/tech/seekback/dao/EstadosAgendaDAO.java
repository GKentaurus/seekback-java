/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosAgenda;

/**
 *
 * @author camorenoc
 */
public interface EstadosAgendaDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  EstadosAgenda getOne(Integer id) throws ConnectionExcep;

  List<EstadosAgenda> getAll() throws ConnectionExcep;

  void update(EstadosAgenda obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
