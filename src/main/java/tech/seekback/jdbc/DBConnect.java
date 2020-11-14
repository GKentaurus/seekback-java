package tech.seekback.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 *
 * @author gkentaurus
 */
public class DBConnect {

  private static Connection connection;

  private DBConnect() {
  }

  private static void startConnection() {
    try {
      Properties propConnection = new Properties();
      propConnection.put(
              "url", "jdbc:mysql://sql158.main-hosting.eu/u925035511_seekback_test"
      );
      propConnection.put(
              "user", "u925035511_test"
      );
      propConnection.put(
              "password", "123PorMi"
      );

      connection = DriverManager.getConnection(
              propConnection.getProperty("url"),
              propConnection
      );
      System.out.println("Conexión con éxito");
    } catch (SQLException e) {
      System.out.println("Error de conexión");
      System.out.println(e);
    }
  }

  public static Connection getInstance() {
    if (Objects.isNull(connection)) {
      startConnection();
    }
    return connection;
  }
}
