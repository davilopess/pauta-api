package br.com.pauta.unittests.mockito.services;

import br.com.pauta.document.Pauta;
import br.com.pauta.repository.PautaRepository;
import br.com.pauta.service.impl.PautaServiceImpl;
import br.com.pauta.unittests.mocks.MockPauta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.mockito.Mockito.when;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PautaServiceTest {

    MockPauta input;

    @InjectMocks
    private PautaServiceImpl service;

    @Mock
    PautaRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockPauta();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Pauta entity = input.mockEntity(1);
        entity.setId("632d176f1de60811f7a3ff34");

        when(repository.findById("632d176f1de60811f7a3ff34")).thenReturn(Optional.of(entity));

        var result = service.findById("632d176f1de60811f7a3ff34");
        assertNotNull(result);
        assertNotNull(result.getName());

        Assertions.assertEquals("Name: 1", result.getName());
        Assertions.assertEquals(true, result.getSessionOpen());
        Assertions.assertEquals(false, result.getSessionClosed());
        Assertions.assertEquals(3, result.getMinutes());
        Assertions.assertEquals(Instant.EPOCH, result.getTimeToClose());
    }
}
