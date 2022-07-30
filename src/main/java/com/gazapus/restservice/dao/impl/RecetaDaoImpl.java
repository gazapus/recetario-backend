package com.gazapus.restservice.dao.impl;

import com.gazapus.restservice.dao.RecetaDao;
import com.gazapus.restservice.dto.RecetaFilter;
import com.gazapus.restservice.entity.Receta;
import com.gazapus.restservice.exceptions.RepositoryException;

import com.gazapus.restservice.repository.RecetaRepository;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.*;

import java.util.List;
import java.util.Optional;

@Repository
public class RecetaDaoImpl implements RecetaDao {

	@Autowired
	private RecetaRepository recetaRepository;

	@PersistenceContext(unitName = "recetario")
	protected EntityManager entityManager;

	@Override
	public Receta getById(Integer id) throws RepositoryException {
		Optional<Receta> receta = recetaRepository.findById(id);
		if(receta.isEmpty())
			throw new RepositoryException("No se encontr\u00F3 receta con id " + id);
		return receta.get();
	}

	@Override
	public List<Receta> findAll() {
		return recetaRepository.findAll();
	}

	@Override
    public List<Receta> getRecetas(RecetaFilter filter) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Receta> query = cb.createQuery(Receta.class);
		Root<Receta> caso = query.from(Receta.class);
		query.distinct(true).where();
		/*countQuery
				.select(cb.countDistinct(caso.get(Caso_.ID)))
				.where(createCasoFilterPredicate(cb, caso, filter));

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(classz);
		Root<T> root = cq.from(classz);
		return entityManager.createQuery(cq).getResultList();

		CriteriaQuery<TipoComida> cq = cb.createQuery(TipoComida.class);
		Root<TipoComida> root = cq.from(TipoComida.class);
		cq.select(root);*/
        return null;
    }
}
