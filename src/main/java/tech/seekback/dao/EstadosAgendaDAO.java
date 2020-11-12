/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.EstadosAgenda;

/**
 *
 * @author camorenoc
 */
public interface EstadosAgendaDAO {

  /**
   * CRUD Definition
   */
  void create();

  EstadosAgenda getOne(Integer id);

  List<EstadosAgenda> getAll();

  void update(EstadosAgenda obj);

  void delete(EstadosAgenda obj);
}
