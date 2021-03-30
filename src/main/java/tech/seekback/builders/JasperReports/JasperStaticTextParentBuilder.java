package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.VerticalTextAlignEnum;

public class JasperStaticTextParentBuilder {
  protected final JRDesignStaticText text;
  protected JasperStaticTextParentBuilder() {
    this.text = new JRDesignStaticText();
  }

  public static JasperStaticTextParentBuilder start() {
    return new JasperStaticTextParentBuilder();
  }

  public JasperStaticTextParentBuilder setFontSize(Float fontSize) {
    this.text.setFontSize(fontSize);
    return this;
  }

  public JasperStaticTextParentBuilder setStyle(JRDesignStyle style) {
    this.text.setStyle(style);
    return this;
  }

  public JasperStaticTextParentBuilder setText(String text) {
    this.text.setText(text);
    return this;
  }


  public JasperStaticTextParentBuilder setPosition(Integer x, Integer y) {
    this.text.setX(x);
    this.text.setY(y);
    return this;
  }

  public JasperStaticTextParentBuilder setTextDimensions(Integer width, Integer height) {
    this.text.setWidth(width);
    this.text.setHeight(height);
    return this;
  }

  public JasperStaticTextParentBuilder setTextAlign(HorizontalTextAlignEnum hAlign, VerticalTextAlignEnum vAlign) {
    this.text.setHorizontalTextAlign(hAlign);
    this.text.setVerticalTextAlign(vAlign);
    return this;
  }

  public JRDesignStaticText getText() {
    return this.text;
  }
}
