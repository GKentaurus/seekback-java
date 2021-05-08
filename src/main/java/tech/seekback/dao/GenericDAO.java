
package tech.seekback.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.interfaces.EntityTimestamp;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public abstract class GenericDAO<T extends EntityTimestamp, PK> implements DAO<T, PK> {

  public static final String PU = "Seekback_PU";

  @PersistenceContext(unitName = PU)
  protected EntityManager em;
  protected Class<T> classType;

  public GenericDAO(Class<T> classType) {
    this.classType = classType;
  }

  /**
   * Por medio de la unidad de persistencia, almacena el objeto recibido por el argumento
   *
   * @param obj
   * @return un objeto de tipo T (referente al DAO que lo implemente)
   * @throws ConnectionExcep
   */
  @Override
  public T create(T obj) throws ConnectionExcep {
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Creando Objeto " + obj.getClass().getSimpleName()
        + "\n######################################################################\n"
    );

    T newObj = em.merge(obj);
    em.persist(newObj);
    return newObj;
  }

  /**
   * Por medio de la unidad de persistencia, almacena el objeto recibido por el argumento
   *
   * @param objs
   * @param obj
   * @throws ConnectionExcep
   */
  @Override
  public void create(List<T> objs) throws ConnectionExcep {
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Creando Objetos "
        + "\n######################################################################\n"
    );
    objs.forEach(obj -> em.persist(obj));
  }

  @Override
  public boolean checkIfExist(T obj, String column, String value) throws ConnectionExcep {
    String query = "SELECT COUNT(obj) FROM "
            + this.classType.getSimpleName() + " obj "
            + "WHERE obj.timestamps.deleted = false "
            + "AND obj." + column + " = :value";
    return ((Number) em.createQuery(query, classType)
            .setParameter("value", value)
            .getSingleResult())
            .intValue() > 0;
  }

  /**
   * @param id
   * @return un objeto de tipo T (referente al DAO que lo implemente)
   * @throws ConnectionExcep
   */
  @Override
  public T getOne(PK id) throws ConnectionExcep {
    // TODO: Borrar la caché de esta consulta en especifico y para el objeto especificado
    // em.getEntityManagerFactory().getCache().evict(classType);
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Consultando el objeto No. " + id
        + " de " + this.classType.getSimpleName()
        + "\n######################################################################\n"
    );
    return em.find(this.classType, id);
  }

  /**
   * @return una colección de objetos de tipo T (referente al DAO que lo implemente)
   * @throws ConnectionExcep
   */
  @Override
  public List<T> getAll() throws ConnectionExcep {
    // TODO: Borrar la caché de esta consulta en especifico
    // em.getEntityManagerFactory().getCache().evictAll();
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Consultando todos los objetos de " + this.classType.getSimpleName()
        + "\n######################################################################\n"
    );
    TypedQuery<T> tq = em.createNamedQuery(classType.getSimpleName() + ".getAll", classType);
    return tq.getResultList();
  }

  /**
   * Actualiza un objeto de tipo T
   *
   * @param obj
   * @throws ConnectionExcep
   */
  @Override
  public void update(T obj) throws ConnectionExcep {
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Actualizando el objeto " + this.classType.getSimpleName()
        + "\n######################################################################\n"
    );
    create(obj);
  }

  /**
   * Elimina un objeto de tipo Usuario
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(T obj) throws ConnectionExcep {
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Eliminando el objeto No. " + this.classType.getSimpleName()
        + "\n######################################################################\n"
    );
    Timestamps tt = obj.getTimestamps();
    tt.setDeleted(true);
    tt.setDeleted_at(new Date());
    obj.setTimestamps(tt);
    create(obj);
  }
}
