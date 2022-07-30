package com.gazapus.restservice.dao;

import com.gazapus.restservice.dto.RecetaFilter;
import com.gazapus.restservice.entity.Receta;
import com.gazapus.restservice.exceptions.RepositoryException;

import java.util.List;

public interface RecetaDao {

	Receta getById(Integer id) throws RepositoryException;

	List<Receta> findAll();

	List<Receta> getRecetas(RecetaFilter filter) throws RepositoryException;
}
