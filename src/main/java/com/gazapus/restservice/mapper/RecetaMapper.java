package com.gazapus.restservice.mapper;

import com.gazapus.restservice.dto.RecetaDTO;
import com.gazapus.restservice.entity.Receta;
import org.mapstruct.*;

@Mapper(
		componentModel = "spring",
		injectionStrategy = InjectionStrategy.FIELD,
		uses = {
				IngredienteMapper.class,
				UsuarioMapper.class,
				FotoMapper.class,
				PasoMapper.class
		}
)
public interface RecetaMapper {
	@Mappings({
			@Mapping(target = "id", source = "id"),
			@Mapping(target = "nombre", source = "nombre"),
			@Mapping(target = "descripcion", source = "descripcion")
	})
	@BeanMapping(ignoreByDefault = true)
	Receta mapRecetaEntity(RecetaDTO recetaDTO);

	@Mappings({
			@Mapping(target = "ingredientes", source = "ingredienteRecetas", qualifiedByName = "mapIngredientes"),
	})
	RecetaDTO mapRecetaDTO(Receta receta);
}