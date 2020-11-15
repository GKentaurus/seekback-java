/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.mysql.tools;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author camorenoc
 */
public class SQLMaker {

  private List<Pair<String, String>> queryList;
  private String table;

  public SQLMaker() {
    this.queryList = new ArrayList<>();
  }

  public void setInt(String key, Integer value) {
    String convertedValue = Integer.toString(value);
    Pair<String, String> temp = new Pair<>(key, convertedValue);
    this.queryList.add(temp);
  }

  public void setDouble(String key, Double value) {
    String convertedValue = Double.toString(value);
    Pair<String, String> temp = new Pair<>(key, convertedValue);
    this.queryList.add(temp);
  }

  public void setString(String key, String value) {
    Pair<String, String> temp = new Pair<>(key, "'" + value + "'");
    this.queryList.add(temp);
  }

  public void setTableName(String table) {
    this.table = table;
  }

  public String getQuery() {
    int listSize = this.queryList.size();
    String column = "";
    String value = "";
    String sqlQuery = "SELECT * FROM " + this.table + " WHERE ";

    for (int i = 0; i < listSize; i++) {
      column = this.queryList.get(i).getKey();
      value = this.queryList.get(i).getValue();
      sqlQuery = sqlQuery.concat(column + " = " + value);
      if (i < listSize - 1) {
        sqlQuery = sqlQuery.concat(" AND ");
      }
    }
    return sqlQuery;
  }
}
