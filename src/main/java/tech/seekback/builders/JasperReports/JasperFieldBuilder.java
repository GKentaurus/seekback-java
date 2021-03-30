package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.design.JRDesignField;

public class JasperFieldBuilder {
  private final JRDesignField field;

  private JasperFieldBuilder() {
    this.field = new JRDesignField();
  }

  public static JasperFieldBuilder start() {
    return new JasperFieldBuilder();
  }

  public JasperFieldBuilder setCompleteField(String name, Class dataType) {
    this.field.setName(name);
    this.field.setValueClass(dataType);
    return this;
  }

  public JasperFieldBuilder setCompleteField(String name, String dataTypeName) {
    this.field.setName(name);
    this.field.setValueClassName(dataTypeName);
    return this;
  }

  public JasperFieldBuilder setName(String name) {
    this.field.setName(name);
    return this;
  }

  public JasperFieldBuilder setDataType(String dataTypeName) {
    this.field.setValueClassName(dataTypeName);
    return this;
  }

  public JasperFieldBuilder setDataType(Class dataType) {
    this.field.setValueClass(dataType);
    return this;
  }

  public JRDesignField getField() {
    return this.field;
  }
}
