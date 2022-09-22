package com.br.pauta.service.impl;

import com.br.pauta.document.Pauta;
import com.br.pauta.repository.PautaRepository;
import com.br.pauta.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PautaServiceImpl implements PautaService{

        @Autowired
        PautaRepository repository;

        @Override
        public List<Pauta> findAll() {
            return repository.findAll();
        }

        @Override
        public Optional<Pauta> findById(String id) {
            return repository.findById(id);
        }

        @Override
        public Pauta save(Pauta pauta) {
            return repository.save(pauta);
        }
}
