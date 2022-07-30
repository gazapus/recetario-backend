package com.gazapus.restservice.dao.impl;

import com.gazapus.restservice.dao.TipoComidaDao;
import com.gazapus.restservice.entity.TipoComida;
import com.gazapus.restservice.repository.TipoComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoComidaDaoImpl implements TipoComidaDao {

    @Autowired
    private TipoComidaRepository tipoComidaRepository;

    @Override
    public List<TipoComida> findAll() {
        return tipoComidaRepository.findAll();
    }

    @Override
    public TipoComida findById(long id) {
        return tipoComidaRepository.findById(id).orElse(null);
    }
}

/*
  CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(TipoComida.class, id);

        CriteriaQuery<TipoComida> cq = cb.createQuery(TipoComida.class);
        Root<TipoComida> root = cq.from(TipoComida.class);
        cq.select(root);
 */