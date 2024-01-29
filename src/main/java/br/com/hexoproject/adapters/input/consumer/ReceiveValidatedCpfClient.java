package br.com.hexoproject.adapters.input.consumer;

import br.com.hexoproject.adapters.input.consumer.mapper.ClientMessageMapper;
import br.com.hexoproject.adapters.input.consumer.message.ClientMessage;
import br.com.hexoproject.application.ports.input.UpdateClientsInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfClient {

    @Autowired
    private UpdateClientsInputPort updateClientsInputPort;
    @Autowired
    private ClientMessageMapper clientMessageMapper;

    @KafkaListener(topics = "tc-cpf-validated", groupId = "test")
    public void receive(ClientMessage clientMessage){
        var client = clientMessageMapper.toclients(clientMessage);
        updateClientsInputPort.update(client, clientMessage.getZipCode());

    }
}
