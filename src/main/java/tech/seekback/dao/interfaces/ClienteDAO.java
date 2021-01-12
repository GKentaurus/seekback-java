/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cliente;

import javax.ejb.Local;

/**
 *
 * @author camorenoc
 */
@Local
public interface ClienteDAO extends DAO<Cliente, Integer> {
  Cliente getByIdUsuario(Integer id) throws ConnectionExcep;
  void delete(Cliente cliente) throws ConnectionExcep;
}