package com.tyjohntompson.springgodpetclinic.service;

import java.util.Set;

//CRUD Repository mimic

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
