package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.models.Bodega;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface BodegaDAO extends DAO<Bodega, Integer> {
  //
}
