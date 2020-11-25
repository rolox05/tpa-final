package com.example.persona.services;

import com.example.persona.entities.Base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base , ID extends Serializable> {
    //GET ALL
    public List<E> findAll() throws Exception;

    //GET JUST ONE
    public E findById(ID id) throws Exception;

    //POST
    public E save(E entity) throws Exception;

    //PUT
    public E update(ID id, E entity) throws Exception;

    //DELETE
    public boolean delete(ID id) throws Exception;
}
