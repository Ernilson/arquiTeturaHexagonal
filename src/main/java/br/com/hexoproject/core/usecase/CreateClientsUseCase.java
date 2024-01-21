package br.com.hexoproject.core.usecase;

import br.com.hexoproject.core.domian.Clients;
import br.com.hexoproject.ports.output.CreateClientsOutPutPort;
import br.com.hexoproject.ports.output.FindAddressZipCodeOutPutPort;

public class CreateClientsUseCase {

    private final FindAddressZipCodeOutPutPort findAddressZipCodeOutPutPort;
    private final CreateClientsOutPutPort createClientsOutPutPort;

    public CreateClientsUseCase(FindAddressZipCodeOutPutPort findAddressZipCodeOutPutPort,
                                CreateClientsOutPutPort createClientsOutPutPort){
        this.findAddressZipCodeOutPutPort = findAddressZipCodeOutPutPort;
        this.createClientsOutPutPort = createClientsOutPutPort;
    }
    public void creatClient(Clients clients, String zipCode){
        var address = findAddressZipCodeOutPutPort.find(zipCode);
        clients.setAddress(address);
        createClientsOutPutPort.createCLients(clients);
    }
}
