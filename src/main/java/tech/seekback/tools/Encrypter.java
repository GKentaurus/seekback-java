/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.tools;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author camorenoc
 */
public class Encrypter {

  public static String cryptoGetHash(String passphrase) throws NoSuchAlgorithmException, InvalidKeySpecException {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);

    KeySpec ks = new PBEKeySpec(passphrase.toCharArray(), salt, 65536, 128);
    SecretKeyFactory kf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    byte[] hash = kf.generateSecret(ks).getEncoded();

    return Arrays.toString(hash);
  }
}
