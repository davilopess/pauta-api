package com.br.pauta.controller;

import com.br.pauta.document.Pauta;
import com.br.pauta.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pauta")
public class PautaController {

    @Autowired
    PautaService service;

    @GetMapping
    public List<Pauta> getPautas(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Pauta> getPautaId(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    public Pauta savePauta(@RequestBody Pauta pauta){
        return service.save(pauta);
    }

//    @PostMapping(value = "/open")
//    public Pauta openSession(@RequestBody SessionDTO sessionDTO) {
//        return service.openSession(sessionDTO);
//    }
}
