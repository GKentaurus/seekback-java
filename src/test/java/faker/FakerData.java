package faker;

import tech.seekback.models.*;
import tech.seekback.models.templates.Timestamps;

import java.util.Date;
import java.util.Random;

public class FakerData {

  private static final int min = 1;
  private static final int max = 10;

  // Primitive data

  public static Integer integerFaker() {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }

  public static double doubleFaker() {
    return integerFaker().doubleValue();
  }

  public static long longFaker() {
    return integerFaker().longValue();
  }

  public static String stringFaker() {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    Random random = new Random();

    return random.ints(leftLimit, rightLimit + 1)
        .limit(integerFaker())
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }

  // Models

  public static Rol rolFaker() {
    Rol rol = new Rol();
    rol.setNombreRol(stringFaker());
    rol.setTimestamps(new Timestamps());
    return rol;
  }

  public static TipoDoc tipoDocFaker() {
    TipoDoc doc = new TipoDoc();
    doc.setNombreDocumento(stringFaker());
    doc.setSigla(stringFaker());
    doc.setTimestamps(new Timestamps());
    return doc;
  }

  public static Usuario usuarioFaker() {
    Usuario usuario = new Usuario();
    usuario.setPrimerNombre(stringFaker());
    usuario.setOtrosNombres(stringFaker());
    usuario.setPrimerApellido(stringFaker());
    usuario.setOtrosApellidos(stringFaker());
    usuario.setTipoDoc(tipoDocFaker());
    usuario.setNumeroDoc(stringFaker());
    usuario.setContrasena(stringFaker());
    usuario.setRol(rolFaker());
    usuario.setTimestamps(new Timestamps());
    return usuario;
  }

  public static Pais paisFaker() {
    Pais pais = new Pais();
    pais.setNombrePais(stringFaker());
    pais.setTimestamps(new Timestamps());
    return pais;
  }

  public static Departamento departamentoFaker() {
    Departamento departamento = new Departamento();
    departamento.setPais(paisFaker());
    departamento.setNombreDepartamento(stringFaker());
    departamento.setTimestamps(new Timestamps());
    return departamento;
  }

  public static Ciudad ciudadFaker() {
    Ciudad ciudad = new Ciudad();
    ciudad.setDepartamento(departamentoFaker());
    ciudad.setNombreCiudad(stringFaker());
    ciudad.setTimestamps(new Timestamps());
    return ciudad;
  }

  public static Direccion direccionFaker() {
    Direccion direccion = new Direccion();
    direccion.setPseudonimo(stringFaker());
    direccion.setTelefono(stringFaker());
    direccion.setDireccion(stringFaker());
    direccion.setCiudad(ciudadFaker());
    direccion.setEsPrincipal(true);
    direccion.setUsuario(usuarioFaker());
    direccion.setTimestamps(new Timestamps());
    return direccion;
  }

  public static Correo correoFaker() {
    Correo correo = new Correo();
    correo.setCorreoElectronico(stringFaker());
    correo.setEsPrincipal(true);
    correo.setUsuario(usuarioFaker());
    correo.setTimestamps(new Timestamps());
    return correo;
  }

  public static Telefono telefonoFaker() {
    Telefono telefono = new Telefono();
    telefono.setNumeroTelefono(stringFaker());
    telefono.setUsuario(usuarioFaker());
    telefono.setEsPrincipal(true);
    telefono.setTimestamps(new Timestamps());
    return telefono;
  }

  public static Proveedor proveedorFaker() {
    Proveedor proveedor = new Proveedor();
    proveedor.setCliente(usuarioFaker());
    proveedor.setRazonSocial(stringFaker());
    proveedor.setEmail(stringFaker());
    proveedor.setTipoDoc(tipoDocFaker());
    proveedor.setNumeroDoc(stringFaker());
    proveedor.setDigitoVerif(stringFaker());
    proveedor.setTimestamps(new Timestamps());
    proveedor.setTelefono(stringFaker());
    return proveedor;
  }

