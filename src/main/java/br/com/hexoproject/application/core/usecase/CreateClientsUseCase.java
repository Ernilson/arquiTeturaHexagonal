package br.com.hexoproject.application.core.usecase;

import br.com.hexoproject.application.core.domian.Clients;
import br.com.hexoproject.application.ports.input.CreateClientsInputPort;
import br.com.hexoproject.application.ports.output.CreateClientsOutPutPort;
import br.com.hexoproject.application.ports.output.FindAddressZipCodeOutPutPort;
import br.com.hexoproject.application.ports.output.SendCpfForValidationOutPutPort;

public class CreateClientsUseCase implements CreateClientsInputPort {

    private final FindAddressZipCodeOutPutPort findAddressZipCodeOutPutPort;
    private final CreateClientsOutPutPort createClientsOutPutPort;

    private final SendCpfForValidationOutPutPort sendCpfForValidationOutPutPort;

    public CreateClientsUseCase(FindAddressZipCodeOutPutPort findAddressZipCodeOutPutPort,
                                CreateClientsOutPutPort createClientsOutPutPort,
                                SendCpfForValidationOutPutPort sendCpfForValidationOutPutPort){
        this.findAddressZipCodeOutPutPort = findAddressZipCodeOutPutPort;
        this.createClientsOutPutPort = createClientsOutPutPort;
        this.sendCpfForValidationOutPutPort = sendCpfForValidationOutPutPort;
    }
    @Override
    public void creatClient(Clients clients, String zipCode){
        var address = findAddressZipCodeOutPutPort.find(zipCode);
        clients.setAddress(address);
        createClientsOutPutPort.createCLients(clients);
        sendCpfForValidationOutPutPort.send(clients.getCpf());
    }
}
