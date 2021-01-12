/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import tech.seekback.dao.interfaces.EstadosFidelizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosFidelizacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author camorenoc
 */
@Stateless
public class EstadosFidelizacionService {

  @EJB
  private EstadosFidelizacionDAO estadosFidelizacionDAO;

  /**
   * @param obj
   * @return Un objeto de tipo EstadosFidelizacion
   * @throws ConnectionExcep
   */
  public EstadosFidelizacion create(EstadosFidelizacion obj) throws ConnectionExcep {
    return estadosFidelizacionDAO.create(obj);
  }

  /**
   * @param id
   * @return Un objeto de tipo EstadosFidelizacion consultado por id
   * @throws ConnectionExcep
   */
  public EstadosFidelizacion getOne(Integer id) throws ConnectionExcep {
    return estadosFidelizacionDAO.getOne(id);
  }

  /**
   * Una colección de objetos de tipo EstadosFidelizacion (referente al Dao que lo implementa)
   *
   * @return @throws ConnectionExcep
   */
  public List<EstadosFidelizacion> getAll() throws ConnectionExcep {
    List<EstadosFidelizacion> estadosFidelizaciones = estadosFidelizacionDAO.getAll();
    return estadosFidelizaciones;
  }

  /**
   * Actualiza un objeto de tipo EstadosFidelizacion
   *
   * @param estadosFidelizacion
   * @throws ConnectionExcep
   */
  public void update(EstadosFidelizacion estadosFidelizacion) throws ConnectionExcep {
    estadosFidelizacionDAO.update(estadosFidelizacion);
  }

  /**
   * Elimina un objeto de tipo EstadosFidelizacion
   *
   * @param estadosFidelizacion
   * @throws ConnectionExcep
   */
  public void delete(EstadosFidelizacion estadosFidelizacion) throws ConnectionExcep {
    estadosFidelizacionDAO.delete(estadosFidelizacion);
  }
}