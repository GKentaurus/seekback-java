package tech.seekback.enums.JasperReports;

public enum OrientationEnum {
  // Diseño del reporte
  VERTICAL_ORIENTATION(1),
  HORIZONTAL_ORIENTATION(2),
  ;


  private final Integer code;

  OrientationEnum(Integer code) {
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }
}
