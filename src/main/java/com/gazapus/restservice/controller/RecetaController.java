package com.gazapus.restservice.controller;

import com.gazapus.restservice.dto.RecetaDTO;
import com.gazapus.restservice.dto.RecetaFilter;
import com.gazapus.restservice.exceptions.RepositoryException;
import com.gazapus.restservice.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RequestMapping("/recetas")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

	@GetMapping("/{recetaId}")
	@Produces(MediaType.APPLICATION_JSON)
	public RecetaDTO getReceta(@PathVariable("recetaId") Integer recetaId){
		try {
			return recetaService.getById(recetaId);
		} catch (RepositoryException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Receta no encontrada", e);
		}
	}

    @GetMapping("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public List<RecetaDTO> getRecetas(@BeanParam RecetaFilter filter){
        try {
           	return recetaService.getRecetas(filter);
        } catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al traer recetas");
		}
    }
}