  public static Divisa divisaFaker() {
    Divisa divisa = new Divisa();
    divisa.setNombre(stringFaker());
    divisa.setSigla(stringFaker());
    divisa.setTimestamps(new Timestamps());
    return divisa;
  }

  public static TRM trmFaker() {
    TRM trm = new TRM();
    trm.setDivisa(divisaFaker());
    trm.setFecha(new Date());
    trm.setTasaCambio(doubleFaker());
    trm.setTimestamps(new Timestamps());
    return trm;
  }

  public static OrdenCompra ordenCompraFaker() {
    OrdenCompra ordenCompra = new OrdenCompra();
    ordenCompra.setFecha(new Date());
    ordenCompra.setDocAsociado(stringFaker());
    ordenCompra.setEmpleado(usuarioFaker());
    ordenCompra.setFactorImport(doubleFaker());
    ordenCompra.setProveedor(proveedorFaker());
    ordenCompra.setTrm(trmFaker());
    ordenCompra.setTimestamps(new Timestamps());
    return ordenCompra;
  }

  public static EstadosCotizacion estadosCotizacionFaker() {
    EstadosCotizacion estadosCotizacion = new EstadosCotizacion();
    estadosCotizacion.setNombreEstado(stringFaker());
    estadosCotizacion.setTimestamps(new Timestamps());
    return estadosCotizacion;
  }

  public static EstadosFidelizacion estadosFidelizacionFaker() {
    EstadosFidelizacion estadosFidelizacion = new EstadosFidelizacion();
    estadosFidelizacion.setNombreEstado(stringFaker());
    estadosFidelizacion.setTimestamps(new Timestamps());
    return estadosFidelizacion;
  }

  public static EstadosAgenda estadosAgendaFaker() {
    EstadosAgenda estadosAgenda = new EstadosAgenda();
    estadosAgenda.setNombreEstado(stringFaker());
    estadosAgenda.setTimestamps(new Timestamps());
    return estadosAgenda;
  }

  public static TipoSolicitud tipoSolicitudFaker() {
    TipoSolicitud tipoSolicitud = new TipoSolicitud();
    tipoSolicitud.setNombreSolicitud(stringFaker());
    tipoSolicitud.setTimestamps(new Timestamps());
    return tipoSolicitud;
  }

  public static TipoServicio tipoServicioFaker() {
    TipoServicio tipoServicio = new TipoServicio();
    tipoServicio.setNombreServicio(stringFaker());
    tipoServicio.setTimestamps(new Timestamps());
    return tipoServicio;
  }

  public static Cotizacion cotizacionFaker() {
    Cotizacion cotizacion = new Cotizacion();
    cotizacion.setRequerimiento(stringFaker());
    cotizacion.setEstado(estadosCotizacionFaker());
    cotizacion.setEmpleado(usuarioFaker());
    cotizacion.setCliente(usuarioFaker());
    cotizacion.setTrm(trmFaker());
    cotizacion.setFecha(new Date());
    cotizacion.setVencimiento(new Date());
    cotizacion.setTimestamps(new Timestamps());
    return cotizacion;
  }

  public static ProformaVenta proformaVentaFaker() {
    ProformaVenta proformaVenta = new ProformaVenta();
    proformaVenta.setCotizacion(cotizacionFaker());
    proformaVenta.setFecha(new Date());
    proformaVenta.setVencimiento(new Date());
    proformaVenta.setTimestamps(new Timestamps());
    return proformaVenta;
  }

  public static CategoriasProducto categoriasProductoFaker() {
    CategoriasProducto categoriasProducto = new CategoriasProducto();
    categoriasProducto.setNombreCategoria(stringFaker());
    categoriasProducto.setFaIcon(stringFaker());
    categoriasProducto.setTimestamps(new Timestamps());
    return categoriasProducto;
  }

  public static Producto productoFaker() {
    Producto producto = new Producto();
    producto.setModeloProducto(stringFaker());
    producto.setDescripcion(stringFaker());
    producto.setCategoria(categoriasProductoFaker());
    producto.setEstado(true);
    producto.setPrecioVenta(doubleFaker());
    producto.setTimestamps(new Timestamps());
    return producto;
  }

