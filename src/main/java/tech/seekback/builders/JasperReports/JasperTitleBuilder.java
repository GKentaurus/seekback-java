package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.VerticalTextAlignEnum;
import tech.seekback.enums.JasperReportsEnum;

public class JasperTitleBuilder {
  private final JRDesignStaticText text;

  private JasperTitleBuilder() {
    this.text = new JRDesignStaticText();
  }

  public static JasperTitleBuilder start() {
    return new JasperTitleBuilder();
  }

  public JasperTitleBuilder defaultSettings(String text, JasperReportsEnum option, Integer columnWidth) {
    this.text.setText(text);
    this.text.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
    this.text.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
    this.text.setWidth(columnWidth);
    this.text.setX(0);

    switch (option.getCode()) {
      case 1:
        this.text.setY(0);
        this.text.setHeight(JasperReportsEnum.TITLE_HEIGHT.getCode() - 10);
        this.text.setFontSize(30f);
        break;
      case 2:
        this.text.setY(JasperReportsEnum.SUBTITLE_HEIGHT.getCode() + 5);
        this.text.setHeight(JasperReportsEnum.SUBTITLE_HEIGHT.getCode() - 5);
        this.text.setFontSize(26f);
        break;
    }
    return this;
  }

  public JasperTitleBuilder setText(String text) {
    this.text.setText(text);
    return this;
  }


  public JasperTitleBuilder setPosition(Integer x, Integer y) {
    this.text.setX(x);
    this.text.setY(y);
    return this;
  }

  public JasperTitleBuilder setTextDimensions(Integer width, Integer height) {
    this.text.setWidth(width);
    this.text.setHeight(height);
    return this;
  }

  public JasperTitleBuilder setTextAlign(HorizontalTextAlignEnum hAlign, VerticalTextAlignEnum vAlign) {
    this.text.setHorizontalTextAlign(hAlign);
    this.text.setVerticalTextAlign(vAlign);
    return this;
  }

  public JRDesignStaticText getText() {
    return this.text;
  }
}
