package com.gazapus.restservice.mapper;

import com.gazapus.restservice.dto.IngredienteRecetaDTO;
import com.gazapus.restservice.entity.IngredienteReceta;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredienteMapper {
	@Mappings({
			@Mapping(target = "idIngrediente", source = "ingrediente.id"),
			@Mapping(target = "nombreIngrediente", source = "ingrediente.nombre"),
			@Mapping(target = "idTipoDeIngrediente", source = "ingrediente.tipoIngrediente.id"),
			@Mapping(target = "cantidad", source = "cantidad"),
			@Mapping(target = "idTipoCantidad", source = "tipoCantidad.id")
	})
	@BeanMapping(ignoreByDefault = true)
	@Named("mapIngrediente")
	IngredienteRecetaDTO mapIngrediente(IngredienteReceta ingredienteReceta);

	@Named("mapIngredientes")
	@IterableMapping(qualifiedByName = "mapIngrediente")
	List<IngredienteRecetaDTO> mapIngredientes(List<IngredienteReceta> ingredientesDTO);
/*
	@Mappings({
			@Mapping(target = "tipoCantidad.id", source = "idTipoCantidad"),
			@Mapping(target = "ingrediente.id", source = "idIngrediente"),
			@Mapping(target = "tipoCantidad.id", source = "idTipoCantidad"),
			@Mapping(target = "cantidad", source = "cantidad")
	})
	@BeanMapping(ignoreByDefault = true)
	@Named("mapTipoDeComidaDTO")
	IngredienteReceta mapIngredienteDTO(IngredienteRecetaDTO ingredienteRecetaDTO);

	@IterableMapping(qualifiedByName = "mapTipoDeComidaDTO")
	Set<IngredienteReceta> mapIngredientesDTO(Set<IngredienteRecetaDTO> ingredientesDTO);*/
}
