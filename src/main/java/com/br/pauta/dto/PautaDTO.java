package com.br.pauta.dto;

import com.br.pauta.document.Voto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PautaDTO {

    @Id
    private String id;
    private String name;
    private Boolean sessionClosed;
    private Boolean sessionOpen;
    private Integer minutes;
    private Instant timeToClose;
    List<Voto> votos;
}
