/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.AdministradorDAO;
import tech.seekback.models.Administrador;

/**
 *
 * @author camorenoc
 */
public class AdministradorDAOJPA extends GenericDAO<Administrador, Integer> implements AdministradorDAO {

  public AdministradorDAOJPA() {
    super(Administrador.class);
  }
}
