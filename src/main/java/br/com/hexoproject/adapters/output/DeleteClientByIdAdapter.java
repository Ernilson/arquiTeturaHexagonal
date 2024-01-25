package br.com.hexoproject.adapters.output;

import br.com.hexoproject.adapters.output.repository.ClientRepository;
import br.com.hexoproject.application.ports.output.DeleteClientByIdOutPutPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteClientByIdAdapter implements DeleteClientByIdOutPutPort {

    private final ClientRepository clientRepository;

    public DeleteClientByIdAdapter(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public void delete(String id) {
        clientRepository.deleteById(id);

    }
}
