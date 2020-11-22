/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.AgendaDAO;
import tech.seekback.models.Agenda;

/**
 *
 * @author camorenoc
 */
@Stateless
public class AgendaDAOJPA extends GenericDAO<Agenda, Integer> implements AgendaDAO {

  public AgendaDAOJPA() {
    super(Agenda.class);
  }
}
