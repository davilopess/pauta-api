package com.br.pauta.service;

import com.br.pauta.document.Pauta;
import com.br.pauta.document.Voto;
import com.br.pauta.dto.ResultadoDTO;
import com.br.pauta.dto.SessaoDTO;
import com.br.pauta.dto.VotoDTO;

import java.util.List;

public interface SessaoService {

    Pauta openSession(SessaoDTO sessaoDTO);

    Voto addVoteToSession(VotoDTO votoDTO);

    List<Pauta> checkPautasWithOpenSessions();

    Pauta closeSession(Pauta pauta);

    ResultadoDTO resultOfSession(Pauta pauta);

}
