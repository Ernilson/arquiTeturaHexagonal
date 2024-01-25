package br.com.hexoproject.application.core.usecase;

import br.com.hexoproject.application.core.domian.Clients;
import br.com.hexoproject.application.ports.input.FindClientsByIdInputPort;
import br.com.hexoproject.application.ports.input.UpdateClientsInputPort;
import br.com.hexoproject.application.ports.output.FindAddressZipCodeOutPutPort;
import br.com.hexoproject.application.ports.output.UpdateClientOutPutPort;

public class UpdateClientUseCase implements UpdateClientsInputPort {

    private final FindClientsByIdInputPort findClientsByIdInputPort;

    private final FindAddressZipCodeOutPutPort findAddressZipCodeOutPutPort;

    private final UpdateClientOutPutPort updateClientOutPutPort;

    public UpdateClientUseCase(FindClientsByIdInputPort findClientsByIdInputPort,
                               FindAddressZipCodeOutPutPort findAddressZipCodeOutPutPort,
                               UpdateClientOutPutPort updateClientOutPutPort
    ){
        this.findClientsByIdInputPort = findClientsByIdInputPort;
        this.findAddressZipCodeOutPutPort = findAddressZipCodeOutPutPort;
        this.updateClientOutPutPort = updateClientOutPutPort;
    }

    @Override
    public void update(Clients clients, String zipCode){
        findClientsByIdInputPort.find(clients.getId());
        var address = findAddressZipCodeOutPutPort.find(zipCode);
        clients.setAddress(address);
        updateClientOutPutPort.update(clients);

    }
}
