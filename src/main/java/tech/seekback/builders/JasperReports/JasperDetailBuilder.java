package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.VerticalTextAlignEnum;

public class JasperDetailBuilder {
  private final JRDesignTextField text;

  private JasperDetailBuilder() {
    this.text = new JRDesignTextField();
  }

  public static JasperDetailBuilder start() {
    return new JasperDetailBuilder();
  }

  public JasperDetailBuilder defaultSettings(Integer columnWidth, Integer x, Integer y, String expression) {
    this.text.setRemoveLineWhenBlank(true);
    this.text.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
    this.text.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
    this.text.setHeight(10);
    this.text.setWidth(columnWidth);
    this.text.setX(x);
    this.text.setY(y);
    this.text.setFontSize(15f);
    this.text.setExpression(new JRDesignExpression("$F{" + expression + "}"));

    return this;
  }

  public JasperDetailBuilder setExpression(String expression) {
    this.text.setExpression(new JRDesignExpression("$F{" + expression + "}"));
    return this;
  }

  public JasperDetailBuilder setRemoveIfBlank(boolean removeIfBlank) {
    this.text.setRemoveLineWhenBlank(removeIfBlank);
    return this;
  }

  public JasperDetailBuilder setPosition(Integer x, Integer y) {
    this.text.setX(x);
    this.text.setY(y);
    return this;
  }

  public JasperDetailBuilder setTextDimensions(Integer width, Integer height) {
    this.text.setWidth(width);
    this.text.setHeight(height);
    return this;
  }

  public JasperDetailBuilder setTextAlign(HorizontalTextAlignEnum hAlign, VerticalTextAlignEnum vAlign) {
    this.text.setHorizontalTextAlign(hAlign);
    this.text.setVerticalTextAlign(vAlign);
    return this;
  }

  public JasperDetailBuilder setStyle(JRDesignStyle style) {
    this.text.setStyle(style);
    return this;
  }

  public JRDesignTextField getSection() {
    return this.text;
  }
}
