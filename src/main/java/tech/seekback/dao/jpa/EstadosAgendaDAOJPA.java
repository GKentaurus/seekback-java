/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EstadosAgendaDAO;
import tech.seekback.models.EstadosAgenda;

/**
 *
 * @author camorenoc
 */
public class EstadosAgendaDAOJPA extends GenericDAO<EstadosAgenda, Integer> implements EstadosAgendaDAO {

  public EstadosAgendaDAOJPA() {
    super(EstadosAgenda.class);
  }
}
