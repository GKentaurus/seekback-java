/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.factories;

import tech.seekback.dao.*;
import tech.seekback.dao.mysql.*;

/**
 *
 * @author gkent
 */
public class FactoryDAOMySQL implements FactoryDAO {

  @Override
  public AdministradorDAO getAdministradorDAO() {
    return new AdministradorDAOMySQL();
  }

  @Override
  public AgendaDAO getAgendaDAO() {
    return new AgendaDAOMySQL();
  }

  @Override
  public BodegaDAO getBodegaDAO() {
    return new BodegaDAOMySQL();
  }

  @Override
  public BodegaProductosDAO getBodegaProductosDAO() {
    return new BodegaProductosDAOMySQL();
  }

  @Override
  public CalificacionDAO getCalificacionDAO() {
    return new CalificacionDAOMySQL();
  }

  @Override
  public CategoriasProductoDAO getCategoriasProductoDAO() {
    return new CategoriasProductoDAOMySQL();
  }

  @Override
  public CiudadDAO getCiudadDAO() {
    return new CiudadDAOMySQL();
  }

  @Override
  public ClienteDAO getClienteDAO() {
    return new ClienteDAOMySQL();
  }

  @Override
  public CorreosDAO getCorreosDAO() {
    return new CorreosDAOMySQL();
  }

  @Override
  public CotizacionDAO getCotizacionDAO() {
    return new CotizacionDAOMySQL();
  }

  @Override
  public DepartamentoDAO getDepartamentoDAO() {
    return new DepartamentoDAOMySQL();
  }

  @Override
  public DireccionesDAO getDireccionesDAO() {
    return new DireccionesDAOMySQL();
  }

  @Override
  public DivisasDAO getDivisasDAO() {
    return new DivisasDAOMySQL();
  }

  @Override
  public DocumentoDetalladoDAO getDocumentoDetalladoDAO() {
    return new DocumentoDetalladoDAOMySQL();
  }

  @Override
  public EmpleadoDAO getEmpleadoDAO() {
    return new EmpleadoDAOMySQL();
  }

  @Override
  public EstadosAgendaDAO getEstadosAgendaDAO() {
    return new EstadosAgendaDAOMySQL();
  }

  @Override
  public EstadosCotizacionDAO getEstadosCotizacionDAO() {
    return new EstadosCotizacionDAOMySQL();
  }

  @Override
  public EstadosFidelizacionDAO getEstadosFidelizacionDAO() {
    return new EstadosFidelizacionDAOMySQL();
  }

  @Override
  public FelicitacionDAO getFelicitacionDAO() {
    return new FelicitacionDAOMySQL();
  }

  @Override
  public FidelizacionDAO getFidelizacionDAO() {
    return new FidelizacionDAOMySQL();
  }

  @Override
  public OrdenCompraDAO getOrdenCompraDAO() {
    return new OrdenCompraDAOMySQL();
  }

  @Override
  public PQRSDAO getPQRSDAO() {
    return new PQRSDAOMySQL();
  }

  @Override
  public PaisDAO getPaisDAO() {
    return new PaisDAOMySQL();
  }

  @Override
  public ProductoDAO getProductoDAO() {
    return new ProductoDAOMySQL();
  }

  @Override
  public ProformaVentaDAO getProformaVentaDAO() {
    return new ProformaVentaDAOMySQL();
  }

  @Override
  public ProveedorDAO getProveedorDAO() {
    return new ProveedorDAOMySQL();
  }

  @Override
  public RolesDAO getRolesDAO() {
    return new RolesDAOMySQL();
  }

  @Override
  public SoporteTecnicoDAO getSoporteTecnicoDAO() {
    return new SoporteTecnicoDAOMySQL();
  }

  @Override
  public TRMDAO getTRMDAO() {
    return new TRMDAOMySQL();
  }

  @Override
  public TelefonosDAO getTelefonosDAO() {
    return new TelefonosDAOMySQL();
  }

  @Override
  public TipoDocDAO getTipoDocDAO() {
    return new TipoDocDAOMySQL();
  }

  @Override
  public TipoServicioDAO getTipoServicioDAO() {
    return new TipoServicioDAOMySQL();
  }

  @Override
  public TipoSolicitudDAO getTipoSolicitudDAO() {
    return new TipoSolicitudDAOMySQL();
  }

  @Override
  public UsuarioDAO getUsuarioDAO() {
    return new UsuarioDAOMySQL();
  }

}
