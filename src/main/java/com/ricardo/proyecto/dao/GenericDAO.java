package com.ricardo.proyecto.dao;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author ricardotoledo
 */
public interface GenericDAO<T, PK extends Serializable> {
    void save(T t);
    T findById(PK id);
    void update(T t);
    void delete(T t);
    List<T> list();
}