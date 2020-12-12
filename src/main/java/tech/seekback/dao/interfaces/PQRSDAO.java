/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.interfaces;

import java.util.List;
import javax.ejb.Local;
import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.PQRS;

/**
 *
 * @author camorenoc
 */
@Local
public interface PQRSDAO extends DAO<PQRS, Integer> {

  /**
   *
   * @return @throws ConnectionExcep
   */
  Integer getAllCount() throws ConnectionExcep;

}
