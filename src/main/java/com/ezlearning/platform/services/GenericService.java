package com.ezlearning.platform.services;

import java.util.List;

public interface GenericService<T, K> {

    void create(T t);

    void update(T t);

    void delete(T t);

    List<T> findAll();

    T findById(K k);

}
