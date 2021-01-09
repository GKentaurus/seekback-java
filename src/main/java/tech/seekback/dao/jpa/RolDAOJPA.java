/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.RolDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Rol;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import java.util.Date;

/**
 *
 * @author camorenoc
 */
@Stateless
public class RolDAOJPA extends GenericDAO<Rol, Integer> implements RolDAO {

  public RolDAOJPA() {
    super(Rol.class);
  }

  /**
   * Elimina un objeto de tipo Rol
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Rol obj) throws ConnectionExcep {
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
