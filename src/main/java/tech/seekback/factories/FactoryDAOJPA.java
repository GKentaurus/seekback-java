/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.factories;

import tech.seekback.dao.interfaces.*;
import tech.seekback.dao.jpa.*;

/**
 *
 * @author gkent
 */
public class FactoryDAOJPA implements FactoryDAO {

  @Override
  public AdministradorDAO getAdministradorDAO() {
    return new AdministradorDAOJPA();
  }

  @Override
  public AgendaDAO getAgendaDAO() {
    return new AgendaDAOJPA();
  }

  @Override
  public BodegaDAO getBodegaDAO() {
    return new BodegaDAOJPA();
  }

  @Override
  public BodegaProductoDAO getBodegaProductosDAO() {
    return new BodegaProductoDAOJPA();
  }

  @Override
  public CalificacionDAO getCalificacionDAO() {
    return new CalificacionDAOJPA();
  }

  @Override
  public CategoriasProductoDAO getCategoriasProductoDAO() {
    return new CategoriasProductoDAOJPA();
  }

  @Override
  public CiudadDAO getCiudadDAO() {
    return new CiudadDAOJPA();
  }

  @Override
  public ClienteDAO getClienteDAO() {
    return new ClienteDAOJPA();
  }

  @Override
  public CorreoDAO getCorreosDAO() {
    return new CorreoDAOJPA();
  }

  @Override
  public CotizacionDAO getCotizacionDAO() {
    return new CotizacionDAOJPA();
  }

  @Override
  public DepartamentoDAO getDepartamentoDAO() {
    return new DepartamentoDAOJPA();
  }

  @Override
  public DireccionDAO getDireccionesDAO() {
    return new DireccionDAOJPA();
  }

  @Override
  public DivisaDAO getDivisasDAO() {
    return new DivisaDAOJPA();
  }

  @Override
  public DocumentoDetalladoDAO getDocumentoDetalladoDAO() {
    return new DocumentoDetalladoDAOJPA();
  }

  @Override
  public EmpleadoDAO getEmpleadoDAO() {
    return new EmpleadoDAOJPA();
  }

  @Override
  public EstadosAgendaDAO getEstadosAgendaDAO() {
    return new EstadosAgendaDAOJPA();
  }

  @Override
  public EstadosCotizacionDAO getEstadosCotizacionDAO() {
    return new EstadosCotizacionDAOJPA();
  }

  @Override
  public EstadosFidelizacionDAO getEstadosFidelizacionDAO() {
    return new EstadosFidelizacionDAOJPA();
  }

  @Override
  public FelicitacionDAO getFelicitacionDAO() {
    return new FelicitacionDAOJPA();
  }

  @Override
  public OrdenCompraDAO getOrdenCompraDAO() {
    return new OrdenCompraDAOJPA();
  }

  @Override
  public PQRSDAO getPQRSDAO() {
    return new PQRSDAOJPA();
  }

  @Override
  public PaisDAO getPaisDAO() {
    return new PaisDAOJPA();
  }

  @Override
  public ProductoDAO getProductoDAO() {
    return new ProductoDAOJPA();
  }

  @Override
  public ProformaVentaDAO getProformaVentaDAO() {
    return new ProformaVentaDAOJPA();
  }

  @Override
  public ProveedorDAO getProveedorDAO() {
    return new ProveedorDAOJPA();
  }

  @Override
  public RolDAO getRolesDAO() {
    return new RolDAOJPA();
  }

  @Override
  public SoporteTecnicoDAO getSoporteTecnicoDAO() {
    return new SoporteTecnicoDAOJPA();
  }

  @Override
  public TRMDAO getTRMDAO() {
    return new TRMDAOJPA();
  }

  @Override
  public TelefonoDAO getTelefonosDAO() {
    return new TelefonoDAOJPA();
  }

  @Override
  public TipoDocDAO getTipoDocDAO() {
    return new TipoDocDAOJPA();
  }

  @Override
  public TipoServicioDAO getTipoServicioDAO() {
    return new TipoServicioDAOJPA();
  }

  @Override
  public TipoSolicitudDAO getTipoSolicitudDAO() {
    return new TipoSolicitudDAOJPA();
  }

  @Override
  public UsuarioDAO getUsuarioDAO() {
    return new UsuarioDAOJPA();
  }

}
