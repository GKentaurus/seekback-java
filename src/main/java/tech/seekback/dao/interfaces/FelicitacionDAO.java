/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Felicitacion;

import javax.ejb.Local;

/**
 * @author camorenoc
 */
@Local
public interface FelicitacionDAO extends DAO<Felicitacion, Integer> {
  Integer getAllCount() throws ConnectionExcep;
  void delete(Felicitacion felicitacion) throws ConnectionExcep;
}