  public static DocumentoDetallado documentoDetalladoFaker() {
    DocumentoDetallado documentoDetallado = new DocumentoDetallado();
    documentoDetallado.setPrefijoDocumento(stringFaker());
    documentoDetallado.setConsecutivo(integerFaker());
    documentoDetallado.setProducto(productoFaker());
    documentoDetallado.setCantidad(integerFaker());
    documentoDetallado.setValorUnitario(doubleFaker());
    documentoDetallado.setTimestamps(new Timestamps());
    return documentoDetallado;
  }

  public static Bodega bodegaFaker() {
    Bodega bodega = new Bodega();
    bodega.setNombreBodega(stringFaker());
    bodega.setTimestamps(new Timestamps());
    return bodega;
  }

  public static BodegaProducto bodegaProductoFaker() {
    BodegaProducto bodegaProducto = new BodegaProducto();
    bodegaProducto.setBodega(bodegaFaker());
    bodegaProducto.setCantidad(integerFaker());
    bodegaProducto.setProducto(productoFaker());
    bodegaProducto.setTimestamps(new Timestamps());
    return bodegaProducto;
  }

  public static SoporteTecnico soporteTecnicoFaker() {
    SoporteTecnico soporteTecnico = new SoporteTecnico();
    soporteTecnico.setCliente(usuarioFaker());
    soporteTecnico.setEmpleado(usuarioFaker());
    soporteTecnico.setEstado(estadosFidelizacionFaker());
    soporteTecnico.setProducto(productoFaker());
    soporteTecnico.setComentario(stringFaker());
    soporteTecnico.setFechaRespuesta(new Date());
    soporteTecnico.setTimestamps(new Timestamps());
    return soporteTecnico;
  }

  public static PQRS pqrsFaker() {
    PQRS pqrs = new PQRS();
    pqrs.setTipoSolicitud(tipoSolicitudFaker());
    pqrs.setEstado(estadosFidelizacionFaker());
    pqrs.setArea(stringFaker());
    pqrs.setCliente(usuarioFaker());
    pqrs.setAdministrador(usuarioFaker());
    pqrs.setComentario(stringFaker());
    pqrs.setRespuesta(stringFaker());
    pqrs.setFechaRespuesta(new Date());
    pqrs.setTimestamps(new Timestamps());
    return pqrs;
  }

  public static Felicitacion felicitacionFaker() {
    Felicitacion felicitacion = new Felicitacion();
    felicitacion.setCliente(usuarioFaker());
    felicitacion.setDirigidoA(stringFaker());
    felicitacion.setComentario(stringFaker());
    felicitacion.setTimestamps(new Timestamps());
    return felicitacion;
  }

  public static Calificacion calificacionFaker() {
    Calificacion calificacion = new Calificacion();
    calificacion.setCliente(usuarioFaker());
    calificacion.setProducto(productoFaker());
    calificacion.setCalificacion(integerFaker());
    calificacion.setComentario(stringFaker());
    calificacion.setEsAprobado(true);
    calificacion.setTimestamps(new Timestamps());
    return calificacion;
  }
  public static Agenda agendaFaker() {
    Agenda agenda = new Agenda();
    agenda.setAdministrador(usuarioFaker());
    agenda.setCliente(usuarioFaker());
    agenda.setEmpleado(usuarioFaker());
    agenda.setFecha(new Date());
    agenda.setTipoServicio(tipoServicioFaker());
    agenda.setObservaciones(stringFaker());
    agenda.setTimestamps(new Timestamps());
    return agenda;
  }

  public static Slide slideFaker() {
    Slide slide = new Slide();
    slide.setTitulo(stringFaker());
    slide.setDescripcion(stringFaker());
    slide.setUrlImagen(stringFaker());
    slide.setTimestamps(new Timestamps());
    return slide;
  }
}
