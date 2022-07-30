package com.gazapus.restservice.dto;

import lombok.Data;

@Data
public class IngredienteRecetaDTO {
	private Integer idIngrediente;
	private String nombreIngrediente;
	private Integer idTipoDeIngrediente;
	private Double cantidad;
	private Integer idTipoCantidad;
}
