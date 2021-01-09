/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.DivisaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Divisa;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import java.util.Date;

/**
 *
 * @author camorenoc
 */
@Stateless
public class DivisaDAOJPA extends GenericDAO<Divisa, Integer> implements DivisaDAO {

  public DivisaDAOJPA() {
    super(Divisa.class);
  }

  /**
   * Elimina un objeto de tipo Divisa
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Divisa obj) throws ConnectionExcep {
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
