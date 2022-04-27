package com.gazapus.restservice.controller;

import com.gazapus.restservice.entity.TipoComida;
import com.gazapus.restservice.service.TipoComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RequestMapping("/tipo-comida")
public class TipoComidaController {
    @Autowired
    private TipoComidaService tipoComidaService;

    @GetMapping()
    public List<TipoComida> getAll(){
        return tipoComidaService.findAll();
    }

    @GetMapping("/{id}")
    public TipoComida getById(@PathVariable long id){
        return tipoComidaService.findById(id);
    }

}
