/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.interfaces;

import java.util.List;
import javax.ejb.Remote;
import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Ciudad;

/**
 *
 * @author camorenoc
 */
@Remote
public interface CiudadDAO extends DAO<Ciudad, Integer> {

  List<Ciudad> getByIdDepartamento(Integer idDepartamento) throws ConnectionExcep;
}
