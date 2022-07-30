package com.gazapus.restservice.service.impl;

import com.gazapus.restservice.dao.RecetaDao;
import com.gazapus.restservice.dto.RecetaDTO;
import com.gazapus.restservice.dto.RecetaFilter;
import com.gazapus.restservice.entity.Receta;
import com.gazapus.restservice.exceptions.RepositoryException;
import com.gazapus.restservice.mapper.RecetaMapper;
import com.gazapus.restservice.service.RecetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaServiceImpl implements RecetaService {
	private static final Logger LOG = LoggerFactory.getLogger(RecetaServiceImpl.class);

	@Autowired
    private RecetaDao recetaDao;

	@Autowired
	private RecetaMapper recetaMapper;

	@Override
	public RecetaDTO getById(Integer id) throws RepositoryException {
		Receta receta = recetaDao.getById(id);
		return recetaMapper.mapRecetaDTO(receta);
	}

	@Override
    public List<RecetaDTO> getRecetas(RecetaFilter filter)  {
       return null;
    }
}
