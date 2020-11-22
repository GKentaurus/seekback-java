/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.factories;

import tech.seekback.exceptions.FactoryExcep;
import tech.seekback.exceptions.enums.FactoryExcepEnum;

/**
 *
 * @author camorenoc
 */
public class Factory {

  private Factory() {
  }

  public static FactoryDAO getFactoryDAO() throws FactoryExcep {
    try {
      FactoryDAO factoryDAO = (FactoryDAO) Class
              .forName("tech.seekback.factories.FactoryDAOJPA")
              .newInstance();
      return factoryDAO;
    } catch (Exception ex) {
      throw new FactoryExcep(FactoryExcepEnum.ERROR_FABRICA_DAO, ex);
    }
  }
}
