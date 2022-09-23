package com.br.pauta.schedule;

import com.br.pauta.document.Pauta;
import com.br.pauta.service.PautaService;
import com.br.pauta.service.SessaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
public class PautaSchedule {

    private static final Logger logger = LoggerFactory.getLogger(PautaSchedule.class);

    @Autowired
    PautaService pautaService;

    @Autowired
    SessaoService sessaoService;

    @Scheduled(fixedDelay = 1000)
    public void closeSessionVerify(){
        List<Pauta> pautasOpen = sessaoService.checkPautasWithOpenSessions();

        pautasOpen.stream().filter(Pauta::sessionExpired).forEach(p -> {
            p.setSessionClosed(true);
            sessaoService.closeSession(p);
            logger.info("Sessão de votação da pauta " + p.getName() + " encerrada.");
        });


    }
}
