package br.com.hexoproject.adapters.input.controller;

import br.com.hexoproject.adapters.input.controller.mapper.ClientMapper;
import br.com.hexoproject.adapters.input.controller.request.ClientRequest;
import br.com.hexoproject.adapters.input.controller.response.ClientsResponse;
import br.com.hexoproject.ports.input.CreateClientsInputPort;
import br.com.hexoproject.ports.input.FindClientsByIdInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientsController {

    private final CreateClientsInputPort createClientsInputPort;

    private final ClientMapper clientMapper;

    private final FindClientsByIdInputPort findClientsByIdInputPort;

    public ClientsController(CreateClientsInputPort createClientsInputPort,
                             ClientMapper clientMapper, FindClientsByIdInputPort findClientsByIdInputPort){
        this.createClientsInputPort = createClientsInputPort;
        this.clientMapper = clientMapper;
        this.findClientsByIdInputPort = findClientsByIdInputPort;
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
}
