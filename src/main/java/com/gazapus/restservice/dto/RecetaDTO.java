package com.gazapus.restservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecetaDTO {
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Set<TipoComidaDTO> tiposDeComida;
	private List<IngredienteRecetaDTO> ingredientes;
	private List<byte[]> fotos;
	private List<String> pasos;
	private LocalDate fechaCreacion;
	private UsuarioDTO usuario;
}
