package com.gazapus.restservice.dao;

import com.gazapus.restservice.entity.TipoComida;

import java.util.List;

public interface TipoComidaDao {
    List<TipoComida> findAll();

    TipoComida findById(long id);
}
