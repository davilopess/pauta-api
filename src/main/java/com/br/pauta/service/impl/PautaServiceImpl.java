package com.br.pauta.service.impl;

import com.br.pauta.document.Pauta;
import com.br.pauta.document.Voto;
import com.br.pauta.dto.PautaDTO;
import com.br.pauta.dto.SessaoDTO;
import com.br.pauta.dto.VotoDTO;
import com.br.pauta.repository.PautaRepository;
import com.br.pauta.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
        public Pauta save(PautaDTO pautaDTO) {
            Pauta pauta = Pauta.builder()
                    .name(pautaDTO.getName())
                    .sessionClosed(false)
                    .sessionOpen(false)
                    .build();
            return repository.save(pauta);
        }
}
