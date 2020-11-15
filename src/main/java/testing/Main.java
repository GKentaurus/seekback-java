package testing;

import java.util.List;
import tech.seekback.dao.TipoDocDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.FactoryExcep;
import tech.seekback.exceptions.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.enums.FactoryExcepEnum;
import tech.seekback.factories.Factory;
import tech.seekback.factories.FactoryDAO;
import tech.seekback.models.TipoDoc;

/**
 *
 * @author camorenoc
 */
public class Main {

  public static void main(String[] args) throws FactoryExcep, ConnectionExcep {
    try {
      FactoryDAO f = Factory.getFactoryDAO();
      TipoDocDAO dao = f.getTipoDocDAO();

      TipoDoc obj = dao.getOne(10);
      System.out.println(obj.toString());

      List<TipoDoc> list = dao.getAll();

      for (TipoDoc tipoDoc : list) {
        System.out.println(tipoDoc.toString());
      }
    } catch (ConnectionExcep ex) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_CONSULTA, ex);
    } catch (FactoryExcep ex) {
      throw new FactoryExcep(FactoryExcepEnum.ERROR_FABRICA_DAO, ex);
    }
  }
}
