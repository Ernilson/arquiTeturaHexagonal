package br.com.hexoproject.application.ports.output;

import br.com.hexoproject.application.core.domian.Clients;

import java.util.Optional;

public interface FindClientsByIdOutPutPort {

    Optional<Clients> find(String id);

}
