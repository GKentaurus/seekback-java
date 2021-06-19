/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.tools;

import tech.seekback.exceptions.ConnectionExcep;

import javax.ejb.Stateless;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author camorenoc
 */
@Stateless
public class UploadFileService {

  private Part part;

  public Part getPart() {
    return part;
  }

  public void setPart(Part part) {
    this.part = part;
  }

  public void uploadFile() throws IOException, ConnectionExcep, ParseException {
    InputStream fileInputStream = part.getInputStream();
    String fileName = new Date().getTime() + "_" + part.getSubmittedFileName();
    File fileToSave = new File("resources/images/" + fileName);
    Files.copy(fileInputStream, fileToSave.toPath());

    String fileUrl = "http://localhost:8080/upload-files/" + fileName;
    System.out.println("Ruta del archivo: " + fileUrl);
  }
}
