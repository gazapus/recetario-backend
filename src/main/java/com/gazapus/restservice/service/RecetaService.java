package com.gazapus.restservice.service;

import com.gazapus.restservice.dto.RecetaDTO;
import com.gazapus.restservice.dto.RecetaFilter;
import com.gazapus.restservice.exceptions.RepositoryException;

import java.util.List;

public interface RecetaService {

	RecetaDTO getById(Integer id) throws RepositoryException;

    List<RecetaDTO> getRecetas(RecetaFilter filter) throws Exception;
}
