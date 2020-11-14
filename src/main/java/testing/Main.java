package testing;

import java.util.List;
import tech.seekback.dao.BodegaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.FactoryExcep;
import tech.seekback.factories.Factory;
import tech.seekback.factories.FactoryDAO;
import tech.seekback.models.Bodega;

/**
 *
 * @author camorenoc
 */
public class Main {

  public static void main(String[] args) {
    try {
      FactoryDAO factory = Factory.getFactoryDAO();
      BodegaDAO bodegaDAO = factory.getBodegaDAO();

      List<Bodega> obj = bodegaDAO.getAll();

      for (Bodega bodega : obj) {
        System.out.println(obj.toString());
      }
    } catch (ConnectionExcep | FactoryExcep ex) {
      ex.printStackTrace();
    }
  }
}
