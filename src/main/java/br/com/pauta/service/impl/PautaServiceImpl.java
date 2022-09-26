package br.com.pauta.service.impl;

import br.com.pauta.document.Pauta;
import br.com.pauta.dto.PautaDTO;
import br.com.pauta.mapper.PautaMapper;
import br.com.pauta.repository.PautaRepository;
import br.com.pauta.service.PautaService;
import br.com.pauta.exceptions.RequiredObjectIsNullException;
import br.com.pauta.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PautaServiceImpl implements PautaService {

        @Autowired
        PautaRepository repository;

        @Override
        public List<PautaDTO> findAll() {
            return repository.findAll().stream().map(p -> PautaMapper.toDto(p)).collect(Collectors.toList());
        }

        @Override
        public PautaDTO findById(String id) {
            Pauta pauta = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Pauta nao informada para esse ID!"));
            return PautaMapper.toDto(pauta);
        }

        @Override
        public PautaDTO save(PautaDTO pautaDTO) {

            if (pautaDTO== null) throw new RequiredObjectIsNullException();

            Pauta pauta = Pauta.builder()
                    .name(pautaDTO.getName())
                    .sessionClosed(false)
                    .sessionOpen(false)
                    .build();
            return PautaMapper.toDto(repository.save(pauta));
        }
}
