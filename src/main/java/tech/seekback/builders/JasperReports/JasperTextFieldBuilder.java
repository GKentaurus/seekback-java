package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.VerticalTextAlignEnum;

public class JasperTextFieldBuilder {
  private final JRDesignTextField text;
  private static int nextColumnStart = 0;

  private int getNextColumnStart() {
    return nextColumnStart;
  }

  private void setNextColumnStart(int next, int spacing) {
    nextColumnStart += (next + spacing);
    System.out.println("La siguiente colDetail empieza en " + nextColumnStart);
  }

  private JasperTextFieldBuilder() {
    this.text = new JRDesignTextField();
  }

  public static JasperTextFieldBuilder start() {
    return new JasperTextFieldBuilder();
  }

  public JasperTextFieldBuilder defaultSettings(Integer columnWidth, Integer spacing, String expression) {
    this.text.setBlankWhenNull(true);
    this.text.setX(getNextColumnStart());
    this.text.setY(0);
    this.text.setWidth(columnWidth);
    this.text.setHeight(15);
    this.text.setHorizontalTextAlign(HorizontalTextAlignEnum.LEFT);
    this.text.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
    this.text.setFontSize(12f);
    this.text.setExpression(new JRDesignExpression("$F{" + expression + "}"));
    setNextColumnStart(columnWidth, spacing);

    return this;
  }

  public JasperTextFieldBuilder defaultSettings(Integer columnWidth, String expression, Integer startAt) {
    setNextColumnStart(startAt, 0);
    return defaultSettings(columnWidth, 5, expression);
  }

  public JasperTextFieldBuilder defaultSettings(Integer columnWidth, String expression) {
    return defaultSettings(columnWidth, 5, expression);
  }

  public JasperTextFieldBuilder setExpression(String expression) {
    this.text.setExpression(new JRDesignExpression("$F{" + expression + "}"));
    return this;
  }

  public JasperTextFieldBuilder setBlankWhenNull(boolean blankWhenNull) {
    this.text.setBlankWhenNull(blankWhenNull);
    return this;
  }

  public JasperTextFieldBuilder setPosition(Integer x, Integer y) {
    this.text.setX(x);
    this.text.setY(y);
    return this;
  }

  public JasperTextFieldBuilder setTextDimensions(Integer width, Integer height) {
    this.text.setWidth(width);
    this.text.setHeight(height);
    return this;
  }

  public JasperTextFieldBuilder setTextAlign(HorizontalTextAlignEnum hAlign, VerticalTextAlignEnum vAlign) {
    this.text.setHorizontalTextAlign(hAlign);
    this.text.setVerticalTextAlign(vAlign);
    return this;
  }

  public JasperTextFieldBuilder setStyle(JRDesignStyle style) {
    this.text.setStyle(style);
    return this;
  }

  public JRDesignTextField getText() {
    return this.text;
  }
}
