package br.com.hexoproject.adapters.output;

import br.com.hexoproject.adapters.output.repository.ClientRepository;
import br.com.hexoproject.adapters.output.repository.mapper.ClientEntityMapper;
import br.com.hexoproject.application.core.domian.Clients;
import br.com.hexoproject.application.ports.output.CreateClientsOutPutPort;
import org.springframework.stereotype.Component;

@Component
public class InsertClientsAdpter implements CreateClientsOutPutPort {

    private final ClientRepository repository;

    private final ClientEntityMapper clientEntityMapper;

public InsertClientsAdpter(ClientRepository repository, ClientEntityMapper clientEntityMapper){
    this.repository = repository;
    this.clientEntityMapper = clientEntityMapper;
}

    @Override
    public void createCLients(Clients clients) {
        var clientEntity = clientEntityMapper.toClientyEntity(clients);
        repository.save(clientEntity);
    }
}
