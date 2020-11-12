/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Agenda;

/**
 *
 * @author camorenoc
 */
public interface AgendaDAO {

  // CRUD Definition
  void create() throws ConnectionExcep;

  Agenda getOne(Integer id) throws ConnectionExcep;

  List<Agenda> getAll() throws ConnectionExcep;

  void update(Agenda obj) throws ConnectionExcep;

  void delete(Integer id) throws ConnectionExcep;
}
