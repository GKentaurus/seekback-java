package testing;

import tech.seekback.dao.interfaces.AdministradorDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.FactoryExcep;
import tech.seekback.factories.Factory;
import tech.seekback.factories.FactoryDAO;
import tech.seekback.models.Administrador;

/**
 *
 * @author camorenoc
 */
public class Main {

  public static void main(String[] args) throws FactoryExcep, ConnectionExcep {
    FactoryDAO factoryDAO = Factory.getFactoryDAO();
    AdministradorDAO dao = factoryDAO.getAdministradorDAO();

    //Consultar por id
    Administrador obj = dao.getOne(1);
    System.out.println(obj.toString());
    System.out.println("\n\n\n\n\nTodo bien....");
  }
}
