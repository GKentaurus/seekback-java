package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.VerticalTextAlignEnum;
import tech.seekback.enums.JasperReportsEnum;

public class JasperStaticTextCommonBuilder {
  private final JRDesignStaticText text;
  private static int nextColumnStart = 0;

  private int getNextColumnStart() {
    return nextColumnStart;
  }

  private void setNextColumnStart(int next, int spacing) {
    nextColumnStart += (next + spacing);
    System.out.println("La siguiente colHeader empieza en " + nextColumnStart);
  }

  private JasperStaticTextCommonBuilder() {
    this.text = new JRDesignStaticText();
  }

  public static JasperStaticTextCommonBuilder start() {
    return new JasperStaticTextCommonBuilder();
  }

  public JasperStaticTextCommonBuilder defaultSettings(Integer columnWidth, Integer spacing, String text, JasperReportsEnum option, Integer startAt) {
    setNextColumnStart(startAt, spacing);
    return this.defaultSettings(columnWidth, spacing, text, option);
  }

  public JasperStaticTextCommonBuilder defaultSettings(Integer columnWidth, Integer spacing, String text, JasperReportsEnum option) {
    this.text.setText(text);
    this.text.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
    this.text.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
    this.text.setWidth(columnWidth);
    this.text.setX(getNextColumnStart());

    switch (option.getCode()) {
      case 1:
        this.text.setY(0);
        this.text.setHeight(JasperReportsEnum.TITLE_HEIGHT.getCode() - 10);
        this.text.setFontSize(22f);
        break;
      case 2:
        this.text.setY(5);
        this.text.setHeight(JasperReportsEnum.SUBTITLE_HEIGHT.getCode() - 5);
        this.text.setFontSize(18f);
        break;
    }

    setNextColumnStart(columnWidth, spacing);
    return this;
  }

  public JRDesignStaticText getText() {
    return this.text;
  }
}
