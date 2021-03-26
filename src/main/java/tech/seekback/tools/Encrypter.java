
package tech.seekback.tools;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

/**
 * Por medio de una llave generada de forma aleatoria (salt), permite la
 * encriptación de las contraseñas enviadas por parte del usuario, para ser
 * almacenadas en la base de datos.
 * <p>
 * Tanto la llave (salt) como la contraseña, son almacenadas en la base de datos
 * de forma que, al momento de requerir la verificación de contraseña, esta
 * indique si es verdadero o falso.
 *
 * @author camorenoc
 */
public class Encrypter {

  private static final Random RANDOM = new SecureRandom();
  private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  private static final int ITERATIONS = 10000;
  private static final int KEY_LENGTH = 256;

  /**
   * Genera una llave aleatoria con caracteres alfabéticos y numéricos (sin
   * acentos ni caracteres especiales), la cual será la base de encriptación de
   * una contraseña, y que será almacenada en la base de datos junto con la
   * contraseña encriptada.
   *
   * @param length Longitud de la llave a generar.
   * @return Llave de encriptación.
   */
  public static String getSalt(int length) {
    StringBuilder returnValue = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
    }
    String saltKey = new String(returnValue);
    return saltKey;
  }

  /**
   * Genera un Array de tipo byte, el cual servirá como base de encriptación pra
   * la contraseña.
   *
   * @param password Contraseña indicada por el usuario.
   * @param salt     Llave de encriptación.
   * @return Hash para la generación de contraseña segura.
   */
  public static byte[] hash(char[] password, byte[] salt) {
    PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
    Arrays.fill(password, Character.MIN_VALUE);
    try {
      SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      return skf.generateSecret(spec).getEncoded();
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
    } finally {
      spec.clearPassword();
    }
  }

  /**
   * Genera la contraseña encriptada para ser almacenada en la base de datos.
   *
   * @param password Contraseña indicada por el usuario.
   * @param salt     Llave de encriptación generada previamente.
   * @return Contraseña encriptada.
   */
  public static String generateSecurePassword(String password, String salt) {
    String returnValue = null;
    byte[] securePassword = hash(password.toCharArray(), salt.getBytes());

    returnValue = Base64.getEncoder().encodeToString(securePassword);

    return returnValue;
  }

  /**
   * Comprueba si la clave proveida por el usuario, al momento de pasar por el
   * proceso de encriptación con la llave (salt), retorna la misma cadena de
   * caracteres o una totalmente distinta.
   *
   * @param providedPassword Contraseña proveida para el inicio de sesión.
   * @param securedPassword  Contraseña encriptada, almacenada en la base de
   *                         datos.
   * @param salt             Llave de encriptación correspondiente al usuario, con la que se
   *                         encriptará la contraseña proveida.
   * @return <code>true</code> si la llave encriptada almacenada y la proveida
   * encriptada son la misma.
   */
  public static boolean verifyUserPassword(String providedPassword,
                                           String securedPassword, String salt) {
    boolean returnValue = false;

    // Genera una nueva contraseña segura con la misma llave (salt).
    String newSecurePassword = generateSecurePassword(providedPassword, salt);

    // Comprueba si la nueva contraseña segura coincide con la almacenada.
    returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);

    return returnValue;
  }
}
