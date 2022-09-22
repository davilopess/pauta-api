package com.br.pauta.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@Builder
public class Pauta {

    @Id
    private String id;
    private String name;
    private Boolean sessionClosed;
    private Boolean sessionOpen;

    @Builder.Default
    private Integer minutes = 1;
    private Instant timeToClose;
    @Builder.Default
    List<Voto> votos = new ArrayList<>();

    public void addVoto(Voto voto){
        votos.add(voto);
    }
}
