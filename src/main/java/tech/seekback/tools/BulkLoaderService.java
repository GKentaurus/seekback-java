package tech.seekback.tools;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;

import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BulkLoaderService<T, PK> {

  private Part part;
  private List<T> dataToUpload;
  private List<String[]> errors;
  private DAO<T, PK> dao;

  protected void setDAO(DAO<T, PK> dao) {
    this.dao = dao;
  }

  public Part getPart() {
    return part;
  }
  public void setPart(Part part) {
    this.part = part;
  }
  public List<T> getDataToUpload() {
    return dataToUpload;
  }
  public void setDataToUpload(List<T> dataToUpload) {
    this.dataToUpload = dataToUpload;
  }
  public List<String[]> getErrors() {
    return errors;
  }
  public void setErrors(List<String[]> errors) {
    this.errors = errors;
  }
  public void uploadData() throws IOException, ConnectionExcep, ParseException {
    this.dataToUpload = new ArrayList<>();
    this.errors = new ArrayList<>();
    InputStreamReader inputStreamReader = new InputStreamReader(part.getInputStream());
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String line = bufferedReader.readLine();

    while(Objects.nonNull(line = bufferedReader.readLine())) {
      T obj = objectMaker(line, 5);
      if (Objects.nonNull(obj)) {
        this.dataToUpload.add(obj);
      }
    }

    if (!this.dataToUpload.isEmpty() && this.errors.isEmpty()) {
      this.dao.create(this.dataToUpload);
    } else {
      for (String[] error: this.errors) {
        System.out.println("****************************************************************************");
        System.out.println("*\tError: " + error[0]);
        System.out.println("*\tCause: " + error[1]);
        System.out.println("****************************************************************************");
      }
    }
  }

  protected abstract T objectMaker(String line, Integer modelFieldsCount) throws ConnectionExcep, ParseException;
}
