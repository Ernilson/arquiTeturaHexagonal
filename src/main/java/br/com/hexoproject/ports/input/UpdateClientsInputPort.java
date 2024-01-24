package br.com.hexoproject.ports.input;

import br.com.hexoproject.core.domian.Clients;

public interface UpdateClientsInputPort {

    void update(Clients clients, String zipCode);
}
