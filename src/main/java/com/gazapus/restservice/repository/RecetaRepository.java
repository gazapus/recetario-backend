package com.gazapus.restservice.repository;

import com.gazapus.restservice.entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("recetaRepository")
public interface RecetaRepository extends JpaRepository<Receta, Serializable> {
}
