package tech.seekback.dao.interfaces;

import java.util.List;
import tech.seekback.dao.DAO;
import tech.seekback.models.TRM;

import javax.ejb.Local;
import tech.seekback.exceptions.ConnectionExcep;

/**
 * @author gkentaurus
 */
@Local
public interface TRMDAO extends DAO<TRM, Integer> {
  //

  List<TRM> getByidDivisa(Integer idDivisa) throws ConnectionExcep;
}
