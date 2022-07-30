package com.gazapus.restservice.dto;

import com.gazapus.restservice.entity.Receta;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

@Data
public class RecetaFilter {
    @QueryParam("texto")
    private String texto;

    @QueryParam("duracionMaxima")
    private int duracionMaxima;

    @QueryParam("tipoComida")
    private int tipoComida;

    @QueryParam("ingrediente")
    private List<Integer> ingredientes;

    @QueryParam("ordenarPor")
    @DefaultValue("fecha")
    private String ordenarPor;

	private Predicate[] createCasoFilterPredicate(CriteriaBuilder cb, Root<Receta> root) {
		List<Predicate> predicates = new ArrayList<>();
		/*if (StringUtils.isNotBlank(texto)) {
			predicates.add(cb.equal(root.join(Receta_.FILIAL, JoinType.LEFT).get(Filial_.CODIGO), filter.getFilial()));
		}/*
		if (!filter.getTipos().isEmpty()) {
			predicates.add(root.join(Caso_.TIPO_CASO, JoinType.LEFT).get(TipoCaso_.CODIGO).in(filter.getTipos()));
		}*/
		return null;
	}
}
