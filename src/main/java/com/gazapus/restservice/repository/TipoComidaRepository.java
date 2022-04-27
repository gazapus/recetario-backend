package com.gazapus.restservice.repository;

import com.gazapus.restservice.entity.TipoComida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("tipoComidaRepository")
public interface TipoComidaRepository  extends JpaRepository<TipoComida, Serializable> {

}
