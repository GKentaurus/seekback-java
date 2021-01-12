/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EstadosCotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosCotizacion;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import java.util.Date;

/**
 *
 * @author camorenoc
 */
@Stateless
public class EstadosCotizacionDAOJPA extends GenericDAO<EstadosCotizacion, Integer> implements EstadosCotizacionDAO {

  public EstadosCotizacionDAOJPA() {
    super(EstadosCotizacion.class);
  }

  /**
   * Elimina un objeto de tipo EstadosCotizacion
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(EstadosCotizacion obj) throws ConnectionExcep {
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
