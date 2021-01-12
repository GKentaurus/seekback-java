/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author camorenoc
 */
@Local
public interface CiudadDAO extends DAO<Ciudad, Integer> {
  List<Ciudad> getByIdDepartamento(Integer idDepartamento) throws ConnectionExcep;
  void delete(Ciudad ciudad) throws ConnectionExcep;
}