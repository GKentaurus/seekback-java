/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Departamento;

import javax.ejb.Local;
import java.util.List;

/**
 * @author camorenoc
 */
@Local
public interface DepartamentoDAO extends DAO<Departamento, Integer> {
  List<Departamento> getByIdPais(Integer idPais) throws ConnectionExcep;
  void delete(Departamento departamento) throws ConnectionExcep;
}