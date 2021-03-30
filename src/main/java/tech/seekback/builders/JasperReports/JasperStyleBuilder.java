package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.design.JRDesignStyle;

public class JasperStyleBuilder {
  private final JRDesignStyle style;

  private JasperStyleBuilder() {
    this.style = new JRDesignStyle();
  }

  public static JasperStyleBuilder start() {
    return new JasperStyleBuilder();
  }

  public JasperStyleBuilder defaultSettings(String name, Float fontSize, boolean isDefault) {
    this.style.setName(name);
    this.style.setDefault(isDefault);
    this.style.setFontName("DejaVu Sans");
    this.style.setPdfFontName("Helvetica");
    this.style.setPdfEncoding("UTF-8");
    this.style.setFontSize(fontSize);
    return this;
  }

  public JasperStyleBuilder setName(String name) {
    this.style.setName(name);
    return this;
  }

  public JasperStyleBuilder setDefaultStyle(boolean isDefault) {
    this.style.setDefault(isDefault);
    return this;
  }

  public JasperStyleBuilder setFontName(String fontName) {
    this.style.setFontName(fontName);
    return this;
  }

  public JasperStyleBuilder setPdfFontName(String pdfFontName) {
    this.style.setPdfFontName(pdfFontName);
    return this;
  }

  public JasperStyleBuilder setGeneralFontName(String generalFontName) {
    this.style.setPdfFontName(generalFontName);
    this.style.setFontName(generalFontName);
    return this;
  }

  public JasperStyleBuilder setFontSize (Float fontSize) {
    this.style.setFontSize(fontSize);
    return this;
  }

  public JasperStyleBuilder setEncoding(String encoding) {
    this.style.setPdfEncoding(encoding);
    return this;
  }

  public JRDesignStyle getStyle() {
    return this.style;
  }
}
