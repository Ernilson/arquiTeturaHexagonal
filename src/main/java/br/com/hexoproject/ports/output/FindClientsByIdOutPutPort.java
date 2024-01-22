package br.com.hexoproject.ports.output;

import br.com.hexoproject.core.domian.Clients;

import java.util.Optional;

public interface FindClientsByIdOutPutPort {

    Optional<Clients> find(String id);

}
