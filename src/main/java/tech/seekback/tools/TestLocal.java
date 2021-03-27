package tech.seekback.tools;

public class TestLocal {
  public static void main(String[] args) {
    String alphabet = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
    System.out.println("La letra que sale es: " + alphabet.substring(alphabet.length()-1, alphabet.length()));
  }
}
