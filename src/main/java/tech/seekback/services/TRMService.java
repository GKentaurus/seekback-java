package tech.seekback.services;

import tech.seekback.dao.interfaces.DivisaDAO;
import tech.seekback.dao.interfaces.TRMDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;
import tech.seekback.models.TRM;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author gkentaurus
 */
@Stateless
public class TRMService {

  @EJB
  private TRMDAO trmDao;

  @EJB
  private DivisaDAO divisaDAO;

  private Part part;
  private List<TRM> dataToUpload;
  private List<String[]> errors;

  /**
   * @param trm
   * @return Un objeto de tipo TRM
   * @throws ConnectionExcep
   */
  public TRM create(TRM trm) throws ConnectionExcep {
    return trmDao.create(trm);
  }

  /**
   * @param id
   * @return Un objeto de tipo TRM consultado por id
   * @throws ConnectionExcep
   */
  public TRM getOne(Integer id) throws ConnectionExcep {
    return trmDao.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo TRM (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public List<TRM> getAll() throws ConnectionExcep {
    List<TRM> trms = trmDao.getAll();
    return trms;
  }

  public List<TRM> getByidDivisa(Integer idDivisa) throws ConnectionExcep {
    List<TRM> trmsByidDivisa = trmDao.getByidDivisa(idDivisa);
    return trmsByidDivisa;
  }

  /**
   * Actualiza un objeto de tipo TRM
   *
   * @param trm
   * @throws ConnectionExcep
   */
  public void update(TRM trm) throws ConnectionExcep {
    trmDao.update(trm);
  }

  /**
   * Elimina un objeto de tipo TRM
   *
   * @param trm
   * @throws ConnectionExcep
   */
  public void delete(TRM trm) throws ConnectionExcep {
    trmDao.delete(trm);
  }

  //<editor-fold desc="Bulk Load" defaultstate="collapsed">
  public void uploadData() throws IOException, ConnectionExcep, ParseException {
    this.dataToUpload = new ArrayList<>();
    this.errors = new ArrayList<>();
    InputStreamReader inputStreamReader = new InputStreamReader(part.getInputStream());
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String line = bufferedReader.readLine();

    while(Objects.nonNull(line = bufferedReader.readLine())) {
      TRM trm = objectMaker(line, 3);
      if (Objects.nonNull(trm)) {
        this.dataToUpload.add(trm);
      }
    }

    if (!this.dataToUpload.isEmpty() && this.errors.isEmpty()) {
      this.trmDao.create(this.dataToUpload);
    } else {
      for (String[] error: this.errors) {
        System.out.println("****************************************************************************");
        System.out.println("*\tError: " + error[0]);
        System.out.println("*\tCause: " + error[1]);
        System.out.println("****************************************************************************");
      }
    }
  }

  public Part getPart() {
    return part;
  }
  public void setPart(Part part) {
    this.part = part;
  }

  private TRM objectMaker(String line, Integer modelFieldsCount) throws ConnectionExcep, ParseException {
    String[] data = line.split(";");
    TRM trm = null;
    if (data.length == modelFieldsCount) {
      trm = new TRM();
      trm.setDivisa(this.divisaDAO.getOne(Integer.parseInt(data[0])));
      trm.setFecha(new SimpleDateFormat("dd/MM/yyyy").parse(data[1]));
      trm.setTasaCambio(Double.parseDouble(data[2]));
      Date date = new Date();
      Timestamps ts = new Timestamps();
      ts.setCreated_at(date);
      ts.setUpdated_at(date);
      trm.setTimestamps(ts);
    } else {
      this.errors.add(new String[] {"Se esperaban " + modelFieldsCount + ", se recibieron " + data.length, line});
    }
    return trm;
  }

  //</editor-fold>
}
