package com.br.pauta.service;

import com.br.pauta.document.Pauta;
import com.br.pauta.document.Voto;
import com.br.pauta.dto.SessaoDTO;
import com.br.pauta.dto.VotoDTO;

public interface SessaoService {

    Pauta openSession(SessaoDTO sessaoDTO);

    Voto addVoteToSession(VotoDTO votoDTO);

}
