package com.br.pauta.service;


import com.br.pauta.document.Pauta;

import java.util.List;
import java.util.Optional;

public interface PautaService{
    List<Pauta> findAll();

    Optional<Pauta> findById(String id);

    Pauta save(Pauta pauta);
}
