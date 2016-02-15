package com.ricardo.proyecto.dao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author ricardotoledo
 */
public class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {
    @PersistenceContext
    private EntityManager em;
    private Class<T> clazz;
    public GenericDAOImpl(Class<T> clazz) {
		this.clazz = clazz;
    }
    @Override
    public void save(T t) {
        em.persist(t);
    }

    @Override
    public T findById(PK id) {
        try {
            String sql = "select t from " + clazz.getSimpleName() + " t WHERE t.id =" + id;
            Query query = em.createQuery(sql);
            T t = (T) query.getSingleResult();
            return t;
        } catch (NoResultException ex) {
            return null;
        }

    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public void delete(T t) {
        em.remove(em.merge(t));
    }

    @Override
    public List<T> list() {
        String sql = "select t from" + clazz.getSimpleName() + "t";
        Query query = em.createQuery(sql);
        List<T> list = query.getResultList();
        return list;
    }

}
