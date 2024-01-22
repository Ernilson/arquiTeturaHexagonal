package br.com.hexoproject.adapters.output;

import br.com.hexoproject.adapters.output.repository.ClientRepository;
import br.com.hexoproject.adapters.output.repository.mapper.ClientEntityMapper;
import br.com.hexoproject.core.domian.Clients;
import br.com.hexoproject.ports.output.FindClientsByIdOutPutPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindByIdClientsAdapter implements FindClientsByIdOutPutPort {

    private ClientRepository repository;

    private ClientEntityMapper clientEntityMapper;

    public FindByIdClientsAdapter(ClientRepository repository, ClientEntityMapper clientEntityMapper){
        this.repository = repository;
        this.clientEntityMapper = clientEntityMapper;
    }

    @Override
    public Optional<Clients> find(String id) {
        var clientEntity = repository.findById(id);
        return clientEntity.map(entity -> clientEntityMapper.toClientsDomain(entity) );
    }
}
