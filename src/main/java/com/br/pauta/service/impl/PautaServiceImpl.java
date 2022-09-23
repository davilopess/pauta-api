package com.br.pauta.service.impl;

import com.br.pauta.document.Pauta;
import com.br.pauta.document.Voto;
import com.br.pauta.dto.PautaDTO;
import com.br.pauta.dto.SessaoDTO;
import com.br.pauta.dto.VotoDTO;
import com.br.pauta.mapper.PautaMapper;
import com.br.pauta.repository.PautaRepository;
import com.br.pauta.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PautaServiceImpl implements PautaService{

        @Autowired
        PautaRepository repository;

        @Override
        public List<PautaDTO> findAll() {
            return repository.findAll().stream().map(p -> PautaMapper.toDto(p)).collect(Collectors.toList());
        }

        @Override
        public PautaDTO findById(String id) {
            Pauta pauta = repository.findById(id).orElseThrow();
            return PautaMapper.toDto(pauta);
        }

        @Override
        public PautaDTO save(PautaDTO pautaDTO) {
            Pauta pauta = Pauta.builder()
                    .name(pautaDTO.getName())
                    .sessionClosed(false)
                    .sessionOpen(false)
                    .build();
            return PautaMapper.toDto(repository.save(pauta));
        }
}
