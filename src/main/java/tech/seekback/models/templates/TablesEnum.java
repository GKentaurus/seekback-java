
package tech.seekback.models.templates;

/**
 * @author gkentaurus
 */
public enum TablesEnum {
  ADMINISTRADOR("administrador"),
  AGENDA("agenda"),
  BODEGA("bodega"),
  BODEGA_PRODUCTOS("bodega_productos"),
  CALIFICACION("calificacion"),
  CATEGORIAS_PRODUCTO("categorias_producto"),
  CIUDAD("ciudad"),
  CLIENTE("cliente"),
  CORREOS("correos"),
  COTIZACION("cotizacion"),
  DEPARTAMENTO("departamento"),
  DIRECCIONES("direcciones"),
  DIVISAS("divisas"),
  DOCUMENTO_DETALLADO("documento_detallado"),
  EMPLEADO("empleado"),
  ESTADOS_AGENDA("estados_agenda"),
  ESTADOS_COTIZACION("estados_cotizacion"),
  ESTADOS_FIDELIZACION("estados_fidelizacion"),
  FELICITACION("felicitacion"),
  ORDEN_COMPRA("orden_compra"),
  PQRS("pqrs"),
  PAIS("pais"),
  PRODUCTO("producto"),
  PROFORMA_VENTA("proforma_venta"),
  PROVEEDOR("proveedor"),
  ROLES("roles"),
  SOPORTE_TECNICO("soporte_tecnico"),
  TRM("trm"),
  TELEFONOS("telefonos"),
  TIPO_DOC("tipo_doc"),
  TIPO_SERVICIO("tipo_servicio"),
  TIPO_SOLICITUD("tipo_solicitud"),
  USUARIO("usuario");

  private final String nombreTabla;

  TablesEnum(String nombreTabla) {
    this.nombreTabla = nombreTabla;
  }

  public String getNombreTabla() {
    return nombreTabla;
  }
}
