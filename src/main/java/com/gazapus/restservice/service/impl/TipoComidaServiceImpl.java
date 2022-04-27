package com.gazapus.restservice.service.impl;

import com.gazapus.restservice.dao.TipoComidaDao;
import com.gazapus.restservice.entity.TipoComida;
import com.gazapus.restservice.service.TipoComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoComidaServiceImpl implements TipoComidaService {
    @Autowired
    private TipoComidaDao tipoComidaDao;

    @Override
    public List<TipoComida> findAll() {
        return tipoComidaDao.findAll();
    }

    @Override
    public TipoComida findById(long id) {
        return tipoComidaDao.findById(id);
    }
}
