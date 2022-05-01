package com.hotel.services;

import java.util.List;

/**
 * Generic Crud Interface
 *
 * @param <T> Request
 * @param <R> Response
 * @param <I> ID
 */
public interface CrudService<T,R,I> {
    R create(T t);
    List<R> findAll();
    R findById(I id);
    void deleteById(I id);
    R modify(I id, T t);
}