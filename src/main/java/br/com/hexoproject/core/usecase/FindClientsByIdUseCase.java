package br.com.hexoproject.core.usecase;

import br.com.hexoproject.core.domian.Clients;
import br.com.hexoproject.ports.input.FindClientsByIdInputPort;
import br.com.hexoproject.ports.output.FindClientsByIdOutPutPort;

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
