package br.com.hexoproject.application.core.usecase;

import br.com.hexoproject.application.ports.input.DeleteClientByIdInputPort;
import br.com.hexoproject.application.ports.input.FindClientsByIdInputPort;
import br.com.hexoproject.application.ports.output.DeleteClientByIdOutPutPort;

public class DeleteClientByIdUseCase implements DeleteClientByIdInputPort {

    private final FindClientsByIdInputPort findClientsByIdInputPort;
    private final DeleteClientByIdOutPutPort deleteClientByIdOutPutPort;

    public DeleteClientByIdUseCase(FindClientsByIdInputPort findClientsByIdInputPort,
                                   DeleteClientByIdOutPutPort deleteClientByIdOutPutPort){
        this.findClientsByIdInputPort = findClientsByIdInputPort;
        this.deleteClientByIdOutPutPort = deleteClientByIdOutPutPort;
    }

    @Override
    public void delete(String id){
        findClientsByIdInputPort.find(id);
        deleteClientByIdOutPutPort.delete(id);

    }
}
