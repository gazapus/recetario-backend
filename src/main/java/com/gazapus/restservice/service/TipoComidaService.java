package com.gazapus.restservice.service;

import com.gazapus.restservice.entity.TipoComida;

import java.util.List;

public interface TipoComidaService {
    List<TipoComida> findAll();

    TipoComida findById(long id);
}
