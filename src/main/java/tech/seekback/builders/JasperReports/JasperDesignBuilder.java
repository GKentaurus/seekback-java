package tech.seekback.builders.JasperReports;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.*;
import tech.seekback.enums.JasperReports.DocumentSizeEnum;
import tech.seekback.enums.JasperReports.OrientationEnum;

public class JasperDesignBuilder{

  private final JasperDesign design;

  private JasperDesignBuilder() {
    this.design = new JasperDesign();
  }

  public static JasperDesignBuilder start() {
    return new JasperDesignBuilder();
  }

  public JasperDesignBuilder defaultSettings(String name, OrientationEnum orientation) {
    int pageWidth, pageHeight;

    switch (orientation.getCode()) {
      case 1:
      default:
        pageWidth = DocumentSizeEnum.VERTICAL_PAGE_WIDTH.getCode();
        pageHeight = DocumentSizeEnum.VERTICAL_PAGE_HEIGHT.getCode();
        break;
      case 2:
        pageWidth = DocumentSizeEnum.HORIZONTAL_PAGE_WIDTH.getCode();
        pageHeight = DocumentSizeEnum.HORIZONTAL_PAGE_HEIGHT.getCode();
        break;
    }

    int verticalMargin = 20;
    int horizontalMargin = 20;
    int columnWidth = pageWidth - (verticalMargin * 2);

    this.design.setName(name);
    this.design.setPageWidth(pageWidth);
    this.design.setPageHeight(pageHeight);
    this.design.setTopMargin(verticalMargin);
    this.design.setBottomMargin(verticalMargin);
    this.design.setLeftMargin(horizontalMargin);
    this.design.setRightMargin(horizontalMargin);
    this.design.setColumnWidth(columnWidth);
    return this;
  }

  public Integer getColumnWidth() {
    return this.design.getColumnWidth();
  }

  public JasperDesignBuilder setName(String name) {
    this.design.setName(name);
    return this;
  }

  public JasperDesignBuilder setPageWidth(Integer width) {
    this.design.setPageWidth(width);
    return this;
  }

  public JasperDesignBuilder setPageHeight(Integer height) {
    this.design.setPageHeight(height);
    return this;
  }

  public JasperDesignBuilder setPageDimensions(Integer width, Integer height) {
    this.design.setPageWidth(width);
    this.design.setPageHeight(height);
    return this;
  }

  public JasperDesignBuilder setTopMargin(Integer topMargin) {
    this.design.setTopMargin(topMargin);
    return this;
  }

  public JasperDesignBuilder setBottomMargin(Integer bottomMargin) {
    this.design.setBottomMargin(bottomMargin);
    return this;
  }

  public JasperDesignBuilder setLeftMargin(Integer leftMargin) {
    this.design.setLeftMargin(leftMargin);
    return this;
  }

  public JasperDesignBuilder setRightMargin(Integer rightMargin) {
    this.design.setRightMargin(rightMargin);
    return this;
  }

  public JasperDesignBuilder setMargins(Integer topMargin, Integer bottomMargin, Integer leftMargin, Integer rightMargin) {
    this.design.setTopMargin(topMargin);
    this.design.setBottomMargin(bottomMargin);
    this.design.setLeftMargin(leftMargin);
    this.design.setRightMargin(rightMargin);
    return this;
  }

  public JasperDesignBuilder setMargins(Integer verticalMargins, Integer horizontalMargins) {
    return this.setMargins(verticalMargins, verticalMargins, horizontalMargins, horizontalMargins);
  }

  public JasperDesignBuilder setMargins(Integer allMargins) {
    return this.setMargins(allMargins, allMargins);
  }

  public JasperDesignBuilder setColumnCount(Integer columnCount) {
    this.design.setColumnCount(columnCount);
    return this;
  }

  public JasperDesignBuilder setColumnSpacing(Integer columnSpacing) {
    this.design.setColumnSpacing(columnSpacing);
    return this;
  }

  public JasperDesignBuilder addField(JRDesignField field) throws JRException {
    this.design.addField(field);
    return this;
  }

  public JasperDesignBuilder setTitle(JRDesignBand title) {
    this.design.setTitle(title);
    return this;
  }

  public JasperDesignBuilder addDetailBand(JRDesignBand detailBand) {
    ((JRDesignSection) this.design.getDetailSection()).addBand(detailBand);
    return this;
  }

  public JasperDesignBuilder addColumnBand(JRDesignBand band) {
    this.design.setColumnHeader(band);
    return this;
  }

  public JasperDesignBuilder addStyle(JRDesignStyle style) throws JRException {
    this.design.addStyle(style);
    return this;
  }

  public JasperDesign getDesign() {

    return this.design;
  }
}
