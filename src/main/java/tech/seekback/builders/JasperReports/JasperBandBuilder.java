package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import tech.seekback.enums.JasperReportsEnum;

public class JasperBandBuilder {
  private final JRDesignBand band;

  private JasperBandBuilder() {
    this.band = new JRDesignBand();
  }

  public static JasperBandBuilder start() {
    return new JasperBandBuilder();
  }

  public JasperBandBuilder defaultSettings(String text, JasperReportsEnum option, Integer columnWidth) {
    switch (option.getCode()) {
      case 1:
        this.band.setHeight(JasperReportsEnum.TITLE_HEIGHT.getCode());
        break;
      case 2:
        this.band.setHeight(JasperReportsEnum.SUBTITLE_HEIGHT.getCode());
        break;
    }
    return this;
  }

  public JasperBandBuilder setSectionHeight(Integer height) {
    this.band.setHeight(height);
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
