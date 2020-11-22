/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import tech.seekback.dao.interfaces.UsuarioDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.exceptions.FactoryExcep;
import tech.seekback.factories.Factory;
import tech.seekback.factories.FactoryDAO;
import tech.seekback.models.Usuario;

/**
 *
 * @author camorenoc
 */
public class EncrypPass {

  public static void main(String[] args) throws ConnectionExcep, FactoryExcep, NoSuchAlgorithmException, InvalidKeySpecException {
    FactoryDAO factoryDAO = Factory.getFactoryDAO();
    UsuarioDAO dao = factoryDAO.getUsuarioDAO();

    List<Usuario> obj = dao.getAll();

    for (Usuario usuario : obj) {
      if (usuario.getSalt().equals(".")) {
        usuario.setContrasena(usuario.getContrasena());
        dao.update(usuario);
      } else {
        System.out.println("La contraseña ya había sido encriptada para el usuario # " + usuario.getIdUsuario());
      }
    }
  }
}
