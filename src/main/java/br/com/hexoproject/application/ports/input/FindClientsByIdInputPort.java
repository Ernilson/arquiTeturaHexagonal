package br.com.hexoproject.application.ports.input;

import br.com.hexoproject.application.core.domian.Clients;

public interface FindClientsByIdInputPort {

    Clients find(String id);
}
