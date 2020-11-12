/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.models.Agenda;

/**
 *
 * @author camorenoc
 */
public interface AgendaDAO {

  /**
   * CRUD Definition
   */
  void create();

  Agenda getOne(Integer id);

  List<Agenda> getAll();

  void update(Agenda obj);

  void delete(Agenda obj);
}
