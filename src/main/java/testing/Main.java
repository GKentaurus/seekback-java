package testing;

import tech.seekback.dao.interfaces.RolesDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.FactoryExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.enums.FactoryExcepEnum;
import tech.seekback.factories.Factory;
import tech.seekback.factories.FactoryDAO;
import tech.seekback.models.Roles;

/**
 *
 * @author camorenoc
 */
public class Main {

  public static void main(String[] args) throws FactoryExcep, ConnectionExcep {
    try {
      FactoryDAO f = Factory.getFactoryDAO();
      RolesDAO dao = f.getRolesDAO();

      Roles obj = dao.getOne(1);
      System.out.println(obj.toString());
    } catch (ConnectionExcep ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    } catch (FactoryExcep ex) {
      throw new FactoryExcep(FactoryExcepEnum.ERROR_FABRICA_DAO, ex);
    }
  }
}
