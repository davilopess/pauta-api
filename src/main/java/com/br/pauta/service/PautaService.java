package com.br.pauta.service;


import com.br.pauta.document.Pauta;
import com.br.pauta.document.Voto;
import com.br.pauta.dto.PautaDTO;
import com.br.pauta.dto.SessaoDTO;
import com.br.pauta.dto.VotoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PautaService{
    List<Pauta> findAll();

    PautaDTO findById(String id);

    Pauta save(PautaDTO pautaDTO);
}
