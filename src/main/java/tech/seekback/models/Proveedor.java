
package tech.seekback.models;

import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

import javax.persistence.*;
import java.util.Objects;

/**
 * Definición del modelo "Proveedor"
 *
 * @author gkentaurus
 */
@Entity
@Table(name = "proveedor")
@NamedQueries(value = {
  @NamedQuery(name = "Proveedor.getAll", query = "SELECT obj FROM Proveedor obj WHERE obj.timestamps.deleted = false")
})
public class Proveedor implements EntityTimestamp {

  @Id
  @Column(name = "idProveedor")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "tipoDoc", nullable = false)
  private TipoDoc tipoDoc;

  @Column(name = "numeroDoc", nullable = false, length = 50)
  private String numeroDoc;

  @Column(name = "digitoVerif", nullable = false, length = 1)
  private String digitoVerif;

  @Column(name = "razonSocial", nullable = false, length = 100)
  private String razonSocial;

  @Column(name = "telefono", nullable = false, length = 20)
  private String telefono;

  @Column(name = "email", nullable = false, length = 255)
  private String email;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "idCliente", nullable = false)
  private Usuario cliente;

  @Embedded
  private Timestamps timestamps;

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  /**
   * Retorna el valor del atributo <code>id</code> del objeto.
   *
   * @return <code>id</code> del proveedor.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo <code>id</code> del objeto.
   *
   * @param id del proveedor.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Retorna el valor del atributo <code>tipoDoc</code> del objeto.
   *
   * @return <code>tipoDoc</code> del proveedor.
   * @see TipoDoc
   */
  public TipoDoc getTipoDoc() {
    return tipoDoc;
  }

  /**
   * Asigna el valor del atributo <code>tipoDoc</code> del objeto.
   *
   * @param tipoDoc del proveedor.
   * @see TipoDoc
   */
  public void setTipoDoc(TipoDoc tipoDoc) {
    this.tipoDoc = tipoDoc;
  }

  /**
   * Retorna el valor del atributo <code>numeroDoc</code> del objeto.
   *
   * @return <code>numeroDoc</code> del proveedor.
   */
  public String getNumeroDoc() {
    return numeroDoc;
  }

  /**
   * Asigna el valor del atributo <code>numeroDoc</code> del objeto.
   *
   * @param numeroDoc del proveedor.
   */
  public void setNumeroDoc(String numeroDoc) {
    this.numeroDoc = numeroDoc;
  }

  /**
   * Retorna el valor del atributo <code>digitoVerif</code> del objeto.
   *
   * @return <code>digitoVerif</code> del proveedor.
   */
  public String getDigitoVerif() {
    return digitoVerif;
  }

  /**
   * Asigna el valor del atributo <code>digitoVerif</code> del objeto.
   *
   * @param digitoVerif del proveedor.
   */
  public void setDigitoVerif(String digitoVerif) {
    this.digitoVerif = digitoVerif;
  }

  /**
   * Retorna el valor del atributo <code>razonSocial</code> del objeto.
   *
   * @return <code>razonSocial</code> del proveedor.
   */
  public String getRazonSocial() {
    return razonSocial;
  }

  /**
   * Asigna el valor del atributo <code>razonSocial</code> del objeto.
   *
   * @param razonSocial del proveedor.
   */
  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  /**
   * Retorna el valor del atributo <code>telefono</code> del objeto.
   *
   * @return <code>telefono</code> del proveedor.
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * Asigna el valor del atributo <code>telefono</code> del objeto.
   *
   * @param telefono del proveedor.
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * Retorna el valor del atributo <code>email</code> del objeto.
   *
   * @return <code>email</code> del proveedor.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Asigna el valor del atributo <code>email</code> del objeto.
   *
   * @param email del proveedor.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Retorna el valor del atributo <code>cliente</code> del objeto.
   *
   * @return <code>cliente</code> del proveedor.
   * @see Usuario
   */
  public Usuario getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo <code>cliente</code> del objeto.
   *
   * @param cliente del proveedor.
   * @see Usuario
   */
  public void setCliente(Usuario cliente) {
    this.cliente = cliente;
  }

  /**
   * Retorna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @return <code>timestamps</code> del proveedor.
   * @see Timestamps
   */
  public Timestamps getTimestamps() {
    return timestamps;
  }

  /**
   * Asigna el valor del atributo <code>timestamps</code> del objeto.
   *
   * @param timestamps del proveedor.
   * @see Timestamps
   */
  public void setTimestamps(Timestamps timestamps) {
    this.timestamps = timestamps;
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Hash && Equals">
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 23 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Proveedor other = (Proveedor) obj;
    return Objects.equals(this.id, other.id);
  }
  //</editor-fold>

  @Override
  public String toString() {
    return "Proveedor{"
      + "id = " + id + ", "
      + "tipoDoc = " + tipoDoc + ", "
      + "numeroDoc = " + numeroDoc + ", "
      + "digitoVerif = " + digitoVerif + ", "
      + "razonSocial = " + razonSocial + ", "
      + "telefono = " + telefono + ", "
      + "email = " + email + ", "
      + "cliente = " + cliente + ", "
      + timestamps.toString()
      + '}';
  }
}
