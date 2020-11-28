package testing;

import tech.seekback.dao.interfaces.RolesDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.FactoryExcep;
import tech.seekback.factories.Factory;
import tech.seekback.factories.FactoryDAO;
import tech.seekback.models.Roles;

/**
 *
 * @author camorenoc
 */
public class Main {

  public static void main(String[] args) throws FactoryExcep, ConnectionExcep {
    FactoryDAO factoryDAO = Factory.getFactoryDAO();
    RolesDAO dao = factoryDAO.getRolesDAO();

    //Consultar por id
    Roles obj = dao.getOne(1);
    System.out.println(obj.getNombreRol());
    System.out.println("\nTodo bien....");
  }
}
