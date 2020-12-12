/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.CorreoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;

/**
 *
 * @author danny
 */
@Stateless
public class CorreoService {

  @EJB
  private CorreoDAO correosDAO;

  /**
   *
   * @param correos
   * @return Un objeto de tipo Correo
   * @throws ConnectionExcep
   */
  public Correo create(Correo correos) throws ConnectionExcep {
    return correosDAO.create(correos);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo Correo consultado por el id
   * @throws ConnectionExcep
   */
  public Correo getOne(Integer id) throws ConnectionExcep {
    return correosDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo Correo (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Correo> getAll() throws ConnectionExcep {
    List<Correo> correos = correosDAO.getAll();
    return correos;
  }

  /**
   *
   * @param correo
   * @return Una colección de objetos de tipo Correo consultados por correo
   * @throws ConnectionExcep
   */
  public Correo getByCorreo(String correo) throws ConnectionExcep {
    return correosDAO.getByCorreo(correo);
  }

  /**
   * Actualiza un objeto de tipo Correo
   *
   * @param correo
   * @throws ConnectionExcep
   */
  public void update(Correo correo) throws ConnectionExcep {
    correosDAO.update(correo);
  }

  /**
   * Elimina un objeto de tipo Correo
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    correosDAO.delete(id);
  }
}
