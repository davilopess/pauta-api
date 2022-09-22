package com.br.pauta.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class SessaoDTO {

    @NonNull
    private String pautaId;

    @NonNull
    @Builder.Default
    private Integer minutes = 1;

}
