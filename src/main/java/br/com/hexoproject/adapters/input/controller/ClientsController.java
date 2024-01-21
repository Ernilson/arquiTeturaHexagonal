package br.com.hexoproject.adapters.input.controller;

import br.com.hexoproject.adapters.input.controller.mapper.ClientMapper;
import br.com.hexoproject.adapters.input.controller.request.ClientRequest;
import br.com.hexoproject.ports.input.CreateClientsInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientsController {

    private final CreateClientsInputPort createClientsInputPort;

    private final ClientMapper clientMapper;

    public ClientsController(CreateClientsInputPort createClientsInputPort,
                             ClientMapper clientMapper){
        this.createClientsInputPort = createClientsInputPort;
        this.clientMapper = clientMapper;
    }
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ClientRequest request){
        var clients = clientMapper.toClients(request);
         createClientsInputPort.creatClient(clients, request.getZipCode());
         return ResponseEntity.ok().build();

    }
}
