package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.type.SplitTypeEnum;
import tech.seekback.enums.JasperReportsEnum;

public class JasperBandBuilder {
  private final JRDesignBand band;

  private JasperBandBuilder() {
    this.band = new JRDesignBand();
  }

  public static JasperBandBuilder start() {
    return new JasperBandBuilder();
  }

  public JasperBandBuilder defaultSettings(JasperReportsEnum size) {
    this.band.setSplitType(SplitTypeEnum.STRETCH);
    switch (size.getCode()) {
      case 1:
        this.band.setHeight(JasperReportsEnum.TITLE_HEIGHT.getCode());
        break;
      case 2:
        this.band.setHeight(JasperReportsEnum.SUBTITLE_HEIGHT.getCode());
        break;
    }
    return this;
  }


  public JasperBandBuilder defaultSettings(Integer size) {
    this.band.setHeight(size);
    return this;
  }

  public JasperBandBuilder setSplitType(SplitTypeEnum type) {
    this.band.setSplitType(type);
    return this;
  }

  public JasperBandBuilder addElement(JRDesignStaticText text) {
    this.band.addElement(text);
    return this;
  }

  public JasperBandBuilder addElement(JRDesignTextField field) {
    this.band.addElement(field);
    return this;
  }

  public JRDesignBand getBand() {
    return this.band;
  }
}
