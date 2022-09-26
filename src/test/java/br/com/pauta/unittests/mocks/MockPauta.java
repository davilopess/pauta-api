package br.com.pauta.unittests.mocks;

import br.com.pauta.document.Pauta;
import br.com.pauta.dto.PautaDTO;

import java.time.Instant;

public class MockPauta {

    public Pauta mockEntity(Integer number) {
        return Pauta.builder()
                .id("632d176f1de60811f7a3ff34")
                .name("Name: " + number)
                .sessionOpen(true)
                .sessionClosed(false)
                .minutes(3)
                .timeToClose(Instant.EPOCH)
                .build();
    }

    public PautaDTO mockDto(Integer number) {
        return PautaDTO.builder()
                .id("632d176f1de60811f7a3ff34")
                .name("Name: " + number)
                .sessionOpen(true)
                .sessionClosed(false)
                .minutes(3)
                .timeToClose(Instant.EPOCH)
                .build();
    }

}
