package com.br.pauta.service.impl;

import com.br.pauta.document.Pauta;
import com.br.pauta.document.Voto;
import com.br.pauta.dto.SessaoDTO;
import com.br.pauta.dto.VotoDTO;
import com.br.pauta.repository.PautaRepository;
import com.br.pauta.service.SessaoService;
import com.br.pauta.service.ValidarCpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class SessaoServiceImpl implements SessaoService {

    @Autowired
    PautaRepository pautaRepository;

    @Autowired
    ValidarCpf validarCpf;

    @Override
    public Pauta openSession(SessaoDTO sessaoDTO) {
        Pauta pauta = pautaRepository.findById(sessaoDTO.getPautaId())
                .orElseThrow();

        if(pauta.getSessionOpen() == false){
            pauta.setMinutes(sessaoDTO.getMinutes() != null ? sessaoDTO.getMinutes() : pauta.getMinutes());
            pauta.setTimeToClose(Instant.now().plusSeconds(pauta.getMinutes() * 60));
            pauta.setSessionOpen(true);
        }

        return pautaRepository.save(pauta);
    }

    @Override
    public Voto addVoteToSession(VotoDTO votoDTO){
        Pauta pauta = pautaRepository.findById(votoDTO.getPautaId())
                .orElseThrow();

        Voto voto = new Voto();
        voto.setVoto(votoDTO.getVoto());
        voto.setAssociadoCpf(votoDTO.getAssociadoCpf());
        pauta.addVoto(voto);

        pautaRepository.save(pauta);
        return voto;
    }

    @Override
    public List<Pauta> checkPautasWithOpenSessions(){
        return pautaRepository.findBySessionOpenTrueAndSessionClosedFalse();
    }

    @Override
    public Pauta closeSession(Pauta pauta) {
        return pautaRepository.save(pauta);
    }


}
