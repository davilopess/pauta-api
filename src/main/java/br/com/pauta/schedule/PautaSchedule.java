package br.com.pauta.schedule;

import br.com.pauta.document.Pauta;
import br.com.pauta.service.PautaService;
import br.com.pauta.service.SessaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    AmqpTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Scheduled(fixedDelay = 1000)
    public void closeSessionVerify(){
        List<Pauta> pautasOpen = sessaoService.checkPautasWithOpenSessions();

        pautasOpen.stream().filter(Pauta::sessionExpired).forEach(p -> {
            sessaoService.closeSession(p);
            p.setTimeToClose(null);
            logger.info("Sessão de votação da pauta " + p.getName() + " encerrada.");
            rabbitTemplate.convertAndSend(queue, p);
        });
    }
}
