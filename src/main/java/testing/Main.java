package testing;

import java.util.List;
import tech.seekback.dao.BodegaDAO;
import tech.seekback.dao.RolesDAO;
import tech.seekback.dao.TipoDocDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.FactoryExcep;
import tech.seekback.factories.Factory;
import tech.seekback.factories.FactoryDAO;
import tech.seekback.models.Bodega;
import tech.seekback.models.Roles;
import tech.seekback.models.TipoDoc;

/**
 *
 * @author camorenoc
 */
public class Main {

  public static void main(String[] args) {
    try {
      FactoryDAO f = Factory.getFactoryDAO();
      RolesDAO dao = f.getRolesDAO();

      Roles rol = dao.getOne(4);
      List<Roles> listaRol = dao.getAll();
      System.out.println(rol.toString());
      System.out.println("--------------------------------------------------");
      for (Roles rolLista : listaRol) {
        System.out.println(rolLista.toString());
      }
    } catch (ConnectionExcep | FactoryExcep ex) {
      ex.printStackTrace();
    }
  }
}
