package com.br.pauta.service.impl;

import com.br.pauta.dto.CpfResponseDTO;
import com.br.pauta.exceptions.ResourceNotFoundException;
import com.br.pauta.exceptions.RestTemplateResponseErrorHandler;
import com.br.pauta.service.ValidarCpf;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Service
public class ValidarCpfImpl implements ValidarCpf {
    @Override
    public boolean validar(String cpf) {
        String uri = "https://user-info.herokuapp.com/users/{cpf}";
        RestTemplate restTemplate = new RestTemplateBuilder()
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();

       CpfResponseDTO result = restTemplate.getForObject(uri, CpfResponseDTO.class, cpf);

        return result.getStatus().equals("ABLE_TO_VOTE") ? true : false;
    }
}
