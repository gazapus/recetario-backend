package com.gazapus.restservice.mapper;

import com.gazapus.restservice.entity.Foto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FotoMapper {

	@Named("mapFoto")
	default byte[] mapFoto(Foto foto) {
		return foto.getImagen();
	}

	@IterableMapping(qualifiedByName = "mapFoto")
	List<byte[]> mapFotos(List<Foto> fotos);
}
