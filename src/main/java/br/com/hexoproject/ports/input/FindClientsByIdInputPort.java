package br.com.hexoproject.ports.input;

import br.com.hexoproject.core.domian.Clients;

public interface FindClientsByIdInputPort {

    Clients find(String id);
}
