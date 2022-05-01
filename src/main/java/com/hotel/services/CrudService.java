package com.hotel.services;

import java.util.List;

/**
 * Generic Crud Interface
 *
 * @param <T,I>
 */
public interface CrudService<T,I> {
    T create(T t);
    List<T> findAll();
    T findById(I id);
    void deleteById(I id);
    T modify(I id, T t);
}