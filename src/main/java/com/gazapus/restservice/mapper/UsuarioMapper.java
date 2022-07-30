package com.gazapus.restservice.mapper;

import com.gazapus.restservice.dto.UsuarioDTO;
import com.gazapus.restservice.entity.Usuario;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	@Mappings({
			@Mapping(target = "id", source = "id"),
			@Mapping(target = "nombre", source = "nombre"),
			@Mapping(target = "alias", source = "alias")
	})
	@BeanMapping(ignoreByDefault = true)
	UsuarioDTO mapUsuarioDTO(Usuario usuario);
}
