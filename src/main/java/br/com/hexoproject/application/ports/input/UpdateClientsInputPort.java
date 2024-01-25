package br.com.hexoproject.application.ports.input;

import br.com.hexoproject.application.core.domian.Clients;

public interface UpdateClientsInputPort {

    void update(Clients clients, String zipCode);
}
