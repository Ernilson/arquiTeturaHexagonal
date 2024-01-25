package br.com.hexoproject.adapters.input.controller;

import br.com.hexoproject.adapters.input.controller.mapper.ClientMapper;
import br.com.hexoproject.adapters.input.controller.request.ClientRequest;
import br.com.hexoproject.adapters.input.controller.response.ClientsResponse;
import br.com.hexoproject.application.core.domian.Clients;
import br.com.hexoproject.application.ports.input.CreateClientsInputPort;
import br.com.hexoproject.application.ports.input.DeleteClientByIdInputPort;
import br.com.hexoproject.application.ports.input.FindClientsByIdInputPort;
import br.com.hexoproject.application.ports.input.UpdateClientsInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientsController {

    private final CreateClientsInputPort createClientsInputPort;
    private final ClientMapper clientMapper;
    private final FindClientsByIdInputPort findClientsByIdInputPort;
    private final UpdateClientsInputPort updateClientsInputPort;
    private final DeleteClientByIdInputPort deleteClientByIdInputPort;

    public ClientsController(CreateClientsInputPort createClientsInputPort,
                             ClientMapper clientMapper, FindClientsByIdInputPort findClientsByIdInputPort,
                             UpdateClientsInputPort updateClientsInputPort,
                             DeleteClientByIdInputPort deleteClientByIdInputPort){
        this.createClientsInputPort = createClientsInputPort;
        this.clientMapper = clientMapper;
        this.findClientsByIdInputPort = findClientsByIdInputPort;
        this.updateClientsInputPort = updateClientsInputPort;
        this.deleteClientByIdInputPort = deleteClientByIdInputPort;
    }
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ClientRequest request){
        var clients = clientMapper.toClients(request);
         createClientsInputPort.creatClient(clients, request.getZipCode());
         return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientsResponse> findById(@PathVariable final String id){
        var clients = findClientsByIdInputPort.find(id);
        var clientResponse = clientMapper.toClientResponse(clients);
        return ResponseEntity.ok().body(clientResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody ClientRequest clientRequest){
        Clients clients = clientMapper.toClients(clientRequest);
        clients.setId(id);
        updateClientsInputPort.update(clients, clientRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
    deleteClientByIdInputPort.delete(id);
    return ResponseEntity.noContent().build();
    }
}
