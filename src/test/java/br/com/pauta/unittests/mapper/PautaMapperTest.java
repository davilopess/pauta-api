package br.com.pauta.unittests.mapper;

import br.com.pauta.mapper.PautaMapper;
import br.com.pauta.unittests.mocks.MockPauta;
import br.com.pauta.document.Pauta;
import br.com.pauta.dto.PautaDTO;
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
