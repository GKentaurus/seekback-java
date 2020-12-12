/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.interfaces;

import javax.ejb.Local;
import tech.seekback.dao.DAO;
import tech.seekback.models.TRM;

/**
 *
 * @author camorenoc
 */
@Local
public interface TRMDAO extends DAO<TRM, Integer> {
}
