/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tech.seekback.exceptions.ConnectionExcep;

/**
 *
 * @author camorenoc
 */
public abstract class GenericDAO<T, PK> implements DAO<T, PK> {

  public static final String PU = "Seekback_PU";

  @PersistenceContext(unitName = PU)
  protected EntityManager em;
  protected Class<T> classType;

  public GenericDAO(Class<T> classType) {
    //  EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
    /// em = emf.createEntityManager();
    this.classType = classType;
  }

  @Override
  public void create(T obj) throws ConnectionExcep {
    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t Creando Objeto " + obj.getClass().getSimpleName()
            + "\n######################################################################\n"
    );
    em.persist(em.merge(obj));

//    EntityTransaction et = em.getTransaction();
//    try {
//      et.begin();
//      em.persist(em.merge(obj));
//      et.commit();
//    } catch (Exception e) {
//      et.rollback();
//    }
  }

  @Override
  public T getOne(PK id) throws ConnectionExcep {
    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t Consultando el objeto No. " + id
            + " de " + this.classType.getSimpleName()
            + "\n######################################################################\n"
    );
    return em.find(this.classType, id);
  }

  @Override
  public List<T> getAll() throws ConnectionExcep {
    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t Consultando todos los objetos de " + this.classType.getSimpleName()
            + "\n######################################################################\n"
    );
    TypedQuery<T> tq = em.createNamedQuery(classType.getSimpleName() + ".getAll", classType);
    return tq.getResultList();
  }

  @Override
  public void update(T obj) throws ConnectionExcep {
    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t Actualizando el objeto " + this.classType.getSimpleName()
            + "\n######################################################################\n"
    );
    create(obj);
  }

  @Override
  public void delete(PK id) throws ConnectionExcep {
    System.out.println(
            "\n\n\n\n\n######################################################################"
            + "\n#\t Eliminando el objeto No. " + id
            + " de " + this.classType.getSimpleName()
            + "\n######################################################################\n"
    );
    T obj = getOne(id);
    em.remove(obj);
  }
}
