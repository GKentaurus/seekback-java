
package tech.seekback.factories;

import tech.seekback.exceptions.FactoryExcep;
import tech.seekback.exceptions.enums.FactoryExcepEnum;

/**
 * @author gkentaurus
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
