/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.BodegaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Bodega;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import java.util.Date;

/**
 *
 * @author camorenoc
 */
@Stateless
public class BodegaDAOJPA extends GenericDAO<Bodega, Integer> implements BodegaDAO {

  public BodegaDAOJPA() {
    super(Bodega.class);
  }

  /**
   * Elimina un objeto de tipo Bodega
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Bodega obj) throws ConnectionExcep {
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Eliminando el objeto No. " + this.classType.getSimpleName()
        + "\n######################################################################\n"
    );
    Timestamps tt = obj.getTimestamps();
    tt.setDeleted(true);
    tt.setDeleted_at(new Date());
    obj.setTimestamps(tt);
    create(obj);
  }
}