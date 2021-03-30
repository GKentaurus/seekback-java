package tech.seekback.enums.JasperReports;

public enum DocumentSizeEnum {
  HORIZONTAL_PAGE_WIDTH(590),
  HORIZONTAL_PAGE_HEIGHT(840),
  VERTICAL_PAGE_WIDTH(840),
  VERTICAL_PAGE_HEIGHT(590),

  HORIZONTAL_INNER_WIDTH(550),
  HORIZONTAL_INNER_HEIGHT(800),
  VERTICAL_INNER_WIDTH(800),
  VERTICAL_INNER_HEIGHT(550),
  ;


  private final Integer code;

  DocumentSizeEnum(Integer code) {
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }
}
