package com.gazapus.restservice.controller;

import com.gazapus.restservice.entity.TipoComida;
import com.gazapus.restservice.service.TipoComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RequestMapping("/api")
public class PruebaController {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private TipoComidaService tipoComidaService;

    @GetMapping("/prueba")
    public List<String> getAll(){
        System.out.println("hola");
        return Arrays.asList("prueba", "prueba2");
    }

    @GetMapping("/tipo-comida")
    public List<TipoComida> getAllTipoComida(){
        return tipoComidaService.findAll();
    }

    @GetMapping("/tipo-comida/{id}")
    public TipoComida getTipoComida(@PathVariable long id){
        return tipoComidaService.findById(id);
    }

}
