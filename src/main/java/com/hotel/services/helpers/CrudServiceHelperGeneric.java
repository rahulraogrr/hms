package com.hotel.services.helpers;

import java.util.List;

/**
 * Service Helper Generic
 *
 * @param <T> Request
 * @param <R> Response
 * @param <I> ID
 *
 * @author rgonda
 */
public interface CrudServiceHelperGeneric<T,R,I> {
    R create(T t);
    List<R> findAll(int page, int size);
    R findById(I id);
    boolean deleteById(I id);
    R modify(I id, T t);
}
