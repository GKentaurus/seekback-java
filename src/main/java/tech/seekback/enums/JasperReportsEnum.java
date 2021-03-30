package tech.seekback.enums;

public enum JasperReportsEnum {
  // Diseño del reporte
  VERTICAL(1),
  HORIZONTAL(2),

  // Tipo de título o banda
  TITLE(1),
  SUBTITLE(2),

  // Tamaño de los campos
  TITLE_HEIGHT(50),
  SUBTITLE_HEIGHT(30),

  // Tamaño del diseño
  HORIZONTAL_PAGE_WIDTH(590),
  HORIZONTAL_PAGE_HEIGHT(840),

  VERTICAL_PAGE_WIDTH(840),
  VERTICAL_PAGE_HEIGHT(590),
  ;


  private final Integer code;

  JasperReportsEnum(Integer code) {
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }
}
