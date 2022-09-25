package com.br.pauta.consumer;

import com.br.pauta.document.Pauta;
import com.br.pauta.dto.ResultadoDTO;
import com.br.pauta.service.SessaoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ResultConsumer {

    @Autowired
    SessaoService sessaoService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload Pauta pauta) {
        ResultadoDTO resultado = sessaoService.resultOfSession(pauta);
        System.out.println("Com " + resultado.total() + " votos, o resultado da pauta "
                + pauta.getName() + " foi contabilizado em: " + resultado.getVotoSim()+ " (Sim) e " + resultado.getVotoNao() + " (Não).");
    }
}
