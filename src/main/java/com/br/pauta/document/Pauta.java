package com.br.pauta.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document
@Data
public class Pauta {

    @Id
    private String id;
    private String name;
    private Boolean sessionClosed;
    private Boolean sessionOpen;
    private Integer minutes;
    private Instant timeToClose;
    List<Voto> votos;
}
