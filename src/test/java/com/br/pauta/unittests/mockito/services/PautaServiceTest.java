package com.br.pauta.unittests.mockito.services;

import com.br.pauta.document.Pauta;
import com.br.pauta.repository.PautaRepository;
import com.br.pauta.service.PautaService;
import com.br.pauta.service.impl.PautaServiceImpl;
import com.br.pauta.unittests.mocks.MockPauta;
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

        assertEquals("Name: 1", result.getName());
        assertEquals(true, result.getSessionOpen());
        assertEquals(false, result.getSessionClosed());
        assertEquals(3, result.getMinutes());
        assertEquals(Instant.EPOCH, result.getTimeToClose());
    }
}
