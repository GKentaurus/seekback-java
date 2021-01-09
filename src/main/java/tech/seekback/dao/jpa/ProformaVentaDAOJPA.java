/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProformaVentaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.ProformaVenta;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import java.util.Date;

/**
 *
 * @author camorenoc
 */
@Stateless
public class ProformaVentaDAOJPA extends GenericDAO<ProformaVenta, Integer> implements ProformaVentaDAO {

  public ProformaVentaDAOJPA() {
    super(ProformaVenta.class);
  }

  /**
   * Elimina un objeto de tipo ProformaVenta
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(ProformaVenta obj) throws ConnectionExcep {
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
