package br.com.hexoproject.adapters.output;

import br.com.hexoproject.adapters.output.repository.ClientRepository;
import br.com.hexoproject.adapters.output.repository.mapper.ClientEntityMapper;
import br.com.hexoproject.core.domian.Clients;
import br.com.hexoproject.ports.output.UpdateClientOutPutPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientAdapter implements UpdateClientOutPutPort {

    private final ClientRepository clientRepository;

    private final ClientEntityMapper clientEntityMapper;

    public UpdateClientAdapter(ClientRepository clientRepository, ClientEntityMapper clientEntityMapper){
        this.clientRepository = clientRepository;
        this.clientEntityMapper = clientEntityMapper;
    }

    @Override
    public void update(Clients clients) {

        var clientEntity = clientEntityMapper.toClientyEntity(clients);
        clientRepository.save(clientEntity);


    }
}
