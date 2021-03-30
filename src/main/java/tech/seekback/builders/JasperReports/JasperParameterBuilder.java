package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.design.JRDesignParameter;

public class JasperParameterBuilder {
  private final JRDesignParameter parameter;

  private JasperParameterBuilder() {
    this.parameter = new JRDesignParameter();
  }

  public static JasperParameterBuilder start() {
    return new JasperParameterBuilder();
  }

  public JasperParameterBuilder setCompleteParameter(String name, Class dataType) {
    this.parameter.setName(name);
    this.parameter.setValueClass(dataType);
    return this;
  }

  public JasperParameterBuilder setCompleteParameter(String name, String dataTypeName) {
    this.parameter.setName(name);
    this.parameter.setValueClassName(dataTypeName);
    return this;
  }

  public JasperParameterBuilder setName(String name) {
    this.parameter.setName(name);
    return this;
  }

  public JasperParameterBuilder setDataType(String dataTypeName) {
    this.parameter.setValueClassName(dataTypeName);
    return this;
  }

  public JasperParameterBuilder setDataType(Class dataType) {
    this.parameter.setValueClass(dataType);
    return this;
  }

  public JRDesignParameter getParameter() {
    return this.parameter;
  }
}
