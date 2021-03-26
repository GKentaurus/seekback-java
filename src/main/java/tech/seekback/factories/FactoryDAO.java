
package tech.seekback.factories;

import tech.seekback.dao.interfaces.*;

/**
 * @author gkentaurus
 */
public interface FactoryDAO {

  AdministradorDAO getAdministradorDAO();

  AgendaDAO getAgendaDAO();

  BodegaDAO getBodegaDAO();

  BodegaProductoDAO getBodegaProductosDAO();

  CalificacionDAO getCalificacionDAO();

  CategoriasProductoDAO getCategoriasProductoDAO();

  CiudadDAO getCiudadDAO();

  ClienteDAO getClienteDAO();

  CorreoDAO getCorreosDAO();

  CotizacionDAO getCotizacionDAO();

  DepartamentoDAO getDepartamentoDAO();

  DireccionDAO getDireccionesDAO();

  DivisaDAO getDivisasDAO();

  DocumentoDetalladoDAO getDocumentoDetalladoDAO();

  EmpleadoDAO getEmpleadoDAO();

  EstadosAgendaDAO getEstadosAgendaDAO();

  EstadosCotizacionDAO getEstadosCotizacionDAO();

  EstadosFidelizacionDAO getEstadosFidelizacionDAO();

  FelicitacionDAO getFelicitacionDAO();

  OrdenCompraDAO getOrdenCompraDAO();

  PQRSDAO getPQRSDAO();

  PaisDAO getPaisDAO();

  ProductoDAO getProductoDAO();

  ProformaVentaDAO getProformaVentaDAO();

  ProveedorDAO getProveedorDAO();

  RolDAO getRolesDAO();

  SoporteTecnicoDAO getSoporteTecnicoDAO();

  TRMDAO getTRMDAO();

  TelefonoDAO getTelefonosDAO();

  TipoDocDAO getTipoDocDAO();

  TipoServicioDAO getTipoServicioDAO();

  TipoSolicitudDAO getTipoSolicitudDAO();

  UsuarioDAO getUsuarioDAO();
}
