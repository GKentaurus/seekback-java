package testing;

import java.util.List;
import tech.seekback.dao.BodegaDAO;
import tech.seekback.dao.TipoDocDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.FactoryExcep;
import tech.seekback.factories.Factory;
import tech.seekback.factories.FactoryDAO;
import tech.seekback.models.Bodega;
import tech.seekback.models.TipoDoc;

/**
 *
 * @author camorenoc
 */
public class Main {

  public static void main(String[] args) {
    try {
      FactoryDAO factory = Factory.getFactoryDAO();
      TipoDocDAO dao = factory.getTipoDocDAO();

      List<TipoDoc> obj = dao.getAll();

      for (TipoDoc tipoDoc : obj) {
        System.out.println(tipoDoc.toString());
      }

    } catch (ConnectionExcep | FactoryExcep ex) {
      ex.printStackTrace();
    }
  }
}
