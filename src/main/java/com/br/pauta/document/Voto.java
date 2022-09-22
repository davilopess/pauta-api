package com.br.pauta.document;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Voto {

    private String voto;
    private String associadoCpf;

}

