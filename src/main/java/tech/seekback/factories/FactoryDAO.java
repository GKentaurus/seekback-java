/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.factories;

import tech.seekback.dao.*;

/**
 *
 * @author camorenoc
 */
public interface FactoryDAO {

  AdministradorDAO getAdministradorDAO();

  AgendaDAO getAgendaDAO();

  BodegaDAO getBodegaDAO();

  BodegaProductosDAO getBodegaProductosDAO();

  CalificacionDAO getCalificacionDAO();

  CategoriasProductoDAO getCategoriasProductoDAO();

  CiudadDAO getCiudadDAO();

  ClienteDAO getClienteDAO();

  CorreosDAO getCorreosDAO();

  CotizacionDAO getCotizacionDAO();

  DepartamentoDAO getDepartamentoDAO();

  DireccionesDAO getDireccionesDAO();

  DivisasDAO getDivisasDAO();

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

  RolesDAO getRolesDAO();

  SoporteTecnicoDAO getSoporteTecnicoDAO();

  TRMDAO getTRMDAO();

  TelefonosDAO getTelefonosDAO();

  TipoDocDAO getTipoDocDAO();

  TipoServicioDAO getTipoServicioDAO();

  TipoSolicitudDAO getTipoSolicitudDAO();

  UsuarioDAO getUsuarioDAO();
}
