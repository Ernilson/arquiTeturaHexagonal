package br.com.hexoproject.application.core.usecase;

import br.com.hexoproject.application.core.domian.Clients;
import br.com.hexoproject.application.ports.input.FindClientsByIdInputPort;
import br.com.hexoproject.application.ports.output.FindClientsByIdOutPutPort;

public class FindClientsByIdUseCase implements FindClientsByIdInputPort {

    private final FindClientsByIdOutPutPort clients;

    public FindClientsByIdUseCase(FindClientsByIdOutPutPort clients){
        this.clients = clients;
    }
    @Override
    public Clients find(String id){
        return clients.find(id).orElseThrow(()-> new RuntimeException(" O cliente não foi achado!"));
    }
}
