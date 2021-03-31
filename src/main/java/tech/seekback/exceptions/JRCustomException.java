package tech.seekback.exceptions;

public class JRCustomException extends Exception{
  public JRCustomException(Throwable throwable) {
    super(throwable);
  }
  public JRCustomException(String error) {
    super(error);
  }
}
