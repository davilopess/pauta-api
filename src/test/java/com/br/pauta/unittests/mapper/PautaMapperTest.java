package com.br.pauta.unittests.mapper;

import com.br.pauta.document.Pauta;
import com.br.pauta.dto.PautaDTO;
import com.br.pauta.mapper.PautaMapper;
import com.br.pauta.unittests.mocks.MockPauta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PautaMapperTest {
    MockPauta inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPauta();
    }

    @Test
    public void parseEntityToDtoTest() {
        PautaDTO output = PautaMapper.toDto(inputObject.mockEntity(1));
        assertEquals("632d176f1de60811f7a3ff34", output.getId());
        assertEquals("Name: 1", output.getName());
        assertEquals(true, output.getSessionOpen());
        assertEquals(false, output.getSessionClosed());
        assertEquals(3, output.getMinutes());
        assertEquals(Instant.EPOCH, output.getTimeToClose());
    }

    @Test
    public void parseDtoToEntityTest() {
        Pauta output = PautaMapper.toEntity(inputObject.mockDto(1));
        assertEquals("632d176f1de60811f7a3ff34", output.getId());
        assertEquals("Name: 1", output.getName());
        assertEquals(true, output.getSessionOpen());
        assertEquals(false, output.getSessionClosed());
        assertEquals(3, output.getMinutes());
        assertEquals(Instant.EPOCH, output.getTimeToClose());
    }
}
