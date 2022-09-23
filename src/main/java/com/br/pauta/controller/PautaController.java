package com.br.pauta.controller;

import com.br.pauta.document.Pauta;
import com.br.pauta.document.Voto;
import com.br.pauta.dto.PautaDTO;
import com.br.pauta.dto.SessaoDTO;
import com.br.pauta.dto.VotoDTO;
import com.br.pauta.service.PautaService;
import com.br.pauta.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pauta")
public class PautaController {

    @Autowired
    PautaService service;

    @Autowired
    SessaoService sessaoService;

    @GetMapping
    public List<PautaDTO> getPautas(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public PautaDTO getPautaId(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    public PautaDTO savePauta(@RequestBody PautaDTO pautaDTO){
        return service.save(pautaDTO);
    }

    @PutMapping(value = "/sessao")
    public Pauta openSession(@RequestBody SessaoDTO sessaoDTO) {
        return sessaoService.openSession(sessaoDTO);
    }

    @PutMapping(value = "/sessao/voto")
    public Voto addVoteToSession(@RequestBody VotoDTO votoDTO) {
        return sessaoService.addVoteToSession(votoDTO);
    }
}
