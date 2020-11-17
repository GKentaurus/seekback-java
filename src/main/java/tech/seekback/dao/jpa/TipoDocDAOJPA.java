/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TipoDocDAO;
import tech.seekback.models.TipoDoc;

/**
 *
 * @author camorenoc
 */
public class TipoDocDAOJPA extends GenericDAO<TipoDoc, Integer> implements TipoDocDAO {

  public TipoDocDAOJPA() {
    super(TipoDoc.class);
  }
}
