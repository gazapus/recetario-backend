package com.gazapus.restservice.mapper;

import com.gazapus.restservice.entity.Paso;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PasoMapper {

	@Named("mapPaso")
	default String mapPaso(Paso paso) {
		return paso.getDescripcion();
	}

	@IterableMapping(qualifiedByName = "mapPaso")
	List<String> mapPasos(List<Paso> pasos);
}
